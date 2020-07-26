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
    public static ArrayList<CardHelp> helps = new ArrayList<>();
    RecyclerView listHelps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listHelps = findViewById(R.id.listHelps);

        listHelps.setLayoutManager(new LinearLayoutManager(this));
        updateList();
        listHelps.setAdapter(new ListAdapter(this,1));
    }

    public void updateList(){
        String[] list = {"No puedo confirmar mi pedido","No carga el mapa","No encuentro un establecimiento", "No puedo registrar mi tarjeta","La app se cierra inesperadamente"};
        String[] text = {"Para proteger tu seguridad y privacidad, tu banco no puede proporcionar a Amazon información acerca " +
                "de por qué falló la confirmación de pago. Por esta razón, es necesario que contactes a tu banco directamente" +
                " para resolver cualquier problema de confirmación de pago.", "No carga el mapa No carga el mapa No carga el mapa No carga el mapa No carga el mapa No carga el mapa No carga el mapa", "No encuentro un establecimiento No encuentro un establecimiento No encuentro un establecimiento No encuentro un establecimiento", "No puedo registrar mi tarjeta No puedo registrar mi tarjeta No puedo registrar mi tarjeta No puedo registrar mi tarjeta", "La app se cierra inesperadamente La app se cierra inesperadamenteLa app se cierra inesperadamenteLa app se cierra inesperadamente"};
        helps.add(new CardHelp("App", "Problemas con la app", list, text));
    }
}
