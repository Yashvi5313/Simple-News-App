package com.example.newsrecyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DailyNewsAdapter extends RecyclerView.Adapter<DailyNewsAdapter.ViewHolder> {
    ArrayList<NewsItem> newsItemArrayList;
    NewsClickEvent newsClickEvent;

    public DailyNewsAdapter(DailyNewsActivity mainActivity2, ArrayList<NewsItem> newsItemArrayList) {
        this.newsItemArrayList = newsItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View feedcard = layoutInflater.inflate(R.layout.feed_card, parent, false);
        DailyNewsAdapter.ViewHolder viewHolder = new DailyNewsAdapter.ViewHolder(feedcard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final NewsItem newsItem = newsItemArrayList.get(position);
        holder.feedNewsImg.setImageResource(newsItemArrayList.get(position).getNewsImage());
        holder.feedTitle.setText(newsItemArrayList.get(position).getNewsTitle());
        holder.feedDescription.setText(newsItemArrayList.get(position).getNewsDescription());
        holder.feedTime.setText(newsItemArrayList.get(position).getNewsTime());
        holder.feedType.setText(newsItemArrayList.get(position).getNewsType());
        holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsClickEvent.onNewsClick(newsItem, position);
            }
        });
    }


    public void SetOnNewsClickListner(NewsClickEvent newsClickEvent) {
        this.newsClickEvent = newsClickEvent;
    }

    public interface NewsClickEvent {
        void onNewsClick(NewsItem newsItem, int pos);
    }


    @Override
    public int getItemCount() {
        return newsItemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView feedNewsImg;
        public TextView feedTitle;
        public TextView feedDescription;
        public TextView feedTime;
        public TextView feedType;
        public LinearLayout linearLayout2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.feedNewsImg = (ImageView) itemView.findViewById(R.id.feedNewsImg);
            this.feedTitle = (TextView) itemView.findViewById(R.id.feedTitle);
            this.feedDescription = (TextView) itemView.findViewById(R.id.feedDescription);
            this.feedTime = (TextView) itemView.findViewById(R.id.feedTime);
            this.feedType = (TextView) itemView.findViewById(R.id.feedType);
            linearLayout2 = (LinearLayout) itemView.findViewById(R.id.linearLayout2);

        }
    }

}
