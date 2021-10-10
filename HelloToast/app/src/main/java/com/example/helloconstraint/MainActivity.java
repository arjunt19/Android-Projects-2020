package com.example.helloconstraint;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {//click handler -- invoked upon click of clickable ui element
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast  = Toast.makeText(this,R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mCount ==1){
            ((Button)findViewById(R.id.button_zero)).setBackgroundDrawable(new ColorDrawable(0xFF20438A));
        }
        if(mShowCount != null){
        mShowCount.setText(Integer.toString(mCount));
        }
        Button button = (Button) view;
        if(mCount %2 ==0){
           button.setBackgroundDrawable(new ColorDrawable(0xFFAC26F9));
        }
        else{
            button.setBackgroundDrawable(new ColorDrawable(0xFF26F9AD));
        }
    }

    public void makeZero(View view) {
        mCount =0;
        mShowCount.setText(Integer.toString(mCount));

        Button button = (Button) view;
        button.setBackgroundDrawable(new ColorDrawable(0xFFB62626));
    }
}
