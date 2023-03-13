package com.example.myapplication;

import android.widget.TextView;

public class CardDeckMissDisplay {
    private TextView _missText;
    private int _misses;
    private int _cardsRemaining;
    public CardDeckMissDisplay(TextView missTextView){
        _missText=missTextView;
        setStatus(6,18);
    }

    public void setStatus(int misses, int cardsRemaining){
        _misses=misses;
        _cardsRemaining=cardsRemaining;
        _missText.setText(String.valueOf(misses)+"/"+String.valueOf(cardsRemaining));
    }
}
