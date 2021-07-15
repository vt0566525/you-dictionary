package com.example.you_dictionary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class WordDay {

@SerializedName("synonym")

    private String[] synonym;
@SerializedName("generic")
private String generic;
@SerializedName("word")
    private String word;

//    public String getSynonym() {
//        return synonym;
//    }



    public  String[] getSynonym(){return synonym;}
    public String getGeneric(){return generic;}
    public String getWord() {
        return word;
    }
}
