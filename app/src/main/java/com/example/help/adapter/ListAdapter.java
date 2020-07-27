package com.example.help.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.help.DescriptionActivity;
import com.example.help.HelpActivity;
import com.example.help.R;
import com.example.help.pojo.CardHelp;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private CardHelp cardHelp;
    private ArrayList<CardHelp> list;
    private Context context;
    private int activity;
    private static int typeOfList;

    public ListAdapter(Context context, ArrayList<CardHelp> list, int activity){
        this.list = list;
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
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, final int position) {
        cardHelp = list.get(position);
        if(activity == 1){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    typeOfList = position;
                    Intent intent = new Intent(context, HelpActivity.class);
                    intent.putExtra("typeOfList", position);
                    context.startActivity(intent);
                }
            });
            holder.textViewTitle.setText(cardHelp.getTitle());
            holder.textViewSubTitle.setText(cardHelp.getDescription());

        }else if(activity == 2){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(context, DescriptionActivity.class);
                    intent.putExtra("typeOfList", typeOfList);
                    intent.putExtra("problem", position);
                    context.startActivity(intent);
                }
            });
            holder.textViewTitle.setText(cardHelp.getTitle());
            holder.textViewSubTitle.setText(cardHelp.getDescription());
        }
    }

    @Override
    public int getItemCount(){
        return list.size();
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