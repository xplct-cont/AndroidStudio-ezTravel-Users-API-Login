package com.example.dc_midterm_proj_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.dc_midterm_proj_login.api.RequestPlaceholder;
import com.example.dc_midterm_proj_login.api.RetrofitBuilder;


public class SignupActivity extends AppCompatActivity {


    EditText name, username, password, email;
    Button buttonSignUp;
    ProgressBar progressBar;
    TextView loginText;
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        loginText = findViewById(R.id.loginText);
        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);


        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (loginText.isClickable()) ;
                openLoginActivity();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUserData();


            }
        });
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //We have to find its values
    private void validateUserData() {
        String reg_name = name.getText().toString();
        String reg_username = username.getText().toString();
        String reg_email = email.getText().toString();
        String reg_password = password.getText().toString();

        if (TextUtils.isEmpty(reg_name)) {
            name.setError("Please enter Full Name");
            return;

        }
        //checking if username is empty
        if (TextUtils.isEmpty(reg_username)) {
            username.setError("Please enter Username");
            username.requestFocus();
            return;
        }
        //checking if email is empty
        if (TextUtils.isEmpty(reg_email)) {
            email.setError("Please enter Email");
            email.requestFocus();
            return;
        }

        //checking if password is empty
        if (TextUtils.isEmpty(reg_password)) {
            password.setError("Please enter Password");
            password.requestFocus();
            return;


        } else {
            openLoginActivity();
        }
    }
}






