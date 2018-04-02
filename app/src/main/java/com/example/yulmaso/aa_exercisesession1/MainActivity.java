package com.example.yulmaso.aa_exercisesession1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String text = null;
    private EditText textInput;
    private Toast errorToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInput = findViewById(R.id.text_input);
        errorToast  = Toast.makeText(this, "You haven't entered any text yet", Toast.LENGTH_LONG);

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

        Button emailButton = findViewById(R.id.email_button);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textInput.getText().toString().equals("")) {
                    errorToast.show();
                }
                else {
                    openEmail();
                }
            }
        });
    }

    private void openSecondActivity(){
        SecondActivity.openActivity(this, textInput.getText().toString());
    }

    private void openEmail(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"))
                .putExtra(Intent.EXTRA_EMAIL, text)
                .putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                .putExtra(Intent.EXTRA_TEXT, textInput.getText().toString());

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.email_client_error, Toast.LENGTH_LONG).show();
        }
    }
}
