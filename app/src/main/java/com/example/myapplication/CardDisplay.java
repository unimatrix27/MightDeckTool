package com.example.myapplication;

import android.view.View;
import android.widget.Button;

public class CardDisplay {
    private Button _button;
    private Card _card;
    private DisplayOfRevealedCards _parentDisplay;

    public CardDisplay(Button button) {
        _button = button;
        _card=null;
        button.setVisibility(View.INVISIBLE);
    }

    public void assignCard(Card card){
        _card=card;
        updateButton();
    }

    public void discard(){
        if(_card!=null){
            _card.discard();
        }
        detach();
        updateButton();
    }
    public void detach(){
        _card=null;
    }

    public void updateButton(){
        if(_card==null){
            _button.setVisibility(View.INVISIBLE);
        }else{
            _button.setText(_card.getText());
            _button.setVisibility(View.VISIBLE);
            _button.setEnabled(true);
            if(!_card.isCritical()){
                _button.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        _parentDisplay.drawCard();
                        discard();
                        return false;
                    }
                });
            }else{
                _button.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        ((Button) view).setEnabled(false);
                        _parentDisplay.drawCard(true);
                        return false;
                    }
                });
            }
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

    public void setParentDisplay(DisplayOfRevealedCards displayOfRevealedCards) {
        _parentDisplay = displayOfRevealedCards;
    }
}
