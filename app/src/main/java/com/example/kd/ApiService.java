package com.example.kd;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @GET("tasks")
    Call<List<SeeAllTasks>> getAllTasks() ;

    @FormUrlEncoded
    @POST("/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);








// to make requests in form data use @fields
}
