package com.classy.class_2021a_andb_3;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class Adapter_Article extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_NORMAL = 0;
    private final int VIEW_TYPE_AD = 1;

    private Context context;
    private ArrayList<Article> articles;

    public Adapter_Article(Context context, ArrayList<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }


    // specify the row layout file and click for each row
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_NORMAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article_normal, parent, false);
            return new ViewHolder_Normal(view);
        } else if (viewType == VIEW_TYPE_AD) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article_ad, parent, false);
            return new ViewHolder_Ad(view);
        }


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article_normal, parent, false);
        ViewHolder_Normal myViewHolderNormal = new ViewHolder_Normal(view);
        return myViewHolderNormal;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Article article = getItem(position);

        if (holder instanceof ViewHolder_Normal) {
            ViewHolder_Normal mHolder = (ViewHolder_Normal) holder;
            mHolder.article_LBL_title.setText(article.getTitle());
            mHolder.article_LBL_subTitle.setText(article.getSubTitle());


            if (article.getContent().equals("")) {
                mHolder.article_LBL_title.setTextColor(Color.RED);
            } else {
                mHolder.article_LBL_title.setTextColor(Color.BLACK);
            }

            Glide
                    .with(context)
                    .load(article.getMainImage())
                    .centerCrop()
                    .into(mHolder.article_IMG_back);
        } else if (holder instanceof ViewHolder_Ad) {
            ViewHolder_Ad mHolder = (ViewHolder_Ad) holder;
            mHolder.article_LBL_title.setText(article.getTitle());
            mHolder.article_LBL_subTitle.setText(article.getSubTitle());


            if (article.getContent().equals("")) {
                mHolder.article_LBL_title.setTextColor(Color.RED);
            } else {
                mHolder.article_LBL_title.setTextColor(Color.BLACK);
            }

            Glide
                    .with(context)
                    .load(article.getMainImage())
                    .centerCrop()
                    .into(mHolder.article_IMG_back);

            mHolder.article_BTN_click.setText(article.getButton());
        }

    }

    private Article getItem(int position) {
        return articles.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).getType() == Article.TYPE.NORMAL) {
            return VIEW_TYPE_NORMAL;
        } else if (getItem(position).getType() == Article.TYPE.AD) {
            return VIEW_TYPE_AD;
        }

        return VIEW_TYPE_NORMAL;
    }

    static class ViewHolder_Normal extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView article_IMG_back;
        public TextView article_LBL_title;
        public TextView article_LBL_subTitle;

        public ViewHolder_Normal(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            article_IMG_back = itemView.findViewById(R.id.article_IMG_back);
            article_LBL_title = itemView.findViewById(R.id.article_LBL_title);
            article_LBL_subTitle = itemView.findViewById(R.id.article_LBL_subTitle);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition());
        }
    }

    static class ViewHolder_Ad extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView article_IMG_back;
        public TextView article_LBL_title;
        public TextView article_LBL_subTitle;
        public MaterialButton article_BTN_click;

        public ViewHolder_Ad(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            article_IMG_back = itemView.findViewById(R.id.article_IMG_back);
            article_LBL_title = itemView.findViewById(R.id.article_LBL_title);
            article_LBL_subTitle = itemView.findViewById(R.id.article_LBL_subTitle);
            article_BTN_click = itemView.findViewById(R.id.article_BTN_click);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition());
        }
    }
}
