package com.example.chapter10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity1003_org extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second1003_org);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();

        String calc = (inIntent.getStringExtra("Calc"));

        int calValue = 0;
        if (calc.equals("+")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    + inIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("-")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    - inIntent.getIntExtra("Num2", 0);
        } else if (calc.equals("*")) {
            calValue = inIntent.getIntExtra("Num1", 0)
                    * inIntent.getIntExtra("Num2", 0);
        } else {
            calValue = inIntent.getIntExtra("Num1", 0)
                    / inIntent.getIntExtra("Num2", 0);
        }

        final int retValue = calValue;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),
                        Self1003_org.class);
                outIntent.putExtra("Hap", retValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }

}