package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;

    private Button btnAdd;
    private Button btnSub;
    private Button btnMult;
    private Button btnDiv;

    private TextView tvResult;

    private String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        // прописываем обработчик
        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMult.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            float num1 = 0;
            float num2 = 0;
            float result = 0;

            // Проверяем поля на пустоту
            if (TextUtils.isEmpty(etNum1.getText().toString())
                    || TextUtils.isEmpty(etNum2.getText().toString())) {
                return;
            }

            // читаем EditText и заполняем переменные числами
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());

            // определяем нажатую кнопку и выполняем соответствующую операцию
            // в oper пишем операцию, потом будем использовать в выводе
            switch (v.getId()) {
                case R.id.btnAdd:
                    oper = "+";
                    result = num1 + num2;
                    break;
                case R.id.btnSub:
                    oper = "-";
                    result = num1 - num2;
                    break;
                case R.id.btnMult:
                    oper = "*";
                    result = num1 * num2;
                    break;
                case R.id.btnDiv:
                    oper = "/";
                    result = num1 / num2;
                    break;

                default:
                    break;
            }

            // формируем строку вывода
            tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);

        }
    };
}


