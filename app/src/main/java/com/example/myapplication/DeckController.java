package com.example.myapplication;

public class DeckController {
    private DisplayOfRevealedCards _display;
    private CardDeckMissDisplay _missText;
    private DrawCounter _drawCounter;
    private CardDeck _deck;

    public DeckController(DisplayOfRevealedCards display, CardDeckMissDisplay missText, DrawCounter drawCounter){
        _display=display;
        _missText=missText;
        _drawCounter=drawCounter;
        _deck =display.getDeck();
        draw();
    }

    public void draw(){
        _display.drawCards(_drawCounter.getValue());
        _drawCounter.reset();
        _missText.setStatus(_deck.getRemainingMisses(),(int)_deck.getCardsByStatus(CardStatus.DECK).count());
    }

    public void discard() {
        _display.discard();
    }

    public void reset() {
        _display.reset();
    }

    public boolean hasRevealedCards() {
        if(_deck.getCardsByStatus(CardStatus.REVEALED).count()>0) return true;
        return false;
    }

    public int getMisses(){
        return _deck.getMisses();
    }

    public int getTotal() {
        return _deck.getTotal();
    }
}
