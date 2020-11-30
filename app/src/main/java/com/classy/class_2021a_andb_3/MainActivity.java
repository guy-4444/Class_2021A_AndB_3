package com.classy.class_2021a_andb_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_LST_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LST_news = findViewById(R.id.main_LST_news);

        ArrayList<Article> articles = DataManager.generateArticles();
        Adapter_Article adapter_article = new Adapter_Article(this, articles);
        main_LST_news.setLayoutManager(new LinearLayoutManager(this));
        main_LST_news.setItemAnimator(new DefaultItemAnimator());
        main_LST_news.setAdapter(adapter_article);

    }
}