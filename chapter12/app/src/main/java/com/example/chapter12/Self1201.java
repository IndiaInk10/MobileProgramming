package com.example.chapter12;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Self1201 extends AppCompatActivity {

    myDBHelper myHelper;
    EditText edtTxt;
    Button btnEx;
    SQLiteDatabase sqlDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self1201_main);
        setTitle("제품 테이블");

        edtTxt = (EditText) findViewById(R.id.edtTxt);

        btnEx = (Button) findViewById(R.id.btnEx);

        myHelper = new myDBHelper(this);

        btnEx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.
                sqlDB.close();

                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM product;", null);

                String str = "";

                while (cursor.moveToNext()) {
                    str += cursor.getString(0) + ", ";
                    str += cursor.getString(1) + ", ";
                    str += cursor.getString(2) + ", ";
                    str += cursor.getString(3) + ", ";
                    str += cursor.getString(4) + "\r\n";
                }

                edtTxt.setText(str);
                cursor.close();
                sqlDB.close();
            }
        });

    }

    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE product (prodName  CHAR(10),  price  INT, mDate  char(8), company  char(10), amount int);");
            db.execSQL("INSERT INTO product VALUES('TV',100,'20170722','Samsung',55);");
            db.execSQL("INSERT INTO product VALUES('Computer',150,'20190505','LG',7);");
            db.execSQL("INSERT INTO product VALUES('Monitor',50,'20210909','Daewoo',33);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS product");
            onCreate(db);
        }
    }

}
