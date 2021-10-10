package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_second extends AppCompatActivity {
    public TextView textChange;
    public EditText reply;
    public static final String REPLY_TEXT = "com.example.twoactivities.reply.text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textChange =  findViewById(R.id.message_text);
        Intent intent = getIntent();
        textChange.setText(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
        reply  = findViewById(R.id.reply_text);

    }

    public void replyAction(View view) {
        Intent intent = new Intent();
        intent.putExtra(REPLY_TEXT, reply.getText().toString());
        setResult(RESULT_OK, intent);
        Log.d("foundit", "reply clicked");
        finish();
    }
}
