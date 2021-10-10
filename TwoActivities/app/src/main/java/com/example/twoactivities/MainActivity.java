package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public EditText texty;
    public TextView reply;
    public TextView replyHeader;
    public static final String EXTRA_MESSAGE = "com.example.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texty = findViewById(R.id.send_text);
        reply = findViewById(R.id.reply_display);
        replyHeader = findViewById(R.id.reply_header);
        if(savedInstanceState != null){
            if(savedInstanceState.getBoolean(("reply_visible"))){
                replyHeader.setVisibility(View.VISIBLE);
                reply.setText(savedInstanceState.getString("reply_content"));
            }
        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        Intent intent = new Intent(this, activity_second.class);
        String text= texty.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, text);
        startActivityForResult(intent, TEXT_REQUEST);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if(resultCode ==  RESULT_OK){
            Intent replyed = data;
            
            replyHeader.setVisibility(View.VISIBLE);
            reply.setText(replyed.getStringExtra(activity_second.REPLY_TEXT));

        }
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(replyHeader.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_content", reply.getText().toString());
        }
    }

}
