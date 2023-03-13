package com.example.myapplication;

import android.view.View;
import android.widget.Button;

public class CardDisplay {
    private Button _button;
    private Card _card;

    public CardDisplay(Button button) {
        _button = button;
        _card=null;
        button.setVisibility(View.INVISIBLE);
    }

    public void assignCard(Card card){
        _card=card;
        updateButton();
    }

    public void detachCard(){
        if(_card!=null){
            _card.discard();
        }
        _card=null;
        updateButton();
    }

    public void updateButton(){
        if(_card==null){
            _button.setVisibility(View.INVISIBLE);
        }else{
            _button.setText(_card.getText());
            _button.setVisibility(View.VISIBLE);
        }
    }

    public boolean isFree(){
        if(_card==null) return true;
        return false;
    }

    public String getText(){
        if(_card!=null){
            return _card.getText();
        }else{
            return "";
        }
    }

}
