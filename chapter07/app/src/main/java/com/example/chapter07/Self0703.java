package com.example.chapter07;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Self0703 extends AppCompatActivity {

    TextView tvName, tvEmail, tvFruit;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0703_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("사용자 정보 입력");

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvFruit = (TextView) findViewById(R.id.tvFruit);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            public void onClick(View v) {
                dialogView = (View) View.inflate(Self0703.this,
                        R.layout.dialog_layout, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(
                        Self0703.this);
                dlg.setTitle("좋아하는 과일 & 사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);
                // add
                final String[] versionArray = new String[] { "사과", "배", "귤", "수박"};
                final boolean checked[] = {false, false, false, false};

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dlgEdtName = (EditText) dialogView
                                        .findViewById(R.id.dlgEdt1);
                                dlgEdtEmail = (EditText) dialogView
                                        .findViewById(R.id.dlgEdt2);
                                String str = "좋아하는 과일 : ";          // add
                                for (int i = 0; i < checked.length; i++) {
                                    if (checked[i]) {
                                        str = str + versionArray[i];
                                        if(i != checked.length - 1)  str += ", ";
                                    }
                                }

                                tvName.setText("사용자 이름 : "+dlgEdtName.getText().toString());
                                tvEmail.setText("이메일 : " +dlgEdtEmail.getText()
                                        .toString());
                                tvFruit.setText(str);
                                // dlgLayout = null;
                            }
                        });

                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast toast = new Toast(Self0703.this);

                                toastView = (View) View.inflate(
                                        Self0703.this,
                                        R.layout.toast_layout, null);
                                toastText = (TextView) toastView
                                        .findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다");
                                toast.setView(toastView);
                                toast.show();
                            }
                        });
// add
                dlg.setMultiChoiceItems(versionArray, // 체크박스 리스트 항목
                        checked, // 초기값(선택여부) 배열
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checked[which] = isChecked;
                            }
                        });

                dlg.show();

            }
        });
    }
}

