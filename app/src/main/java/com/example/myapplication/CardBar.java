package com.example.myapplication;

import android.view.View;
import android.widget.Button;

public class CardBar {
    private DrawCounter _cntWhite;
    private DrawCounter _cntYellow;
    private DrawCounter _cntRed;
    private DrawCounter _cntBlack;

    private DrawCounter[] _allCounters;

    public CardBar(Button btnWhite, Button btnYellow, Button btnRed, Button  btnBlack){
        this._cntBlack=new DrawCounter(btnBlack);;
        this._cntWhite=new DrawCounter(btnWhite);
        this._cntRed=new DrawCounter(btnRed);;
        this._cntYellow=new DrawCounter(btnYellow);;
        DrawCounter[] allCounters= {_cntWhite,_cntYellow, _cntRed,_cntBlack};
        _allCounters=allCounters;
        registerButtonEvents(_allCounters);
    }

    public DrawCounter getCounter(DeckColor color){
        if(color==DeckColor.WHITE) return this._cntWhite;
        if(color==DeckColor.YELLOW) return this._cntYellow;
        if(color==DeckColor.RED) return this._cntRed;
        return this._cntBlack;
    }

    private void registerButtonEvents(DrawCounter[] counters){
        for(DrawCounter counter : counters){
            counter.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    counter.increase();
                    counter.getButton().setText(counter.getValueAsString());
                }
            });
            counter.getButton().setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    counter.reset();
                    counter.getButton().setText(counter.getValueAsString());
                    return true;
                }
            });
        }
    }
}
