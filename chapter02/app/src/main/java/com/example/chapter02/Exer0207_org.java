package com.example.chapter02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Exer0207_org extends AppCompatActivity {

    EditText edit1;
    Button btnToast, btnHomepage;
    RadioButton rdoQ, rdoR;
    ImageView ivAndroid;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exer0207_main_org);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("좀 그럴듯한 앱");

        edit1 = (EditText) findViewById(R.id.edit1);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnHomepage = (Button) findViewById(R.id.btnHomepage);
        rdoQ = (RadioButton) findViewById(R.id.rdoQ);
        rdoR = (RadioButton) findViewById(R.id.rdoR);
        ivAndroid = (ImageView) findViewById(R.id.ivAndroid);

        btnToast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        edit1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        btnHomepage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(edit1
                        .getText().toString()));
                startActivity(mIntent);
            }
        });

        rdoQ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ivAndroid.setImageResource(R.drawable.q10);
            }
        });

        rdoR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ivAndroid.setImageResource(R.drawable.r);
            }
        });
    }

}