package com.hitandroid.btvn_b4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Fragment2 extends Fragment {

    EditText email_f2, password_f2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_2, container, false);
        email_f2 = mView.findViewById(R.id.email_f2);
        password_f2 = mView.findViewById(R.id.password_f2);

        return mView;
    }

}