package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class DrawController {
    private Button _drawButton;
    private List<DeckController> _deckControllers;
    private DrawButtonState _drawButtonState;
    private TextView _resultText;

    private CardBar _cardBar;

    public DrawController(Button button, List<DeckController> deckControllers, TextView resultText, CardBar cardBar){
        _drawButton =button;
        _drawButtonState =DrawButtonState.DRAW;
        _resultText=resultText;
        _cardBar=cardBar;
        _deckControllers=deckControllers;

        _drawButton.setText(getDrawButtonText());

        _drawButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(_drawButtonState==DrawButtonState.DRAW) {
                    draw();
                }else if (_drawButtonState==DrawButtonState.CLEAR){
                    discard();
                }else {
                    discard();
                };

            }
        });
        updateTextAndButton();

        _drawButton.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                    discard();
                    reset();
                return false;
            }
        });

        _deckControllers.forEach(controller->{ controller.setParentController(this);});
    }


    private boolean hasRevealedCards() {
        return !_deckControllers.stream().allMatch(controller->controller.hasRevealedCards()==false);
    }

    private void discard() {
        _deckControllers.forEach(deckController->{
            deckController.discard();
        });
        //updateTextandButton();
    }

    private void reset() {
        _deckControllers.forEach(deckController->{
            deckController.reset();
        });
        //updateTextandButton();
    }

    public void draw(){
        _deckControllers.forEach(deckController->{
            deckController.draw();
        });
        //updateTextandButton();

    }

    public void updateTextAndButton(){
        updateTextAndButton(false);
    }
    public void updateTextAndButton(boolean noMiss){
        if(hasRevealedCards()){
            _drawButtonState=DrawButtonState.CLEAR;
        }else{
            _drawButtonState=DrawButtonState.DRAW;
        }
        _drawButton.setText(getDrawButtonText());
        _resultText.setText(getResultText(noMiss));

    }

    private String getResultText(boolean noMiss) {
        String displayTest = String.valueOf(getTotal());
        if(!noMiss && isMiss()) displayTest+=" (MISS)";
        return displayTest;
    }

    private boolean isMiss(){
        int amountOfMisses = _deckControllers.stream().mapToInt(controller->controller.getMisses()).sum();
        if(amountOfMisses>1) return true;
        return false;
    }
    private int getTotal(){
        return _deckControllers.stream().mapToInt(controller->controller.getTotal()).sum();
    }

    public String getDrawButtonText(){
        if(_drawButtonState ==DrawButtonState.DRAW){
            return "Draw";
        }
        if(_drawButtonState ==DrawButtonState.CLEAR){
            return "Clear";
        }
        return "Reveal";
    }

    public void setMode(DeckMode mode) {
        _deckControllers.forEach(controller->{controller.setMode(mode);});
    }
}
