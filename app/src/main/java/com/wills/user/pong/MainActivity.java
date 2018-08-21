package com.wills.user.pong;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.wills.user.pong.Models.Ball;
import com.wills.user.pong.Models.Bat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int BALL_RADIUS = 30;
    private static final int BAT_WIDTH = 300;

    private ConstraintLayout container;
    private ConstraintLayout lefthalf;
    private ConstraintLayout righthalf;
    private LinearLayout halfwayLine;

    private ArrayList<Bat> bats;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.main_container);
        lefthalf = findViewById(R.id.main_lefthalf);
        righthalf = findViewById(R.id.main_righthalf);
        halfwayLine = findViewById(R.id.main_halfway_line);

        bats = new ArrayList<>();

        lefthalf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                bats.get(1).setcx(motionEvent.getX());
                bats.get(1).invalidate();
                return true;
            }
        });

        righthalf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                bats.get(0).setcx(motionEvent.getX());
                bats.get(0).invalidate();
                return true;
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        addBall();
        addBat(false);
        addBat(true);
    }

    private void addBall(){
        float initialX = halfwayLine.getX() + halfwayLine.getWidth() / 2;
        float initialY = halfwayLine.getY() + halfwayLine.getHeight() / 2;

        Ball ball = new Ball(this);
        int ballColor = ContextCompat.getColor(this, R.color.ball_colour);
        ball.setUp(ballColor, BALL_RADIUS, initialX, initialY);

        container.addView(ball);
    }

    private void addBat(boolean top){
        float initialX = container.getX() + container.getWidth() / 2;
        float initialY = top ? container.getTop() + 30 : container.getBottom() - 30;

        Bat bat = new Bat(this);
        int batColor = ContextCompat.getColor(this, R.color.bat_colour);

        bat.setUp(batColor, BAT_WIDTH, initialX, initialY);

        bats.add(bat);
        container.addView(bat);
    }
}