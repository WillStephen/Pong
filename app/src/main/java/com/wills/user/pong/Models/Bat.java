package com.wills.user.pong.Models;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Bat extends View {
    private static final int THICKNESS = 24;

    private int width;
    private float cx, cy;
    private Paint paint;

    public Bat(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
    }

    public void setUp(int colour, int width, float cx, float cy){
        this.width = width;
        this.cx = cx;
        this.cy = cy;

        paint.setColor(colour);
    }

    public void setcx(float cx){
        this.cx = cx;
    }

    public void setcy(float cy){
        this.cy = cy;
    }

    private Rect createRect(){
        int left = Math.round(cx - (width / 2));
        int right = Math.round(cx + (width / 2));
        int top = Math.round(cy - (THICKNESS / 2));
        int bottom = Math.round(cy + (THICKNESS / 2));

        return new Rect(left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(createRect(), paint);
    }
}