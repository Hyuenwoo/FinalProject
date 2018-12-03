package com.example.hwhan.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChoiceCrop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_crop);
        Button btn1= (Button)findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "과수류 메뉴", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Calculate.class);
                startActivity(intent);
            }
        });
    }
}