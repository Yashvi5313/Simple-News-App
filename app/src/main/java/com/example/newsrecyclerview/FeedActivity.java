package com.example.newsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class FeedActivity extends AppCompatActivity {

    String FeedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

//        ImageView imgFeedBack = (ImageView) findViewById(R.id.imgFeedBack);
//        imgFeedBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                Intent intent = new Intent(FeedActivity.this, DailyNewsActivity.class);
//                startActivity(intent);
//            }
//        });

        Gson gson = new Gson();
        NewsItem newsItem = gson.fromJson(getIntent().getStringExtra("Feed"), NewsItem.class);

        ImageView NewsImg = (ImageView) findViewById(R.id.NewsImg);
        NewsImg.setImageResource(newsItem.getNewsImage());

        TextView Headline = (TextView) findViewById(R.id.Headline);
        Headline.setText(newsItem.getNewsTitle());

        TextView Description = (TextView) findViewById(R.id.Description);
        Description.setText(newsItem.getNewsDescription());

        TextView Time = (TextView) findViewById(R.id.Time);
        Time.setText(newsItem.getNewsTime());

        TextView Type = (TextView) findViewById(R.id.Type);
        Type.setText(newsItem.getNewsType());

    }
}