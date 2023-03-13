package com.example.myapplication;

public class DeckController {
    private DisplayOfRevealedCards _display;
    private CardDeckMissDisplay _missText;
    private DrawCounter _drawCounter;
    private DrawController _parentController;

    public DeckController(DisplayOfRevealedCards display, CardDeckMissDisplay missText, DrawCounter drawCounter){
        _display=display;
        _missText=missText;
        _drawCounter=drawCounter;
        _display.setParentController(this);
        setMode(DeckMode.OATHSWORN);
        updateViews();
    }

    public void draw(){
        _display.drawCards(_drawCounter.getValue());
        _drawCounter.reset();
        _missText.setStatus(_display.getDeck().getRemainingMisses(),(int)_display.getDeck().getCardsByStatus(CardStatus.DECK).count());
        updateViews();
    }

    public void discard() {
        _display.discard();
        updateViews();
    }

    public void reset() {
        _display.reset();
        updateViews();
    }

    public boolean hasRevealedCards() {
        if(_display.getDeck().getCardsByStatus(CardStatus.REVEALED).count()>0) return true;
        return false;
    }

    public int getMisses(){
        return _display.getDeck().getMisses();
    }

    public int getTotal() {
        return _display.getDeck().getTotal();
    }

    public void setParentController(DrawController controller){
        _parentController=controller;
    }

    public void updateViews(){
        updateViews(false);
    }

    public void updateViews(boolean noMiss) {
        if(_parentController!=null){
            _parentController.updateTextAndButton(noMiss);
        }
        _missText.setStatus(_display.getDeck().getRemainingMisses(),(int)_display.getDeck().getCardsByStatus(CardStatus.DECK).count());

    }

    public void setMode(DeckMode mode) {
        _display.setMode(mode);
    }
}
