package com.korelyakov.matannew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity  {
    TextView tv;
    Animation anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }


    public void Start(View view) {
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                finish();
    }

    public void Record(View view) {
        Button button2 = findViewById(R.id.button2);
        button2.setBackgroundColor(Color.BLUE);
        button2.setClickable(true);

    }

    public void Help (View view) {
            Button button3 = findViewById(R.id.button3);
            button3.setBackgroundColor(Color.BLUE);
            button3.setClickable(false);
        }
    }

