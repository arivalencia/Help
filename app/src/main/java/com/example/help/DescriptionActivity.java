package com.example.help;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.help.adapter.ListAdapter;
import com.example.help.pojo.CardHelp;
import java.util.ArrayList;

public class DescriptionActivity extends AppCompatActivity {
    ArrayList<CardHelp> listApp = new ArrayList<>();
    ArrayList<CardHelp> listUserGuide = new ArrayList<>();
    ArrayList<CardHelp> listAccount = new ArrayList<>();
    TextView problem;
    TextView text;
    int typeOfList;
    int help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_activity);
        //Poner flecha atras en toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        problem = findViewById(R.id.problem);
        text = findViewById(R.id.text);
        Bundle datos = this.getIntent().getExtras();
        typeOfList = datos.getInt("typeOfList");
        help = datos.getInt("problem");
        updateList();
        putData();
    }

    public void putData(){
        CardHelp cardHelp = new CardHelp("", "");
        switch (typeOfList){
            case 0 :
                cardHelp = listApp.get(help);
                break;
            case 1 :
                cardHelp = listUserGuide.get(help);
                break;
            case 2 :
                cardHelp = listAccount.get(help);
                break;
            default:
                Toast.makeText(this, "Lo sentimos, ayuda no encontrada", Toast.LENGTH_SHORT).show();
        }
        problem.setText(cardHelp.getTitle());
        text.setText(cardHelp.getDescription());
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}