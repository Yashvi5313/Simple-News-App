package com.example.newsrecyclerview;

public class NewsItem {
    int NewsImage;
    String NewsTitle;
    String NewsDescription;
    String NewsTime;
    String NewsType;

    public NewsItem(int NewsImage, String NewsTitle, String NewsDescription, String NewsTime, String NewsType){
        this.NewsImage = NewsImage;
        this.NewsTitle = NewsTitle;
        this.NewsDescription = NewsDescription;
        this.NewsTime = NewsTime;
        this.NewsType = NewsType;
    }

    public int getNewsImage() { return NewsImage; }

    public String getNewsTitle() { return NewsTitle; }

    public String getNewsDescription() { return NewsDescription; }

    public String getNewsTime() { return NewsTime; }

    public String getNewsType() { return NewsType; }
}
