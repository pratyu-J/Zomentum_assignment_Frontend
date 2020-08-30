package com.example.zomentum_assignment_frontend.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.zomentum_assignment_frontend.R;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                blinkEffect();
                startActivity(intent);
            }
        },3000);
    }

    public void blinkEffect(){
        ObjectAnimator animator = ObjectAnimator.ofInt(text,"textColor", Color.WHITE, getResources().getColor(R.color.dark_blue), Color.WHITE);
        animator.setDuration(3000);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }
}