package com.artopher.floxum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class newLoginPage extends AppCompatActivity {
    Button loginButton , newSign_up;
    TextView forgot_pw , login_to_continue;
    ImageView login_girl;
    EditText email_editText , passwordEditText;
    int duration = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_page);

        //Hooks
        loginButton =(Button)findViewById(R.id.login_button);
        newSign_up =(Button)findViewById(R.id.newsign_up_button);
        forgot_pw=(TextView)findViewById(R.id.forgot);
        login_to_continue=(TextView)findViewById(R.id.login_text);
        login_girl=(ImageView)findViewById(R.id.login_girl);
        passwordEditText=(EditText)findViewById(R.id.passwordEditText);
        email_editText=(EditText)findViewById(R.id.email_editText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "Ruko Bhai SQL se karna hai connect" , Toast.LENGTH_LONG);
            }
        });

        newSign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), new_signup_page.class);
            }
        });




    }
}