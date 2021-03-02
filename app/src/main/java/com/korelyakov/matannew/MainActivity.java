package com.korelyakov.matannew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int a;
    int b;
    int c;
    int d;
    TextView b1, b2,b3;
    EditText a1;
    int countT = 0;
    int countF = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION //отвечает за скрытие
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY|View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

        a = (int) (Math.random()*10);
        b = (int) (Math.random()*10);
        c = a+b;

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        a1 = findViewById(R.id.a1);

        b1.setText(Integer.toString(a) + " + " + Integer.toString(b) + " = ?");

        //     d = Integer.parseInt(a1.getText().toString());

    }

    public void ShowWin() {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        alertbox.setCancelable(false);
        alertbox.setTitle("Победа");
        String TextToast = "Вы отлично считаете в уме!" ;
        alertbox.setMessage(TextToast);
        alertbox.setNeutralButton("Рестарт", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                recreate();
            }
        });
        alertbox.show();
    }

    public void ShowOver() {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
        alertbox.setCancelable(false);
        alertbox.setTitle("Поражение");
        String TextToast = "Вам стоит потренироваться еще!" ;
        alertbox.setMessage(TextToast);
        alertbox.setNeutralButton("Рестарт", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                recreate();
            }
        });
        alertbox.show();
    }

    public void onMyButtonClick(View view) {
        if (a1.length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Поле пустое, введите число!", Toast.LENGTH_SHORT);
            toast.show();
            return;
        } else {
            try {
                d = Integer.parseInt(a1.getText().toString());
            }
            catch (Exception ex){
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ошибка! Введен текст!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
        }
           if( d == c){
               countT++;
              b2.setText("Правильно = " + Integer.toString(countT));
               a1.setText(null);
           }
           else {
               countF++;
               b3.setText("Ошибок = " + Integer.toString(countF));
               a1.setText(null);
           }
        a = (int) (Math.random()*10);
        b = (int) (Math.random()*10);
        c = a+b;
        b1.setText(Integer.toString(a) + " + " + Integer.toString(b) + " = ?");
        if(countT >= 5){
            a = 10 + (int) (Math.random()*90);
            b = 10 + (int) (Math.random()*90);
            c = a+b;
            b1.setText(Integer.toString(a) + " + " + Integer.toString(b) + " = ?");
        }
        if(countT >= 10){
            a = 100 + (int) (Math.random()*900);
            b = 100 + (int) (Math.random()*900);
            c = a+b;
            b1.setText(Integer.toString(a) + " + " + Integer.toString(b) + " = ?");
        }
        if(countT == 15){
        ShowWin();
        }
        if (countF >= 3){
         ShowOver();
        }
    }
}
