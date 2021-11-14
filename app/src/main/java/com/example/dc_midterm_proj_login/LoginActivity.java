package com.example.dc_midterm_proj_login;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc_midterm_proj_login.api.RequestPlaceholder;
import com.example.dc_midterm_proj_login.api.RetrofitBuilder;
import com.example.dc_midterm_proj_login.pojos.Login;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    public EditText username, password;
    public MaterialButton loginBtn;
    public ImageView arrow;
    public TextView signup;
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        arrow = findViewById(R.id.arrow);
        loginBtn = findViewById(R.id.loginBtn);
        signup = findViewById(R.id.signup);


        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);
         signup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                openRegisterActivity();
             }
         });

        arrow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 clearInfo();
             }
         });
        //==loginBtn listener ==
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() !=null && password.getText() !=null){
                    Call<Login> loginCall = requestPlaceholder.login(new Login(null, username.getText().toString(), null, null,password.getText().toString()));


                    loginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            if (!response.isSuccessful()){
                                if (response.code() == 404) {
                                    Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGGING_ERR", response.message());

                                }
                            }else{
                                if (response.code() == 200){
                                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }



                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Error Logging In", Toast.LENGTH_SHORT).show();
                            Log.e("LOGGING_ERR", t.getMessage());
                        }
                    });
                }else{
                    Toast.makeText(LoginActivity.this, "All Fields are Required!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void openRegisterActivity() {
        Intent intent = new Intent(this , SignupActivity.class);
        startActivity(intent);
    }


    private void clearInfo() {
        username.getText().clear();
        password.getText().clear();
    }

}








