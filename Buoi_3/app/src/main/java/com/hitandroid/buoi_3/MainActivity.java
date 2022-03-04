package com.hitandroid.buoi_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt;
    EditText user, pass;
    CheckBox cb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layId();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                Acc acc = new Acc();
                acc.setTk(user.getText().toString());
                acc.setMk(pass.getText().toString());

                intent.putExtra("acc", (Parcelable) acc);

                ArrayList<Acc> list = new ArrayList<>();

                intent.putParcelableArrayListExtra("list", list);

//                String strUser = user.getText().toString();
//                intent.putExtra("user", strUser);
//
//                String strPass = pass.getText().toString();
//                intent.putExtra("pass", strPass);
//
//                String strCb = "";
//                if(cb.isChecked()) {
//                    strCb = "Có lưu mật khẩu";
//                }
//                else {
//                    strCb = "Không lưu mật khẩu";
//                }
//                intent.putExtra("cb", strCb);

                startActivity(intent);
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.putExtra(Intent.EXTRA_TEXT, "message");
//                startActivity(intent);
            }
        });
    }

    private void layId() {
        bt = findViewById(R.id.button);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        cb = findViewById(R.id.cb);
    }
}