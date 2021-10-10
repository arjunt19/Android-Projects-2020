package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText websiteText;
    private EditText locationText;
    private EditText sharetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        websiteText = findViewById(R.id.editText3);
        locationText = findViewById(R.id.editText4);
        sharetext = findViewById(R.id.editText5);
    }

    public void launchWebsite(View view) {
        Uri website = Uri.parse(websiteText.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, website);
        Intent chooser  = Intent.createChooser(intent, "Which browser?");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(chooser);
        }
        else{

            Toast toasty = Toast.makeText(this, "No Browser on phone", Toast.LENGTH_SHORT);
        }
    }

    public void shareText(View view) {
        ShareCompat.IntentBuilder
                .from(this)         // information about the calling activity
                .setType("text/plain")  // mime type for the data
                .setChooserTitle("Share this text with: ") //title for the app chooser
                .setText(sharetext.getText().toString())       // intent data
                .startChooser();    // send the intent
    }

    public void getLocation(View view) {
        Uri location  = Uri.parse("geo:0,0?q=" + locationText.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        Intent chooser  = Intent.createChooser(intent, "Which Map?");
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(chooser);
        }
        else{
            Log.d("Implicit Intents", "No activity handles intent");
            Toast toasty = Toast.makeText(this, "No Browser on phone", Toast.LENGTH_SHORT);
        }

    }

    public void launchCamera(View view) {
        Intent implicit = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(implicit.resolveActivity(getPackageManager())!=null){
            startActivity(implicit);
        }
    }
}
