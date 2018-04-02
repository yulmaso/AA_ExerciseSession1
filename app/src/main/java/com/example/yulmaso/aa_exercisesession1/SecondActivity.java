package com.example.yulmaso.aa_exercisesession1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TEXT_KEY = "TEXT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String output_string = getIntent().getStringExtra(TEXT_KEY);
        TextView textOutput = findViewById(R.id.second_activity_text);
        if (output_string != null) textOutput.setText(output_string);
    }

    public static void openActivity(Activity activity, String passedText){
        Intent secondActivityIntent = new Intent(activity, SecondActivity.class);
        secondActivityIntent.putExtra(TEXT_KEY, passedText);
        activity.startActivity(secondActivityIntent);
    }
}
