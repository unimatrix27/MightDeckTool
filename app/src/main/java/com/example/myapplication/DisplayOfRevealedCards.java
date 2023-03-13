package com.example.myapplication;

import java.util.List;

public class DisplayOfRevealedCards {

    private CardDeck _deck;

    private DrawCounter _counter;
    private List<CardDisplay> _displays;
    public DisplayOfRevealedCards(List<CardDisplay> cardDisplays, DeckColor color){
        _deck = new CardDeck(color);
        _displays = cardDisplays;
    }

    public CardDeck getDeck() {
        return _deck;
    }

    public Card drawCard() {
        CardDisplay nextFree=getNextFreeDisplay();
        if(nextFree!=null){
            Card randomCard = _deck.drawCard();
            nextFree.assignCard(randomCard);
            return randomCard;
        }
        return null;
    }

    private CardDisplay getNextFreeDisplay(){
        return _displays.stream().filter(display->display.isFree()).findFirst().orElse(null);
    }

    public void drawCards(int value) {
        for(int i=0;i<value;i++){
            drawCard();
        }
    }

    public void discard() {
        _displays.forEach(display->{
            display.detachCard();
        });
    }

    public void reset() {
        discard();
        _deck.reset();
    }
}
