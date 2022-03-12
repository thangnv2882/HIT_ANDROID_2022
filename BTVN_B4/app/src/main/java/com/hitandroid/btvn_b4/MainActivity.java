package com.hitandroid.btvn_b4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ISendData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frag1, new Fragment1());
        fragmentTransaction.add(R.id.frag2, new Fragment2());
        fragmentTransaction.commit();

    }

    @Override
    public void sendData(User user) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.frag2);

        fragment2.email_f2.setText(user.getEmail());
        fragment2.password_f2.setText(user.getPassword());

    }
}