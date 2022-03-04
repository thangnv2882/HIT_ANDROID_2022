package com.hitandroid.buoi_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView user2, pass2, cb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layId();

        Intent intent = getIntent();
//
//        String strUser2 = intent.getStringExtra("user");
//        String strPass2 = intent.getStringExtra("pass");
//        String strCb2 = intent.getStringExtra("cb");
//
//
//
//        user2.setText(strUser2);
//        pass2.setText(strPass2);
//        cb2.setText(strCb2);

        Acc acc = intent.getParcelableExtra("acc");

        ArrayList<Acc> list = intent.getParcelableExtra("list");

        System.out.println(acc.getTk() + " - " + acc.getMk());

    }


    private void layId() {
        user2 = findViewById(R.id.user2);
        pass2 = findViewById(R.id.pass2);
        cb2 = findViewById(R.id.cb2);
    }

}