package com.example.yulmaso.aa_exercisesession1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textOutput = findViewById(R.id.second_activity_text);
        textOutput.setText(text);
    }

    public static void OpenActivity(Activity activity, String passedText){
        Intent secondActivityIntent = new Intent(activity, SecondActivity.class);
        secondActivityIntent.putExtra(text, passedText);
        activity.startActivity(secondActivityIntent);
    }
}
