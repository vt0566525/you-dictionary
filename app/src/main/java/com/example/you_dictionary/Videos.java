package com.example.you_dictionary;

import android.widget.LinearLayout;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Videos {
    @SerializedName("vids")
    private List<Vids> vids;

    public List<Vids> getVids(){return vids;}
}
