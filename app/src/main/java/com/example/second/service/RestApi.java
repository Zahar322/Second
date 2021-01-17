package com.example.second.service;


import com.example.second.model.Coffee;
import com.example.second.model.User;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RestApi {

    @GET("users")
    Single<List<User>> findAll();

    @GET("coffees")
    Single<List<Coffee>> findAllCoffees();

}
