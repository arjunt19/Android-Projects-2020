package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView showBMI;
    private TextView tellBMI;
    private EditText get1; //age
    private EditText get2; //weight
    private EditText get3; //height


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBMI = findViewById(R.id.show_bmi);
        tellBMI = findViewById(R.id.bmi_tell);
        get1 = findViewById(R.id.first_entry);
        get2 = findViewById(R.id.second_entry);
        get3 = findViewById(R.id.third_entry);
    }

    public void displayBMI(View view) {
        int age = Integer.parseInt(get1.getText().toString());
        double weight = Double.parseDouble(get2.getText().toString());
        double height = Double.parseDouble(get3.getText().toString());
        double BMI = (703* weight)/Math.pow(height,2);
        BMI =  Math.round((BMI)*10)/10.0;
        String setter  = "" + BMI;
        showBMI.setText(setter);
        showBMI.setVisibility(View.VISIBLE);
        tellBMI.setVisibility(View.VISIBLE);
    }
}
