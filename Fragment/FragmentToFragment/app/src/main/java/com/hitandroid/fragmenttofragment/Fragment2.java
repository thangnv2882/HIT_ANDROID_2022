package com.hitandroid.fragmenttofragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment2 extends Fragment {

    EditText editText;
    Button update;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_2, container, false);

        editText = mView.findViewById(R.id.email);
//        update = mView.findViewById(R.id.update);
//
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                updateDataToFragment1();
//            }
//        });
        return mView;
    }


//    private void updateDataToFragment1() {
//
//    }

    public void receiveDataFromFragment1(String email) {
        editText.setText(email);
    }
}