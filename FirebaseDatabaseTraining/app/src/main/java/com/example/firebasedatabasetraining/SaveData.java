package com.example.firebasedatabasetraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveData extends AppCompatActivity {

    private EditText title, producer, type, year;
    private Button btnInsert, btnBackToHome;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        title = findViewById(R.id.txtTitle);
        producer = findViewById(R.id.txtProducer);
        type = findViewById(R.id.txtType);
        year = findViewById(R.id.txtYear);

        btnInsert = findViewById(R.id.btnInsertData2);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("New games");

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gameID, gameTitle, gameProducer, gameType, gameYear;

                gameID = databaseReference.push().getKey();
                gameTitle = title.getText().toString();
                gameProducer = producer.getText().toString();
                gameType = type.getText().toString();
                gameYear = year.getText().toString();

                if(gameTitle.equals("") || gameProducer.equals("") || gameType.equals("") || gameYear.equals("")){
                    Toast.makeText(SaveData.this, "Empty data", Toast.LENGTH_SHORT).show();
                }else{
                    Game game = new Game(gameID, gameTitle, gameProducer, gameType, gameYear);
                    databaseReference.child(gameID).setValue(game);
                    Toast.makeText(SaveData.this, "Inserted successfully", Toast.LENGTH_SHORT).show();
                }

                title.setText("");
                producer.setText("");
                type.setText("");
                year.setText("");

            }
        });


        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SaveData.this, Home.class));
                finish();
            }
        });
    }
}