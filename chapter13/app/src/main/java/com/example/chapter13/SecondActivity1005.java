package com.example.chapter13;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity1005 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second1005);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        String math = intent.getStringExtra("math");

        TextView mathText = (TextView) findViewById(R.id.mathTxt);
        if(num2 == 0 && math.split(" ")[1].equals("/"))  mathText.setText("분모가 0으로 나눌 수 없습니다.");
        else mathText.setText(math);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),
                        ThirdActivity1005.class);
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                intent.putExtra("math", math);

                startActivityForResult(intent, 0);
            }
        });

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
    }
}