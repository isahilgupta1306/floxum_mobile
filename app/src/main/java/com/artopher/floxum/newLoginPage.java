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

import com.artopher.floxum.ApiClasses.ApiClients.ApiClientLogin;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newLoginPage extends AppCompatActivity {
    Button loginButton ;
    TextView forgot_pw , login_to_continue , newSign_up;
    ImageView login_girl;
    int duration = 2000;
    TextInputLayout email_EditText ,password_EditText  ;
    TextInputEditText email_editText , password_editText ;

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
         //Outlined Text layout
        password_EditText=(TextInputLayout)findViewById(R.id.outlinedTextField2);
        email_EditText=(TextInputLayout)findViewById(R.id.outlinedTextField);
            //their edittexts
        password_editText =(TextInputEditText)findViewById(R.id.password);
        email_editText =(TextInputEditText)findViewById(R.id.email);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(email_editText.getText().toString()) ){
                    email_EditText.setError("Enter your E-mail address");
                    email_EditText.setFocusable(true);
                    Toast.makeText(newLoginPage.this,"Pehle pw , email to daal bsdk" , Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password_editText.getText().toString())){
                    password_EditText.setError("Enter Password");
                    password_EditText.setFocusable(true);
                }
                else {
                    login();

                }


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
    public void forgotPassword(View view)
    {
        Intent intent = new Intent(getApplicationContext(),ForgotPasswordPage.class);
        startActivity(intent);
    }


    private void login() {
        String email = email_editText.getText().toString().trim();
        String password = password_editText.getText().toString().trim();

        Call<ResponseBody> call = ApiClientLogin
                .getInstance()
                .getApi()
                .login(password,email);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {
                    if (response.isSuccessful()){
                      String token = response.body().string();
                      if(token.equalsIgnoreCase("\"Invalid Credentials!\""))
                        {
                            Toast.makeText(newLoginPage.this, token , Toast.LENGTH_LONG).show();
                        }
                      else
                      {
                          Toast.makeText(newLoginPage.this, "Login Succesfull" , Toast.LENGTH_LONG).show();
                          Intent intent = new Intent(getApplicationContext(),DefaultPage.class);
                          startActivity(intent);
                      }

                    }else {
                        Toast.makeText(newLoginPage.this, "UnSuccesfull" , Toast.LENGTH_SHORT).show();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(newLoginPage.this,t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

    }


}