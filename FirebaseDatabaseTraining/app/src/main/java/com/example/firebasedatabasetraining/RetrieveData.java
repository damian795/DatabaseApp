package com.example.firebasedatabasetraining;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetrieveData extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Game> game;
    private  GameAdapter gameAdapter;

    DatabaseReference dRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_data);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        game = new ArrayList<>();

        dRef = FirebaseDatabase.getInstance().getReference().child("New games");
        dRef.addListenerForSingleValueEvent(valueEventListener);
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                Game gameNew = dataSnapshot1.getValue(Game.class);
                game.add(gameNew);
            }
            gameAdapter = new GameAdapter(RetrieveData.this, game);
            recyclerView.setAdapter(gameAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };


}