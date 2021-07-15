package com.example.you_dictionary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface json_interface {
    @GET("feed.json")
    Call<result> getresult();
}

