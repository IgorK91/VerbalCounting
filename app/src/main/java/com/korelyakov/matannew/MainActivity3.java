package com.korelyakov.matannew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    int a;
    int b;
    int countLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void Light (View view) {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button1.setBackgroundColor(Color.BLUE);
        button2.setBackgroundColor(Color.WHITE);
        button3.setBackgroundColor(Color.WHITE);
        a = (int) (Math.random()*10);
        b = (int) (Math.random()*10);
        countLvl = 0;
    }

    public void Middle (View view) {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button2.setBackgroundColor(Color.BLUE);
        button1.setBackgroundColor(Color.WHITE);
        button3.setBackgroundColor(Color.WHITE);
        a = 10 + (int) (Math.random()*90);
        b = 10 + (int) (Math.random()*90);
        countLvl = 1;
    }

    public void Hard (View view) {
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        button3.setBackgroundColor(Color.BLUE);
        button2.setBackgroundColor(Color.WHITE);
        button1.setBackgroundColor(Color.WHITE);
        a = 100 + (int) (Math.random()*900);
        b = 100 + (int) (Math.random()*900);
        countLvl = 2;
    }

    public void Start(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("num1", a);
        intent.putExtra("num2", b);
        intent.putExtra("num3", countLvl);
        startActivity(intent);
        finish();
    }
}