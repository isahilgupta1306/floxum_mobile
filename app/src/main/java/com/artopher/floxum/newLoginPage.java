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

import com.google.android.material.textfield.TextInputLayout;

public class newLoginPage extends AppCompatActivity {
    Button loginButton ;
    TextView forgot_pw , login_to_continue , newSign_up;
    ImageView login_girl;
    int duration = 2000;
    TextInputLayout email_editText ,passwordEditText  ;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login_page);

        //Hooks
        loginButton =(Button)findViewById(R.id.login_button);
       newSign_up =(TextView)findViewById(R.id.newSign_up);
        forgot_pw=(TextView)findViewById(R.id.forgot);
        login_to_continue=(TextView)findViewById(R.id.login_text);
        login_girl=(ImageView)findViewById(R.id.login_girl);
        passwordEditText=(TextInputLayout)findViewById(R.id.outlinedTextField2);
        email_editText=(TextInputLayout)findViewById(R.id.outlinedTextField);

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
                startActivity(i);
            }
        });




    }
}