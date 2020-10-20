package com.artopher.floxum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class new_signup_page extends AppCompatActivity {
    TextView textView;
    Button loginButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_signup_page);
        loginButton=(Button)findViewById(R.id.goLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), newLoginPage.class);
                startActivity(i);
            }
        });

    }
}