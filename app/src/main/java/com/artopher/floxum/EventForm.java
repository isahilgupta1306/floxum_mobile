package com.artopher.floxum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.artopher.floxum.ApiClasses.ApiClients.ApiClientAddEvent;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class EventForm extends AppCompatActivity {
    TextInputEditText EventDateEditText , EventTime , EventTitle , ContactNumber , EventLink , EventLocaion , EventDescription;
    TextInputLayout EventDateTextLayout , EventTimeTextLayout , EventTitleTextLayout ,
            ContactNumberTextLayout , EventLinkTextLayout , EventLocationTextLayout , EventDescriptionTextLayout;
    MaterialButton AddImage , SubmitButton ;

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
        EventLocaion = findViewById(R.id.event_location);
        EventDescription = findViewById(R.id.event_Description);
        //Hooks of Textinput Layout
        EventDateTextLayout = findViewById(R.id.eventdate);
        EventTimeTextLayout = findViewById(R.id.eventtime);
        //Buttons
        SubmitButton = findViewById(R.id.submit_button);
        AddImage = findViewById(R.id.add_Photo);


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
        String location = EventLocaion.getText().toString().trim();
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

    private void updateLabel() {
        String myFormat = "yy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        EventDateEditText.setText(sdf.format(myCalendar.getTime()));
    }
}