package com.example.chapter07;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class Exer0705 extends AppCompatActivity {
    Button btn1, btn2;
    View toastView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exer0705_main);
        setTitle("연습문제 7-5");

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int xOffset = (int) (Math.random() * display.getWidth());
                int yOffset = (int) (Math.random() * display.getHeight());

                Toast toast = new Toast(getApplicationContext());
                toastView = (View) View.inflate(getApplicationContext(),
                        R.layout.toast0705_org, null);

                toast.setView(toastView);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                toast.show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DecimalFormat form = new DecimalFormat("#.#");

                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                double randomX = Math.random() * display.getWidth();
                double randomY = Math.random() * display.getHeight();

//                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG);
                Toast tMsg = Toast.makeText(Exer0705.this, "RANDOM 좌표값 X : " + form.format(randomX) + ", Y : " + form.format(randomY), Toast.LENGTH_LONG);
                tMsg.show();

           }
        });

    }
}