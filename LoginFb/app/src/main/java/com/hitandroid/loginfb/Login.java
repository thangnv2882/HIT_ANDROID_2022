package com.hitandroid.loginfb;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button login, register;
    EditText email, pass;
    TextView mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getId();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Login_Success.class);
                if(email.getText().toString().compareTo("") == 0) {
                    mess.setText("Vui lòng nhập email.");
                }
                else if (pass.getText().toString().compareTo("") == 0) {
                    mess.setText("Vui lòng nhập mật khẩu.");
                }
                else {
                    mess.setText("");
                    Acc acc = new Acc();
                    acc.setUser(email.getText().toString());
                    acc.setPass(pass.getText().toString());

                    intent.putExtra("acc", (Parcelable) acc);
                    startActivity(intent);
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });


    }

    public void getId() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        mess = findViewById(R.id.mess);
    }
}