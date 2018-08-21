package com.wills.user.pong.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Ball extends View {
    private int radius;
    private float cx, cy;
    private Paint paint;

    public Ball(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    public void setUp(int colour, int radius, float cx, float cy){
        this.radius = radius;
        this.cx = cx;
        this.cy = cy;

        paint.setColor(colour);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawCircle(cx, cy, radius, paint);
    }
}