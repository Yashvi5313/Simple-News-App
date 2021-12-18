package com.example.newsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    ArrayList<NewsItem> newsItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        LinearLayoutManager layoutManager = new LinearLayoutManager(NewsActivity.this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView idRecyclerview = findViewById(R.id.idRecyclerview);

        newsItemArrayList = new ArrayList<>();
        newsItemArrayList.add(new NewsItem(R.drawable.news1, "Yogi tweets pics with Modi, talks of ‘making new India’", "Uttar Pradesh CM Yogi Adityanath with PM Narendra Modi in Lucknow on Sunday\n" + "\n" + "NEW DELHI: It was apparently a casual gesture of affection towards a younger colleague, which also sent a significant message across. Two photographs of Prime Minister and Yogi Adityanath walking shoulder to shoulder went viral on social media, with the political circles seeing it as Modi’s yet another full throated endorsement of UP chief minister in the build up to the UP polls.\n" +
                "\n" + "The photographs, tweeted by the UP CM, were shared across saffron social media platforms, including of those who consider BJP to be too “lite” for their taste, came close on the heels of PM terming the Delhi-Lucknow saffron stewardshi as “Karma Yogis ki sarkar”.\n ",  "08:57 am", "Politics"));

        newsItemArrayList.add(new NewsItem(R.drawable.news2, "Now, SKM mails PM Modi on MSP, five other ‘pending demands’", "NEW DELHI/LUCKNOW: Even as the government is preparing to et a Cabinet nod on the decision to repeal the new farm laws at the next meeting on Wednesday, the Samyukta Kisan Morcha  (SKM) wrote to PM Modi on Sunday, urging him to immediately  resume talks on six demands, including a legal guarantee on minimum support price (MSP).\n" + "\n" + "The demands now include the removal of junior home minister Ajay Mishra, whose son Ashish Mishra is accused in the Lakhimpur Kheri  violence.\n" +
                "\n" + "However, during the failed meetings with government negotiators, the unions had made complete repeal of the three laws their core demand.\n", "02:02 pm", "Politics"));

        newsItemArrayList.add(new NewsItem(R.drawable.news3, "Delhi pollution: Construction can resume, schools stay shut", "NEW DELHI: The ban on construction activities in the capital has been lifted effective Monday. Schools will, however, remain closed till further orders, while the ban on entry of trucks, except those carrying essential commodities, has been extended till November 26.\n" + "\n" + "The ban on construction and demolition activities, imposed by the Commission for Air Quality Management in National Capital Region and Adjoining Areas, came to an end on Sunday. However, the Delhi environment department issued fresh order to control vehicular pollution.\n", "02:36 pm", "Pollution"));

        newsItemArrayList.add(new NewsItem(R.drawable.news4, "3rd T20I: India complete series sweep against New Zealand", "Indian cricketers celebrate after winning the third T20I against New Zealand at Kolkata\n" + "\n" + "KOLKATA: India skipper Rohit Sharma threw a challenge to his spinners on winning the toss for the third time in the just-concluded T20I series against New Zealand at the Eden Gardens here on Sunday. He decided to bat. It was like daring Axar Patel and Yuzvendra Chahal, who had replaced the in-form Ravichandran Ashwin, to show what they can do with a dew-coated ball.\n" +
                "\n" + "Axar responded brilliantly, grabbing three wickets even the visitors could settle down. His first spell of three wickets for two runs in two overs put India firmly on the path to registering a clean sweep.\n", "08:06 am", "Sports"));

        NewsAdapter adapter = new NewsAdapter(this, newsItemArrayList);
        idRecyclerview.setAdapter(adapter);
        idRecyclerview.setLayoutManager(layoutManager);

        adapter.setOnSeeAllClickListner(new NewsAdapter.SeeAllClickEvent() {
            @Override
            public void onSeeAllClick(NewsItem newsItem, int pos) {
                Gson gson = new Gson();
                String newsJson = gson.toJson(newsItemArrayList);
                Intent intent = new Intent(NewsActivity.this, DailyNewsActivity.class);
                intent.putExtra("News", newsJson);
                startActivity(intent);
            }
        });
    }
}
