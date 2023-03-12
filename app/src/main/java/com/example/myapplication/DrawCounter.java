package com.example.myapplication;

import android.widget.Button;

public class DrawCounter {
    private int _value;
    private Button _button;

    public DrawCounter(Button button){
        this._value=0;
        this._button=button;
    }

    public Button getButton(){
        return this._button;
    }

    public void increase(){
        if(this._value<16) this._value++;
    }

    public void reset(){
        this._value=0;
    }

    public int getValue(){
        return this._value;
    }

    public String getValueAsString(){
        if(this._value==0){
            return "";
        }
        return String.valueOf(this._value);
    }

}
