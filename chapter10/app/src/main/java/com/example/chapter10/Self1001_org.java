package com.example.chapter10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Self1001_org extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self1001_main_org);
        setTitle("메인 액티비티 (수정)");

        final RadioButton rdoSecond = (RadioButton) findViewById(R.id.rdoSecond);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;

                if (rdoSecond.isChecked() == true) {
                    intent = new Intent(getApplicationContext(),
                            SecondActivity1001_org.class);
                }
                else {
                    intent = new Intent(getApplicationContext(),
                            ThirdActivity1001_org.class);
                }

                startActivity(intent);
            }
        });
    }

}
