package com.example.you_dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class result {

    @SerializedName("wordDay")
    @Expose


    private WordDay wordDay;
    @SerializedName("adSource")
    private  String adSource;
    @SerializedName("videos")
    private Videos videos;

    public WordDay getArticles() {
        return wordDay;
    }
    public String getAdSource(){return  adSource;}
    public Videos getVideos(){return  videos;}

}
