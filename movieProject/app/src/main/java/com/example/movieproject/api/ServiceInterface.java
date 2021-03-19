package com.example.movieproject.api;

import com.example.movieproject.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ServiceInterface {

    @Headers({"app-id:605343d63328573b729f482c"})
    @GET("post")
    Call<ResponseMovie> getPopularMovie();

    @Headers({"app-id:605343d63328573b729f482c"})
    @GET("post/SFAt3mJK0qu4QOd9LgSX/comment")
    Call<ResponseMovie> getComment();
}
