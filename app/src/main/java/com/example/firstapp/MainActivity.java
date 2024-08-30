package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnPlus,btnSub,btnMul,btnDiv, btnMod;
    TextView txtResult;
    EditText txtX,txtY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initControl();
    }
    private void initControl(){
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View
                                        v) {
                performCalculation(Operation.ADDITION);
            }
        });

        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation(Operation.SUBTRACTION);

            }
        });

        btnMul = findViewById(R.id.btnMul);
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation(Operation.MULTIPLICATION);
            }
        });

        btnDiv = findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation(Operation.DIVISION);
            }
        });

        btnMod = findViewById(R.id.btnMod);
        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation(Operation.MODULO);
            }
        });
    }

    private void performCalculation(Operation operation) {
        try {
            int x = Integer.parseInt(txtX.getText().toString());
            int y = Integer.parseInt(txtY.getText().toString());

            double result;
            switch (operation) {
                case ADDITION:
                    result = x + y;
                    break;
                case SUBTRACTION:
                    result = x - y;
                    break;
                case MULTIPLICATION:
                    result = x * y;
                    break;
                case DIVISION:

                    if (y == 0) {
                        Toast.makeText(MainActivity.this, "Division by zero is not allowed!", Toast.LENGTH_SHORT).show();
                        return; // Prevent invalid calculation
                    }
                    result = (double) x / y;
                    break;
                case MODULO:
                    if (y == 0) {
                        Toast.makeText(MainActivity.this, "Modulo by zero is not allowed!", Toast.LENGTH_SHORT).show();
                        return; // Prevent invalid calculation
                    }
                    result = x % y;
                    break;
                default:
                    throw new IllegalStateException("Unexpected operation: " + operation);
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Invalid number format!", Toast.LENGTH_SHORT).show();
        }
    }

    private enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        MODULO
    }

}