package com.example.help.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.help.HelpActivity;
import com.example.help.MainActivity;
import com.example.help.R;
import com.example.help.pojo.CardHelp;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private CardHelp cardHelp;
    private ArrayList<CardHelp> helps;
    private Context context;
    private int activity;

    public ListAdapter(Context context, int activity){
        this.helps = MainActivity.helps;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.help, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        cardHelp = helps.get(position);
        if(activity == 1){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    context.startActivity(new Intent(context, HelpActivity.class));
                }
            });
            holder.textViewTitle.setText(cardHelp.getTitle());
            holder.textViewSubTitle.setText(cardHelp.getDescription());

        }else if(activity == 2){
            holder.textViewTitle.setText(cardHelp.getOfList(position));
        }
    }

    @Override
    public int getItemCount(){
        return sizeRecyclerView();
    }
    
    public int sizeRecyclerView(){
        /*int tam = 0;
        if (activity == 1){
            tam =  helps.size();
        }
        if(activity == 2){
            tam =  5;
        }
        return tam;*/
        return helps.size();
    }

    //CLASE INTERNA
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewSubTitle;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title);
            textViewSubTitle = itemView.findViewById(R.id.description);
        }
    }
}