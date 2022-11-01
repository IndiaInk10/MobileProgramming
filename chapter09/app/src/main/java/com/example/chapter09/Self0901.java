package com.example.chapter09;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Self0901 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(30);
            canvas.drawLine(100, 30, 900, 900, paint);

            paint.setColor(Color.GREEN);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(900, 30, 100, 900, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.argb(0.5f, 1f, 0f, 0f));
            paint.setStrokeWidth(15);
            canvas.drawRect(450, 750, 450 + 100, 750 + 100, paint);
            paint.setColor(Color.BLUE);
            canvas.drawRect(450, 150, 450 + 100, 150 + 100, paint);

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.BLACK);
            canvas.drawRect(100, 350, 100 + 200, 350 + 200, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            RectF rf = new RectF(700, 350, 700 + 200, 350 + 200);
            canvas.drawRoundRect(rf, 30, 30, paint);

            paint.setStrokeWidth(15);
            canvas.drawOval(100, 950, 900, 1250, paint);

            rf.set(450, 950, 450 + 150, 950 + 150);
            canvas.drawArc(rf, 40, 110, true, paint);
        }
    }

}