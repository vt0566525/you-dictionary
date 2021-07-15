package com.example.you_dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
 TextView word,meaning,synonym;
    WordDay wo=new WordDay();
    ImageView first,second;
    List<Vids> vids=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word=findViewById(R.id.word);
        first=findViewById(R.id.first);
        second=findViewById(R.id.second);
        meaning=findViewById(R.id.meaning);
        synonym=findViewById(R.id.synonym);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://download-indian-apps.com/bolo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        json_interface json_interface=retrofit.create(json_interface.class);
        Call<result> call=json_interface.getresult();
        call.enqueue(new Callback<result>() {
            @Override
            public void onResponse(Call<result> call, Response<result> response) {
                if(!response.isSuccessful()){
                    word.setText("code"+response.code());
                    Toast.makeText(MainActivity.this,"error in response code",Toast.LENGTH_SHORT).show();
                return;
                }
           //   result res=response.body();
                wo=response.body().getArticles();
             //   String str=.getAdSource();
                String words=wo.getWord();
                String[] arr=wo.getSynonym();
                String mean=wo.getGeneric();
                String syno="";
                for(int i=0;i<arr.length;i++){
                     syno+=arr[i]+"\n";
                }
                meaning.setText(mean);
                synonym.setText(syno );
                word.setText(words);









            }

            @Override
            public void onFailure(Call<result> call, Throwable t) {
                word.setText(t.getMessage());
              Toast.makeText(MainActivity.this,"someting get error",Toast.LENGTH_SHORT).show();

            }
        });
//        call.enqueue(new Callback<List<result>>() {
//            @Override
//            public void onResponse(Call<List<result>> call, Response<List<result>> response) {
//                if(!response.isSuccessful()){
//                    word.setText("code"+response.code());
//                    Toast.makeText(MainActivity.this,"error in response code",Toast.LENGTH_SHORT).show();
//                return;
//                }
//                List<result> results=response.body();
//
//
//
//                for( result resulta:results){
////
////                    List<WordDay> wordDays=resulta.getArticles();
////                    for(WordDay wid:wordDays){
////                        String str=wid.getWord();
////                        word.setText(str);
////                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<result>> call, Throwable t) {
//                word.setText(t.getMessage());
//                Toast.makeText(MainActivity.this,"someting get error",Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }
}