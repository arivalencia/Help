package com.example.help;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.help.adapter.ListAdapter;
import com.example.help.pojo.CardHelp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<CardHelp> helps = new ArrayList<>();
    RecyclerView listHelps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listHelps = findViewById(R.id.listHelps);
        listHelps.setLayoutManager(new LinearLayoutManager(this));
        updateList();
        listHelps.setAdapter(new ListAdapter(this, helps, 1));
    }

    public void updateList(){
        helps.add(new CardHelp("App", "Problemas con la app"));
        helps.add(new CardHelp("Guía de usuario", "Como utilizar la app"));
        helps.add(new CardHelp("Cuenta", "Pagos, tarjeta, seción"));
    }
}
