package com.example.temperatureapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class MainActivity extends AppCompatActivity {

    private EditText celsiusEditText;
    private Button convertButton;
    private TextView fahrenheitTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusEditText = findViewById(R.id.celsiusEditText);
        convertButton = findViewById(R.id.convertButton);
        fahrenheitTextView = findViewById(R.id.fahrenheitTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String celsiusStr = celsiusEditText.getText().toString();

        if (!celsiusStr.isEmpty()) {
            double celsius = Double.parseDouble(celsiusStr);
            double fahrenheit = (celsius * 9/5) + 32;
            fahrenheitTextView.setText(String.format("%.2f °F", fahrenheit));
        } else {
            fahrenheitTextView.setText("Enter a valid temperature in Celsius.");
        }
    }
}
