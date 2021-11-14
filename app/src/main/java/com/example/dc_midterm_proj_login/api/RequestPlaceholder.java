package com.example.dc_midterm_proj_login.api;

import com.example.dc_midterm_proj_login.pojos.Login;
//import com.example.dc_midterm_proj_login.pojos.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RequestPlaceholder {

    @POST("login")
    Call<Login> login(@Body Login login);

}