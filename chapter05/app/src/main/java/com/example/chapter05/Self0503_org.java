package com.example.chapter05;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Self0503_org extends AppCompatActivity {

    EditText edt;
    Button btn;
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
    }
}
