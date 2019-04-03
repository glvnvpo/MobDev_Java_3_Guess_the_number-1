package com.example.number;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Button btneasy, btnmedium, btnhard, btnexit;

    int n1=1;
    int n2=100;
    int random = n1 + (int) (Math.random() * n2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        btneasy = findViewById(R.id.button_easy);
        btnmedium = findViewById(R.id.button_medium);
        btnhard = findViewById(R.id.button_hard);
        btnexit = findViewById(R.id.button_exit);

        bControl.setOnClickListener(this);

        tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")" +random);


        View.OnClickListener clickListener_easy = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = 1;
                n2 = 100;
                tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
                random = n1 + (int) (Math.random() * n2);

            }
        };

        View.OnClickListener clickListener_medium = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = 1;
                n2 = 1000;
                tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
                random = n1 + (int) (Math.random() * n2);

            }
        };

        View.OnClickListener clickListener_hard = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = 1;
                n2 = 10000;
                tvInfo.setText("Попробуйте угадать число ("+n1+"-"+n2+")");
                random = n1 + (int) (Math.random() * n2);

            }
        };

        View.OnClickListener clickListener_exit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        };


        btneasy.setOnClickListener(clickListener_easy);
        btnmedium.setOnClickListener(clickListener_medium);
        btnhard.setOnClickListener(clickListener_hard);
        btnexit.setOnClickListener(clickListener_exit);
    }

    public void onClick(View view) {
        String value = etInput.getText().toString();
        tvInfo.setText(value);

        if (value.trim().length() == 0) {
            tvInfo.setText("Введите число! ("+n1+"-"+n2+")");
        }
        else {
            int valint = Integer.parseInt(value);
            if ((valint>n2) || (valint<n1)) {
                tvInfo.setText("Введенное число вне границ диапазона!  ("+n1+"-"+n2+")");
            }
            else if (valint==random) {
                tvInfo.setText("Вы выиграли!");

            }
            else if (valint<random) {
                tvInfo.setText("Недолет  ("+n1+"-"+n2+")");
            }
            else {
                tvInfo.setText("Перелет ("+n1+"-"+n2+")");
            }

        }


    }



}




