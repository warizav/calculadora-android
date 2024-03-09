package com.calculadora;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private double num1, num2;
    private TextView display;
    private StringBuilder currentNumber;
    private double result;
    private String currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        display.setVisibility(View.VISIBLE);
        currentNumber = new StringBuilder();
        result = 0;
        currentOperator = "";

        // Declaración de variables
        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSubtract = findViewById(R.id.btn_subtract);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);
        Button btnEquals = findViewById(R.id.btn_equals);
        Button btnClear = findViewById(R.id.btn_clear);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(@NonNull View view) {
        if (view.getId() == R.id.btn_0) {
            appendNumber("0");
        } else if (view.getId() == R.id.btn_1) {
            appendNumber("1");
        } else if (view.getId() == R.id.btn_2) {
            appendNumber("2");
        } else if (view.getId() == R.id.btn_3) {
            appendNumber("3");
        } else if (view.getId() == R.id.btn_4) {
            appendNumber("4");
        } else if (view.getId() == R.id.btn_5) {
            appendNumber("5");
        } else if (view.getId() == R.id.btn_6) {
            appendNumber("6");
        } else if (view.getId() == R.id.btn_7) {
            appendNumber("7");
        } else if (view.getId() == R.id.btn_8) {
            appendNumber("8");
        } else if (view.getId() == R.id.btn_9) {
            appendNumber("9");
        } else if (view.getId() == R.id.btn_add) {
            performOperation("+");
        } else if (view.getId() == R.id.btn_subtract) {
            performOperation("-");
        } else if (view.getId() == R.id.btn_multiply) {
            performOperation("*");
        } else if (view.getId() == R.id.btn_divide) {
            performOperation("/");
        } else if (view.getId() == R.id.btn_equals) {
            calculateResult();
        } else if (view.getId() == R.id.btn_clear) {
            clearDisplay();
        }
    }

    private void appendNumber(String number) {
        currentNumber.append(number);
        display.setText(display.getText().toString() + currentNumber.toString());
    }

    @SuppressLint("SetTextI18n")
    private void performOperation(String operator) {
        if (currentNumber.length() > 0) {
            double number = Double.parseDouble(currentNumber.toString());
            switch (currentOperator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    if (number != 0) {
                        result /= number;
                    } else {
                        display.setText("Error");
                        clearDisplay();
                        return;
                    }
                    break;
                default:
                    result = number;
                    break;
            }
        }
        currentNumber.setLength(0);
        currentOperator = operator;
        if (result == (long) result) {
            display.setText(String.format("%d", (long) result)+ " " + currentOperator);
        } else {
            display.setText(String.valueOf(result) + " " + currentOperator);
        }
    }

    @SuppressLint("SetTextI18n")
    private void calculateResult() {
        if (currentNumber.length() > 0) {
            double number = Double.parseDouble(currentNumber.toString());
            switch (currentOperator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    if (number != 0) {
                        result /= number;
                    } else {
                        display.setText("Error");
                        clearDisplay();
                        return;
                    }
                    break;
                default:
                    result = number;
                    break;
            }
        }
        currentNumber.setLength(0);
        currentOperator = "";
        if (result == (long) result) {
            display.setText(String.format("%d", (long) result)+ " " + currentOperator);
        } else {
            display.setText(String.valueOf(result) + " " + currentOperator);
        }
    }

    private void clearDisplay() {
        currentNumber.setLength(0);
        result = 0;
        currentOperator = "";
        display.setText("");
    }
}
