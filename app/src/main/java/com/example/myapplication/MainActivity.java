package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private CardBar _oathCardBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _oathCardBar = new CardBar(findViewById(R.id.btnOathWhite),findViewById(R.id.btnOathYellow),findViewById(R.id.btnOathRed),findViewById(R.id.btnOathBlack));

        // Drawbutton

        // 4 Card Decks
    }
}