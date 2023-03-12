package com.example.myapplication;

public class Card {
        private int _value;
        private boolean _isCritical;

        private CardStatus _status;

        private DeckColor _color;

        public Card(int value, boolean isCritical,DeckColor color){
                _value=value;
                isCritical=isCritical;
                _color=color;
                _status=CardStatus.DECK;
        }

        public int getValue() {
                return _value;
        }

        public boolean isCritical(){
                return _isCritical;
        }

        public String getText(){
                if(_isCritical){
                        return "{"+String.valueOf(_value)+"}";
                }
                return String.valueOf(_value);
        }

        public DeckColor getColor(){
                return _color;
        }

        public CardStatus getStatus(){
                return _status;
        }

        public void draw(){
                if(_status==CardStatus.DECK){
                        _status=CardStatus.REVEALED;
                }
        }
        public void discard(){
                if(_status==CardStatus.REVEALED){
                        _status=CardStatus.DISCARDED;
                }
        }
        public void reset(){
                _status=CardStatus.DECK;
        }
}
