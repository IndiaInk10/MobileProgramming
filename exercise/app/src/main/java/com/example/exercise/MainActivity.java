package com.example.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button E0806Btn = (Button) findViewById(R.id.E0806Btn);
        E0806Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EX0806.class) ;

                startActivity(intent) ;
            }
        });
        Button E0807Btn = (Button) findViewById(R.id.E0807Btn);
        E0807Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EX0807.class) ;

                startActivity(intent) ;
            }
        });

        Button E10051Btn = (Button) findViewById(R.id.E10051Btn);
        E10051Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EX1005_1.class) ;

                startActivity(intent) ;
            }
        });
        Button E1006MainBtn = (Button) findViewById(R.id.E1006MainBtn);
        E1006MainBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EX1006_main.class) ;

                startActivity(intent) ;
            }
        });

//        Button E1306Btn = (Button) findViewById(R.id.E1306Btn);
//        E1306Btn.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, EX1306.class) ;
//
//                startActivity(intent) ;
//            }
//        });
//        Button E1307Btn = (Button) findViewById(R.id.E1307Btn);
//        E1307Btn.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, EX1307.class) ;
//
//                startActivity(intent) ;
//            }
//        });
    }
}