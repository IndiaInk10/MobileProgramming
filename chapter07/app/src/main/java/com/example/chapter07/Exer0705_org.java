package com.example.chapter07;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exer0705_org extends AppCompatActivity {
    Button btn;
    View toastView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exer0705_main_org);
        setTitle("연습문제 7-5");

        btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
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

    }
}