package com.example.chapter13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Exer1005 extends AppCompatActivity {
    String math;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exer1005_main);
        setTitle("연습문제 10-5");

        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);

        RadioGroup op = (RadioGroup) findViewById(R.id.op);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(op.getCheckedRadioButtonId()) {
                    case R.id.plus:
                        math = num1.getText() + " + " + num2.getText() + " = ";
                        break;
                    case R.id.minus:
                        math = num1.getText() + " - " + num2.getText() + " = ";
                        break;
                    case R.id.multiple:
                        math = num1.getText() + " * " + num2.getText() + " = ";
                        break;
                    case R.id.divide:
                        math = num1.getText() + " / " + num2.getText() + " = ";
                        break;
                }

                Intent intent;
                intent = new Intent(getApplicationContext(),
                        SecondActivity1005.class);
                intent.putExtra("num1", Integer.valueOf(String.valueOf(num1.getText())));
                intent.putExtra("num2", Integer.valueOf(String.valueOf(num2.getText())));
                intent.putExtra("math", math);

                startActivity(intent);
            }
        });
    }
}