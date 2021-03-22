package com.devbrat.unsplash.data;

import com.devbrat.unsplash.data.model.Photo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Modeling the unsplash.it API.  I ❤ retrofit.
 */
public interface UnsplashService {

    String ENDPOINT = "https://unsplash.it";

    @GET("/list")
    void getFeed(Callback<List<Photo>> callback);

}
