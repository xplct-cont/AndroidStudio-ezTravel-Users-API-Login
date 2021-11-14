package com.example.dc_midterm_proj_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    EditText origin, passengername, age;
    Button contBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        origin = findViewById(R.id.origin);
        passengername = findViewById(R.id.passengername);
        age = findViewById(R.id.age);
        contBtn = findViewById(R.id.contBtn);


        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.uno));
        slideModels.add(new SlideModel("https://c0.wallpaperflare.com/preview/909/575/675/boarding-pass-euro-ticket-travel-documents.jpg"));
        slideModels.add(new SlideModel("https://c0.wallpaperflare.com/preview/519/987/648/adult-blur-business-trip-businessman.jpg"));
        slideModels.add(new SlideModel("https://images.unsplash.com/photo-1454496406107-dc34337da8d6?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1300&q=80"));
        slideModels.add(new SlideModel("https://4.imimg.com/data4/FB/IO/MY-10838749/air-500x500.jpg"));

        imageSlider.setImageList(slideModels, true);


        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

    }


    private void validateData() {
        String reg_origin = origin.getText().toString();
        String reg_passname = passengername.getText().toString();
        String reg_age = age.getText().toString();


        if (TextUtils.isEmpty(reg_origin)) {
            origin.setError("Please enter Origin");
            return;

        }

        if (TextUtils.isEmpty(reg_passname)) {
            passengername.setError("Please enter Passenger Name");
            passengername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(reg_age)) {
            age.setError("Please enter Age");
            age.requestFocus();
            return;
        }
    }
}