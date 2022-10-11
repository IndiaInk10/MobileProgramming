package com.example.chapter07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Self0702 extends AppCompatActivity {

    Button button;
    LinearLayout baseLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self0702_main);
        setTitle("배경색 바꾸기(Java 코드)");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button = (Button) findViewById(R.id.button);
        registerForContextMenu(button);

//        button1 = (Button) findViewById(R.id.button1);
//        registerForContextMenu(button1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == button) {
            menu.add(0, 1, 0, "배경색 (빨강)");
            menu.add(0, 2, 0, "배경색 (초록)");
            menu.add(0, 3, 0, "배경색 (파랑)");

            SubMenu subMenu = menu.addSubMenu("버튼 변경 >>");
            subMenu.add(0, 4, 0, "버튼 45도 회전");
            subMenu.add(0, 5, 0, "버튼 2배 확대");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2:
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button.setRotation(45);
                return true;
            case 5:
                button.setScaleX(2);
                return true;
        }
        return false;
    }

}
