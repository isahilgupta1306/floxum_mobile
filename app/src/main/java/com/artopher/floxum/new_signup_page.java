package com.artopher.floxum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.artopher.floxum.ApiClasses.ApiClients.ApiClientSignup;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class new_signup_page extends AppCompatActivity {
    TextInputEditText fullnameEditText , usernameEditText , emailEditText , passwordEditText , repeatPasswordEditText ;
    MaterialButton loginButton , signupButton;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_signup_page);
        //Hooks
        //Buttons
        loginButton=(MaterialButton)findViewById(R.id.goLogin);
        signupButton=(MaterialButton)findViewById(R.id.sign_upButton);
        //EditTexts
        fullnameEditText =(TextInputEditText)findViewById(R.id.full_name);
        usernameEditText =(TextInputEditText)findViewById(R.id.username);
        emailEditText =(TextInputEditText)findViewById(R.id.email);
        passwordEditText =(TextInputEditText)findViewById(R.id.password);
        repeatPasswordEditText =(TextInputEditText)findViewById(R.id.confirm_password);
        //ImageView
        backButton =(ImageView)findViewById(R.id.backButton);
        ///ss

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(emailEditText.getText().toString()) || TextUtils.isEmpty(passwordEditText.getText().toString())){
                    Toast.makeText(new_signup_page.this,"Pehle pw , email to daal bsdk" , Toast.LENGTH_SHORT).show();
                }
                else {
                    //proceed to signup
                    signUP();

                }

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), newLoginPage.class);
                startActivity(i);
            }
        });












        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), newLoginPage.class);
                startActivity(i);
            }
        });

    }

    private void signUP() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirm_password = repeatPasswordEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String fullname = fullnameEditText.getText().toString().trim();

        Call<ResponseBody> call = ApiClientSignup
                .getInstance()
                .getApi()
                .register(username , fullname , password, confirm_password , email);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {

                    if (response.isSuccessful()){
                        String r = response.body().string();
                        Toast.makeText(new_signup_page.this, r , Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(new_signup_page.this, "GadBad" , Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(new_signup_page.this, "Barbaad" , Toast.LENGTH_SHORT).show();
            }





        });
    }
}