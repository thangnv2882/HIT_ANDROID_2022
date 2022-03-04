package com.hitandroid.loginfb;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    EditText email, pass, repass;
    CheckBox accept;
    Button register;
    TextView mess, already;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        getId();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Register_Success.class);

                if(email.getText().toString().compareTo("") == 0) {
                    mess.setText("Vui lòng nhập email.");
                }
                else if (pass.getText().toString().compareTo("") == 0) {
                    mess.setText("Vui lòng nhập mật khẩu.");
                }
                else if (repass.getText().toString().compareTo("") == 0) {
                    mess.setText("Vui lòng nhập nhập lại mật khẩu.");
                }
                else if(pass.getText().toString().compareTo(repass.getText().toString()) != 0) {
                    mess.setText("Mật khẩu không khớp");
                }
                else if(!accept.isChecked()) {
                    mess.setText("Vui lòng chấp nhận điều khoản");
                }

                else {
                    mess.setText("");
                    Acc acc = new Acc();
                    acc.setUser(email.getText().toString());
                    acc.setPass(pass.getText().toString());

                    intent.putExtra("acc", (Parcelable) acc);
                    startActivity(intent);

                    startActivity(intent);
                }
            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

    }

    public void getId() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        accept = findViewById(R.id.accept);
        register = findViewById(R.id.register);
        mess = findViewById(R.id.mess);
        already = findViewById(R.id.already);
    }


}