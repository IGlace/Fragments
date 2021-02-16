package com.master.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentCommunication {

    private Button firstFragment, secondeFragment;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = findViewById(R.id.firstFrag);
        secondeFragment = findViewById(R.id.secondFrag);
        text = findViewById(R.id.text);

        Seconde seconde = new Seconde();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, seconde).commit();
    }

    @Override
    public void sendData(String message) {
        First first = new First();
        Bundle args = new Bundle();
        args.putString("msg", message);
        first.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, first).addToBackStack(null).commit();
    }
}