package com.example.firebasedatabasetraining;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Game> game;

    public GameAdapter(Context c, ArrayList<Game> game){
        this.context = c;
        this.game = game;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Game game = this.game.get(position);

        holder.tvTitle.setText(game.getTitle());
        holder.tvProducer.setText(game.getProducer());
        holder.tvType.setText(game.getType());
        holder.tvYear.setText(game.getYear());
    }

    @Override
    public int getItemCount() {
        return game.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle, tvProducer, tvType, tvYear;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.titleCard);
            tvProducer = itemView.findViewById(R.id.producerCard);
            tvType = itemView.findViewById(R.id.typeCard);
            tvYear = itemView.findViewById(R.id.yearCard);
        }
    }
}
