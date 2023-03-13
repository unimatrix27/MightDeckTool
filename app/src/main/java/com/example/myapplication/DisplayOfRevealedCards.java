package com.example.myapplication;

import java.util.List;

public class DisplayOfRevealedCards {

    private DeckMode _mode;
    private CardDeck _activeDeck;
    private CardDeck _oathDeck;
    private CardDeck _monsterDeck;

    private DrawCounter _counter;
    private List<CardDisplay> _displays;

    private DeckController _parentController;
    public DisplayOfRevealedCards(List<CardDisplay> cardDisplays, DeckColor color){
        _oathDeck = new CardDeck(color);
        _monsterDeck = new CardDeck(color);
        _activeDeck = _oathDeck;
        _displays = cardDisplays;
        cardDisplays.forEach(display->{display.setParentDisplay(this);});
    }

    public void setMode(DeckMode mode){
        _mode=mode;
        if(mode== DeckMode.OATHSWORN){
            _activeDeck=_oathDeck;
        }else{
            _activeDeck=_monsterDeck;
        }
        if(_parentController!=null){
            _parentController.updateViews();
        }
        refreshCardDisplays();
        for (CardDisplay display : _displays) {
            display.updateButton();
        }
    }



    public CardDeck getDeck() {
        return _activeDeck;
    }

    public Card drawCard(){
        return drawCard(false);
    }

    public Card drawCard(boolean noMiss) {
        CardDisplay nextFree=getNextFreeDisplay();
        if(nextFree!=null){
            Card randomCard = _activeDeck.drawCard();
            nextFree.assignCard(randomCard);
            _parentController.updateViews(noMiss);
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
            display.discard();
        });
    }

    public void reset() {
        discard();
        _activeDeck.reset();
    }

    public void setParentController(DeckController deckController) {
        _parentController=deckController;
    }

    public void refreshCardDisplays(){
        _displays.forEach(display->{display.detach();});
        _activeDeck.getCardsByStatus(CardStatus.REVEALED).forEach(card->{
            getNextFreeDisplay().assignCard(card);
        });

    }
}
