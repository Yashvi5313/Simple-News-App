package com.example.newsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DailyNewsActivity extends AppCompatActivity {

    String newsData;
    ArrayList<NewsItem> newsItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailynews);

        ImageView imageView = (ImageView) findViewById(R.id.imgBack2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inter = new Intent(DailyNewsActivity.this, NewsActivity.class);
                startActivity(inter);
            }
        });

        Intent intent = getIntent();
        newsData = intent.getStringExtra("News");
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<NewsItem>>() {}.getType();
        ArrayList<NewsItem> newsItemList = gson.fromJson(newsData, listType);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(DailyNewsActivity.this);
        RecyclerView idRecyclerview1 = findViewById(R.id.idRecyclerview1);

        newsItemArrayList = new ArrayList<>();
        newsItemArrayList.add(new NewsItem(R.drawable.feed1, "Coronavirus live updates:", "Pfizer says Covid vaccine shot 100% effective in adolescents after 4 months\n" + "\n" + "India recorded 8,488 new coronavirus infections, the lowest in 538 days, taking the country's total tally of Covid-19 cases to 3,45,18,901. The daily rise in new coronavirus infections has been below 20,000 for 45 straight days.\n", "10:38 pm", "Global"));

        newsItemArrayList.add(new NewsItem(R.drawable.feed2, "US: 5 dead, more than 40 injured after vehicle plows through parade in Wisconsin\n", "WAUKESHA: Five people were killed and more than 40 injured after an SUV sped through a Christmas parade in Waukesha, Wisconsin, on Sunday, knocking down dozens of people including youngsters waving pompoms and a group of Dancing  Grannies" + "\n" + "At this time, we can confirm that five people are deceased and over 40 are injured, the Waukesha Police Department said on its Facebook page. However, these numbers may change as we collect additional information.\n" +
                "\n" + "The SUV came by at full speed,said Santamaria. Then I started to hear people screaming.", "10:25 pm", "Global"));

        newsItemArrayList.add(new NewsItem(R.drawable.feed3, " Airtel raises tariffs, others could follow", "NEW DELHI: Your mobile tariffs are set to go up. Bharti Airtel, one of the country's oldest mobile operator, will be increasing tariffs for pre-paid customers by up 20-25% from November 26, signalling hardening of tariffs as companies look at ways to shore up profitability ahead of new investments in 5G and telecom network. Tariffs for post-paid customers may also go up further after some changes mad recently.\n" +
                "\n" + "Airtel said that the move will help it raise mobile Average Revenue Per User (ARPU) – a key yardstick to measure profitability of mobile companies- to \"Rs 200 and ultimately at Rs 300 so as to provide a reasonable return on capital that allows for a financially healthy business model.\"\n", "08:49 am", "Business"));

        newsItemArrayList.add(new NewsItem(R.drawable.feed4, "India vs New Zealand: Good series win but we are also quite realistic, says Rahul Dravid\n", "KOLKATA: Newly-appointed India chief coach Rahul Dravid says the 3-0 result over New Zealand augurs well for the team in the long-run but at the same time, he is realistic enough to not read too much into the overall outcome with Black Caps having to play the series three days after the T20 World Cup final.\n" + "\n" + "Some of the key players from both teams were rested for the series as part of workload management.\n" +
                "\n" + "\"It was a really good series win. Everyone played really well right through the series. It feels good, nice to start well,” Dravid said at the post-match presentation here.\n", "09:16 pm", "Sports"));

        newsItemArrayList.add(new NewsItem(R.drawable.feed5, "Andhra Pradesh flood situation grim as toll rises to 41; Tirupati cut off", "TIRUPATI The flood situation in Andhra Pradesh continued to be grim with arterial roads cut off even as the toll increased to 41 with 12 more deaths reported on Sunday.\n" + "\n" + "Train and bus services remained affected while many villages and towns in Rayalaseema and Nellore district remained under water Streams rivulets and village tanks were full to the brim and a few of them were overflowing causing concern to people living in lowlying areas.\n" +
                "\n" + "Rail and road connectivity to the temple city of Tirupati remained cut off with the closure of KadapaTirupati highway NelloreTirupati highway and BengaluruTirupati highway.\n", "03:25 am", "Weather"));

        newsItemArrayList.add(new NewsItem(R.drawable.feed6, "Rakul Preet Singh spills the beans on her wedding plans with beau Jackky Bhagnani", "Rakul Preet Singh confessed to being in a romantic relationship with actor-producer Jackky Bhagnani in a social media post on her birthday a few months ago.\n" + "\n" + "In a new interview with a news portal, the actress was asked about her marriage plans. Replying to the same, she reportedly said that whenever that will happen, she will share it like any other thing. However, right now, she is focusing on her career because that’s exactly what she is in the industry for.\n" +
                "\n" + "The actress, who often keeps her personal matters private, told the news portal that she chooses to listen to things that she wants to listen to and she chooses not to get affected by things.", "10:08 am", "Entertainment"));

        newsItemArrayList.addAll(newsItemList);

        DailyNewsAdapter dailyNewsAdapter = new DailyNewsAdapter(this, newsItemArrayList);
        idRecyclerview1.setAdapter(dailyNewsAdapter);
        idRecyclerview1.setLayoutManager(layoutManager1);

        dailyNewsAdapter.SetOnNewsClickListner(new DailyNewsAdapter.NewsClickEvent() {
            @Override
            public void onNewsClick(NewsItem newsItem, int pos) {
                Gson gson1 = new Gson();
                String desJson = gson1.toJson(newsItem);
                Intent intent1 = new Intent(DailyNewsActivity.this, FeedActivity.class);
                intent1.putExtra("Feed", desJson);
                startActivity(intent1);
            }
        });
    }
}

