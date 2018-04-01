package com.example.yulmaso.aa_exercisesession1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String text = null;
    private final EditText textInput = findViewById(R.id.text_input);
    private Toast errorToast = Toast.makeText(this, "You haven't entered any text yet", Toast.LENGTH_LONG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityButton = findViewById(R.id.activity_button);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInput.getText().toString().equals("")) {
                    errorToast.show();
                }
                else {
                    openSecondActivity();
                }
            }
        });
    }

    private void openSecondActivity(){
        text = textInput.getText().toString();
        SecondActivity.OpenActivity(this, text);
    }
}
