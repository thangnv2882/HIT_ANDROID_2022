package com.hitandroid.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    EditText editText;
    Button send;

    ISendData mISendData;

    public interface ISendData {
        void sendData(String email);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mISendData = (ISendData) getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_1, container, false);

        editText = mView.findViewById(R.id.email);
        send = mView.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToFragment2();
            }
        });
        return mView;
    }


    private void sendDataToFragment2() {
        String strEmail = editText.getText().toString().trim();
        mISendData.sendData(strEmail);
    }
}