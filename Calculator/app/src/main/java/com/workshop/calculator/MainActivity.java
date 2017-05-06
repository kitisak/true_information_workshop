package com.workshop.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private EditText operand1;
    private EditText operand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operand1 = (EditText) findViewById(R.id.operand1);
        operand2 = (EditText) findViewById(R.id.operand2);

        addButton = (Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();

            }
        });

    }

    private void add() {
        int number1 = Integer.parseInt(operand1.getText().toString());
        int number2 = Integer.parseInt(operand2.getText().toString());
        Calculator calculator = new Calculator();
        int result = calculator.add(number1, number2);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }

}
