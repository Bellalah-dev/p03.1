package com.example.phonecalldial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callNumber(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        String phoneNumber = String.format("tel: %s",
                editText.getText().toString());
        Log.d(TAG, getString(R.string.dial_number) + phoneNumber);
        Toast.makeText(this,
                getString(R.string.dial_number) + phoneNumber,
                Toast.LENGTH_LONG).show();
        Intent callIntent = new Intent(Intent.ACTION_CALL);
// Set the data for the intent as the phone number.
        callIntent.setData(Uri.parse(phoneNumber));
// If package resolves to an app, send intent.
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
        }
    }
}