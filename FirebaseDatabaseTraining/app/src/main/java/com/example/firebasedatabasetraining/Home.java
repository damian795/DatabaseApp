package com.example.firebasedatabasetraining;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class Home extends AppCompatActivity {

    private Button btnLogout, btnInsertData, btnRetrieveData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = findViewById(R.id.btnLogout);
        btnInsertData = findViewById(R.id.btnInsertData);
        btnRetrieveData = findViewById(R.id.btnRetrieveData);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Home.this, "Logged out successfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home.this, MainActivity.class));
                finish();
            }
        });


        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, SaveData.class));
            }
        });

        btnRetrieveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, RetrieveData.class));
            }
        });


       //FirebaseFirestore db = FirebaseFirestore.getInstance();
       //HashMap<String, Object> data = new HashMap<>();
       //data.put("Name", "Tokio");
       //data.put("Capital", "Japonia");
       //db.collection("cities").add(data).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
       //    @Override
       //    public void onComplete(@NonNull Task<DocumentReference> task) {
       //        if(task.isSuccessful()){
       //            Toast.makeText(Home.this, "Wartość dodana!!!", Toast.LENGTH_SHORT).show();
       //        }
       //    }
       //});
        //DocumentReference ref = FirebaseFirestore.getInstance().collection("cities").document("WSPA");
        //ref.update("Capital", true);
        


    }
}