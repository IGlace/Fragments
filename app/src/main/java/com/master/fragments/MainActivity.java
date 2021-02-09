package com.master.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Button firstFragment, secondeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = findViewById(R.id.firstFrag);
        secondeFragment = findViewById(R.id.secondFrag);

        firstFragment.setOnClickListener(v -> {
            First first = new First();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, first).commit();
        });

        secondeFragment.setOnClickListener(v -> {
            Seconde seconde = new Seconde();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, seconde).addToBackStack(null).commit();
        });

    }
}