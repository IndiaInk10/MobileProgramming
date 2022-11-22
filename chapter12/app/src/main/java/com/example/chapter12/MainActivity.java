package com.example.chapter12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self1201.class) ;

                startActivity(intent) ;
            }
        });

        Button button2 = (Button) findViewById(R.id.button2) ;
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self1202.class) ;

                startActivity(intent) ;
            }
        });
//
//
//        Button button7 = (Button) findViewById(R.id.button7) ;
//        button7.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Exer1205.class) ;
//
//                startActivity(intent) ;
//            }
//        });
//
//        Button button8 = (Button) findViewById(R.id.button8) ;
//        button8.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Exer1206.class) ;
//
//                startActivity(intent) ;
//            }
//        });


        Button button2_org = (Button) findViewById(R.id.button2_org) ;
        button2_org.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Self1202_org.class) ;

                startActivity(intent) ;
            }
        });

//        Button button8_org = (Button) findViewById(R.id.button8_org) ;
//        button8_org.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Exer1206_org.class) ;
//
//                startActivity(intent) ;
//            }
//        });

    }
}