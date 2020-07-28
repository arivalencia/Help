package com.example.help;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.help.adapter.ListAdapter;
import com.example.help.pojo.CardHelp;

import java.util.ArrayList;

public class HelpActivity extends AppCompatActivity {
    ArrayList<CardHelp> listApp = new ArrayList<>();
    ArrayList<CardHelp> listUserGuide = new ArrayList<>();
    ArrayList<CardHelp> listAccount = new ArrayList<>();
    Toolbar toolbar;
    Bundle datos;
    RecyclerView listHelpsOne;
    ListAdapter adapter;
    TextView title;
    int typeOfList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        //Poner flecha atras en toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        datos = this.getIntent().getExtras();
        typeOfList = datos.getInt("typeOfList");
        title = findViewById(R.id.title);

        listHelpsOne = findViewById(R.id.listHelpsOne);
        listHelpsOne.setLayoutManager(new LinearLayoutManager(this));

        updateList();
        listHelpsOne.setAdapter(listAdapter());
    }

    public void updateList(){
        listApp.add(new CardHelp("La app se detiene", "Se detiene inestperadamente"));
        listApp.add(new CardHelp("La app se cierra", "Sale un mensaje de error"));
        listApp.add(new CardHelp("La app no acepta mi tarjeta", "Rechaza  la taerjeta aun con los datos correctos"));

        listUserGuide.add(new CardHelp("Guía de usuario item 1", "Descripción"));
        listUserGuide.add(new CardHelp("Guía de usuario item 2", "Descripción"));
        listUserGuide.add(new CardHelp("Guía de usuario item 3", "Descripción"));
        listUserGuide.add(new CardHelp("Guía de usuario item 4", "Descripción"));

        listAccount.add(new CardHelp("Cuenta item 1", "Descripción"));
        listAccount.add(new CardHelp("Cuenta item 2", "Descripción"));
        listAccount.add(new CardHelp("Cuenta item 3", "Descripción"));
        listAccount.add(new CardHelp("Cuenta item 4", "Descripción"));

    }

    public ListAdapter listAdapter(){
        switch (typeOfList){
            case 0 :
                //adapter = new ListAdapter(this, listApp, 2);
                title.setText("Aplicación");
                return new ListAdapter(this, listApp, 2);
            case 1 :
                //adapter = new ListAdapter(this, listUserGuide, 2);
                title.setText("Guía de usuario");
                return new ListAdapter(this, listUserGuide, 2);
            case 2 :
                //adapter = new ListAdapter(this, listAccount, 2);
                title.setText("Cuenta");
                return new ListAdapter(this, listAccount, 2);
            default:
                return new ListAdapter(this, listAccount, 2);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
