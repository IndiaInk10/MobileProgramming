package com.example.chapter10;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


public class SecondActivity1001 extends Activity {
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second1001);

        TextView txtResult = (TextView) findViewById(R.id.txtResult);


        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id)
                {
                    case R.id.btnBTS:
                        result = "방탄소년단";
                        break;
                    case R.id.btnJCKS:
                        result = "잭스키스";
                        break;
                    case R.id.btnSOSI:
                        result = "소녀시대";
                        break;
                    case R.id.btnAPINK:
                        result = "에이핑크";
                        break;
                }
            }
        });

        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtResult.setText("결과 : " + result);
            }
        });


    }
}