package com.example.chapter13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity1005 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third1005);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        String math = intent.getStringExtra("math");

        String result ="";
        switch(math.split(" ")[1]) {
            case "+":
                result = String.valueOf(num1 + num2);
                break;
            case "-":
                result = String.valueOf(num1 - num2);
                break;
            case "*":
                result = String.valueOf(num1 * num2);
                break;
            case "/":
                result = String.valueOf(num1 / num2);
                break;
        }

        TextView resultTxt = (TextView) findViewById(R.id.resultTxt);
        resultTxt.setText("결과값 : " + result);
        Toast.makeText(getApplicationContext(),
                result,
                Toast.LENGTH_SHORT).show();

        Button btnReturn = (Button) findViewById(R.id.btnReturn);

        final String finalResult = result;
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), SecondActivity1005.class);
                outIntent.putExtra("result", finalResult);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }

}