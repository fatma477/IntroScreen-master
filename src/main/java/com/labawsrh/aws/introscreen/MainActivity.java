package com.labawsrh.aws.introscreen;

import
        android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText) findViewById( R.id.etUserName);
        PasswordEt = (EditText) findViewById(R.id.etPassword);
    }


    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type="login";

        BackgroundWorker BackgroundWorker = new BackgroundWorker(this);
        BackgroundWorker.execute(type,username,password);

    }

    public void Inscrire(View view) {
        Intent intent = new Intent(getApplicationContext(), inscrActivity.class);
        startActivity(intent);
    }
    public void Join(View view) {
        Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(intent);
    }
}
