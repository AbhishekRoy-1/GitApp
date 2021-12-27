package com.example.gitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users?since=0")
    Call<List<PostPojo>> getposts();
}
