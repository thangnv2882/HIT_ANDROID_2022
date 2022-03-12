package com.hitandroid.fragmenttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ISendData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_frame_1, new Fragment1());
        fragmentTransaction.add(R.id.content_frame_2, new Fragment2());
        fragmentTransaction.commit();




    }

    @Override
    public void sendData(String email) {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.content_frame_2);
        fragment2.receiveDataFromFragment1(email);

    }
}