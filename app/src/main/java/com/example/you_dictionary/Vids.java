package com.example.you_dictionary;

import com.google.gson.annotations.SerializedName;

public class Vids {
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("text")
    private String text;

    public String getThumbnail(){return thumbnail;}
    public String getText(){return text;}
}
