package com.hitandroid.loginfb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Register_Success extends AppCompatActivity {

    TextView email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_success);

        getId();

        Intent intent = getIntent();

        Acc acc = intent.getParcelableExtra("acc");

        email.setText("Email: " + acc.getUser());
        pass.setText("Password: " + acc.getPass());

    }
    public void getId() {
        email = findViewById(R.id.email_register_success);
        pass = findViewById(R.id.pass_register_success);
    }
}