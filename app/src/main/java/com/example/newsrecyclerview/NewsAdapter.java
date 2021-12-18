package com.example.newsrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    public ArrayList<NewsItem> newsItemArrayList;
    SeeAllClickEvent seeAllClickEvent;

    public NewsAdapter(NewsActivity mainActivity, ArrayList<NewsItem> newsItemArrayList) {
        this.newsItemArrayList = newsItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View newscard = layoutInflater.inflate(R.layout.headline_card, parent, false);
        NewsAdapter.ViewHolder viewHolder = new NewsAdapter.ViewHolder(newscard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NewsItem newsItem = newsItemArrayList.get(position);
        holder.imgNewsImg.setImageResource(newsItemArrayList.get(position).getNewsImage());
        holder.idHeadline.setText(newsItemArrayList.get(position).getNewsTitle());
        holder.NewsDescription.setText(newsItemArrayList.get(position).getNewsDescription());
        holder.idTime.setText(newsItemArrayList.get(position).getNewsTime());
        holder.idType.setText(newsItemArrayList.get(position).getNewsType());
        holder.idSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seeAllClickEvent.onSeeAllClick(newsItem, position);
            }
        });

    }

    public void setOnSeeAllClickListner(SeeAllClickEvent seeAllClickEvent){
        this.seeAllClickEvent = seeAllClickEvent;
    }

    public interface SeeAllClickEvent {
        void onSeeAllClick(NewsItem newsItem, int pos);
    }

    @Override
    public int getItemCount() {
        return newsItemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgNewsImg;
        public TextView idHeadline;
        public TextView NewsDescription;
        public TextView idTime;
        public TextView idType;
        public TextView idSeeAll;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imgNewsImg = (ImageView) itemView.findViewById(R.id.imgNewsImg);
            this.idHeadline = (TextView) itemView.findViewById(R.id.idHeadline);
            this.NewsDescription = (TextView) itemView.findViewById(R.id.NewsDescription);
            this.idTime = (TextView) itemView.findViewById(R.id.idTime);
            this.idType = (TextView) itemView.findViewById(R.id.idType);
            this.idSeeAll = (TextView) itemView.findViewById(R.id.idSeeAll);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}
