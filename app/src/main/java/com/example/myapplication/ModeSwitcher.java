package com.example.myapplication;

import android.view.View;
import android.widget.Button;

public class ModeSwitcher {
    private DrawController _controller;
    private Button _button;
    private DeckMode _mode;

    public ModeSwitcher(DrawController controller, Button button){
        _controller=controller;
        _button=button;
        _mode=DeckMode.OATHSWORN;
        _button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press();
            }
        });
    }


    public void press(){
        if(_mode==DeckMode.MONSTER){
            _mode=DeckMode.OATHSWORN;
        }else{
            _mode=DeckMode.MONSTER;
        }
        updateControllerAndText();
    }

    public void updateControllerAndText(){
        _controller.setMode(_mode);
        _button.setText(_mode==DeckMode.MONSTER ? "Monster" : "Oathsworn");
    }
}
