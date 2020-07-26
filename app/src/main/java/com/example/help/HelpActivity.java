package com.example.help;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.help.adapter.ListAdapter;
import com.example.help.pojo.CardHelp;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity{
    ArrayList<CardHelp> listData = new ArrayList<>();
    RecyclerView listHelpsOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        listHelpsOne = findViewById(R.id.listHelpsOne);
        listHelpsOne.setLayoutManager(new LinearLayoutManager(this));

        listHelpsOne.setAdapter(new ListAdapter(this,2));
    }

}
