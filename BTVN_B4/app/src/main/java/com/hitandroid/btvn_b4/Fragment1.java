package com.hitandroid.btvn_b4;

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

    EditText email, password;
    Button send;

    ISendData mISendData;

    public interface ISendData {
        void sendData(User user);
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
        email = mView.findViewById(R.id.email);
        password = mView.findViewById(R.id.password);
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
        String strEmail = email.getText().toString().trim();
        String strPassword = password.getText().toString().trim();
        User user = new User(strEmail, strPassword);
        mISendData.sendData(user);
    }

}