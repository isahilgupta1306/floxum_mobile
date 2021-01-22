package com.artopher.floxum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.artopher.floxum.ApiClasses.ApiClients.ApiClientAddEvent;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class EventForm extends AppCompatActivity {
    TextInputEditText EventDateEditText , EventTime , EventTitle , ContactNumber , EventLink , EventLocation , EventDescription;
    TextInputLayout EventDateTextLayout , EventTimeTextLayout , EventTitleTextLayout ,
            ContactNumberTextLayout , EventLinkTextLayout , EventLocationTextLayout , EventDescriptionTextLayout;
    MaterialButton AddImage , SubmitButton ;
    ImageView image1 , image2 , image3 , image4 ;

    private ArrayList<Uri> imageUris ;
    //Request code to pick image
    private static  final  int PICK_IMAGES_CODE = 0;
    //Position of selected image
    int position = 0;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_form);

        //Hooks of EditText
        EventDateEditText = findViewById(R.id.event_date);
        EventTime = findViewById(R.id.event_time);
        EventTitle = findViewById(R.id.event_title);
        ContactNumber = findViewById(R.id.contact_number);
        EventLink = findViewById(R.id.event_link);
        EventLocation = findViewById(R.id.event_location);
        EventDescription = findViewById(R.id.event_Description);
        //Hooks of Textinput Layout
        EventDateTextLayout = findViewById(R.id.eventdate);
        EventTimeTextLayout = findViewById(R.id.eventtime);
        //Buttons
        SubmitButton = findViewById(R.id.submit_button);
        AddImage = findViewById(R.id.add_Photo);
        //ImageViews
        image1 = findViewById(R.id.photo1);
        image2 = findViewById(R.id.photo2);
        image3 = findViewById(R.id.photo3);
        image4 = findViewById(R.id.photo4);

        //Initialisation of list
        imageUris = new ArrayList<>();










       //Code for TimePicker
        EventTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(EventForm.this , "Click succesfull" , Toast.LENGTH_SHORT);
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(EventForm.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        EventTime.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });



        //Code of DatePicker
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        EventDateEditText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(EventForm.this , "Click succesfull" , Toast.LENGTH_SHORT);
                new DatePickerDialog(EventForm.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        AddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageIntent();
            }
        });

        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit_form();
            }
        });





    }

    private void submit_form() {
        String eventTitle = EventTitle.getText().toString().trim() ;
        String link = EventLink.getText().toString().trim();
        String location = EventLocation.getText().toString().trim();
        String contact = ContactNumber.getText().toString().trim();
        String date = EventDateEditText.getText().toString().trim();
        String time = EventTime.getText().toString().trim();
        String description = EventDescription.getText().toString().trim();

        //String category = EventLink.getText().toString().trim();


//        Call<ResponseBody> call = ApiClientAddEvent
//                .getInstance()
//                .getApi()
//                .AddEvent(eventTitle , link , location , contact , date , time , description , );
    }


    //For DatePicker
    private void updateLabel() {
        String myFormat = "yy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        EventDateEditText.setText(sdf.format(myCalendar.getTime()));
    }

    private void pickImageIntent(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE , true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent , "Select image(s)") , PICK_IMAGES_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( requestCode == PICK_IMAGES_CODE){
            if(resultCode == Activity.RESULT_OK){
                if(data.getClipData() != null){
                    //if picked multiple images
                   // int count = 4;
                  int count= data.getClipData().getItemCount(); //number of picked image
                    for (int i = 0 ; i<count ; i++){
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        imageUris.add(i,imageUri); //added to our list
                    }
                   // String toast = imageUris.get(0).toString() ;
                   // Toast.makeText(EventForm.this , toast , Toast.LENGTH_SHORT);
                    //set image to imageViews
                    if(count==1)
                    {
                        image1.setImageURI(imageUris.get(imageUris.size()-1));
//                        ClipboardManager clipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//                        ClipData clipData = ClipData.newPlainText("", "");
//                        clipBoard.setPrimaryClip(clipData);
                    }
                    else if(count==2)
                    {
                        image1.setImageURI(imageUris.get(0));
                        image2.setImageURI(imageUris.get(1));
//                        ClipboardManager clipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//                        ClipData clipData = ClipData.newPlainText("", "");
//                        clipBoard.setPrimaryClip(clipData);
                    }
                    else if(count==3)
                    {
                        image1.setImageURI(imageUris.get(0));
                        image2.setImageURI(imageUris.get(1));
                        image3.setImageURI(imageUris.get(2));
//                        ClipboardManager clipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//                        ClipData clipData = ClipData.newPlainText("", "");
//                        clipBoard.setPrimaryClip(clipData);
                    }
                    else if(count==4)
                    {
                        image1.setImageURI(imageUris.get(0));
                        image2.setImageURI(imageUris.get(1));
                        image3.setImageURI(imageUris.get(2));
                        image4.setImageURI(imageUris.get(3));
//                        ClipboardManager clipBoard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
//                        ClipData clipData = ClipData.newPlainText("", "");
//                        clipBoard.setPrimaryClip(clipData);
                    }


                }
                else {
                    //if selected single image
                    Uri imageUri = data.getData();
                    imageUris.add(0,imageUri);
                    //set image to imageView
                    image1.setImageURI(imageUris.get(0));
                }
            }
        }
    }
}