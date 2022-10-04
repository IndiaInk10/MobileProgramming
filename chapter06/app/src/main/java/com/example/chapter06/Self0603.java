package com.example.chapter06;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class Self0603 extends TabActivity {

    Button btn2, btn3;
    EditText editText3;
    TextView textView2;
    double Official = 3.305785;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0603_main);

        TabHost tabHost = getTabHost();

        TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("강아지");
        tabSpec1.setContent(R.id.imageView1);
        tabHost.addTab(tabSpec1);

        TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("고양이");
        tabSpec2.setContent(R.id.imageView2);
        tabHost.addTab(tabSpec2);

        TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("토끼");
        tabSpec3.setContent(R.id.imageView3);
        tabHost.addTab(tabSpec3);

        TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("말");
        tabSpec4.setContent(R.id.imageView4);
        tabHost.addTab(tabSpec4);
// add
        TabSpec tabSpec5 = tabHost.newTabSpec("TAG5").setIndicator("면적계산");
        tabSpec5.setContent(R.id.tab2);
        tabHost.addTab(tabSpec5);

        tabHost.setCurrentTab(0);

        init();

    }

// add
    void init(){


        editText3 = (EditText) findViewById(R.id.editText3);

        textView2 = (TextView) findViewById(R.id.textView2);


        btn2 = (Button) findViewById(R.id.button3);
        btn3 = (Button) findViewById(R.id.button4);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeToMeter();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeToPyeong();
            }
        });
    }

    void changeToMeter(){
        String s1 = editText3.getText().toString();
        double result = Double.parseDouble(s1)*Official;
        textView2.setText(result + " 제곱미터");

    }

    void changeToPyeong(){
        String s1 = editText3.getText().toString();
        double result = Math.round(Double.parseDouble(s1)/Official*100)/100.0;
        textView2.setText(result + " 평");
    }

}