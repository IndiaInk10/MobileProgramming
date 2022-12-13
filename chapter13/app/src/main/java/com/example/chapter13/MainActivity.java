package com.example.chapter13;

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


        Button button8 = (Button) findViewById(R.id.button5) ;
        button8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exer1005.class) ;

                startActivity(intent) ;
            }
        });

        Button button9 = (Button) findViewById(R.id.button6) ;
        button9.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exer1306.class) ;

                startActivity(intent) ;
            }
        });


        Button button8_org = (Button) findViewById(R.id.button5_org) ;
        button8_org.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exer1005_org.class) ;

                startActivity(intent) ;
            }
        });

        Button button9_org = (Button) findViewById(R.id.button6_org) ;
        button9_org.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Exer1306_org.class) ;

                startActivity(intent) ;
            }
        });

    }
}