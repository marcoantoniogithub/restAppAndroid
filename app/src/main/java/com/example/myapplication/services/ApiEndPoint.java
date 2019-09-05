package com.example.myapplication.services;

import java.util.List;

import com.example.myapplication.entidades.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

    @GET("users")
    Call<List<User>> obterUsuarios();

}
