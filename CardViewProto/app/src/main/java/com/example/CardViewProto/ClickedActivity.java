package com.example.CardViewProto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cardviewproto.R;

public class ClickedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked);
        Intent intent = getIntent();
        String message = intent.getStringExtra(Intent.EXTRA_COMPONENT_NAME);
        TextView texty = findViewById(R.id.clickedText);
        texty.setText(message);
    }
}
