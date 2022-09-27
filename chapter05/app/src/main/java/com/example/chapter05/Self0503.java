package com.example.chapter05;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Self0503 extends AppCompatActivity {

    EditText edt;
    EditText edt2;
    Button btn;
    Button btn2;
    TextView tview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        edt = new EditText(this);
        edt.setHint("여기에 입력하세요");
        baseLayout.addView(edt);

        btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        tview = new TextView(this);
        tview.setText("텍스트뷰입니다.");
        tview.setTextSize(20);
        tview.setTextColor(Color.MAGENTA);
        baseLayout.addView(tview);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                tview.setText(edt.getText().toString());
            }
        });

        btn2 = new Button(this);
        btn2.setText("날짜 시간 버튼입니다");
        btn2.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn2);

        edt2 = new EditText(this);
        edt2.setHint("여기에 날짜 시간이 나타납니다");
        edt2.setClickable(false);
        edt2.setFocusable(false);
        baseLayout.addView(edt2);

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String getTime = sdf.format(date);
                edt2.setText(getTime);
            }
        });
    }
}
