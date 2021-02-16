package com.master.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Seconde extends Fragment {

    private EditText editText;
    private Button submit;
    private FragmentCommunication SM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seconde, container, false);
        editText = view.findViewById(R.id.text);
        submit = view.findViewById(R.id.submit);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        submit.setOnClickListener(v ->{
            String text = editText.getText().toString().trim();
            SM.sendData(text);
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            SM = (FragmentCommunication) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}