package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class CardDeck {
    private List<Card> _cards;

    public CardDeck(DeckColor color){
        _cards=new ArrayList<Card>();
        if(color==DeckColor.WHITE) {
            for (int i = 0; i < 3; i++) {
                _cards.add(new Card(0, false, DeckColor.WHITE));
                _cards.add(new Card(0, false, DeckColor.WHITE));
                _cards.add(new Card(1, false, DeckColor.WHITE));
                _cards.add(new Card(1, false, DeckColor.WHITE));
                _cards.add(new Card(2, false, DeckColor.WHITE));
                _cards.add(new Card(2, true, DeckColor.WHITE));
            }
        }
        if(color==DeckColor.YELLOW) {
            for (int i = 0; i < 3; i++) {
                _cards.add(new Card(0, false, DeckColor.YELLOW));
                _cards.add(new Card(0, false, DeckColor.YELLOW));
                _cards.add(new Card(1, false, DeckColor.YELLOW));
                _cards.add(new Card(2, false, DeckColor.YELLOW));
                _cards.add(new Card(3, false, DeckColor.YELLOW));
                _cards.add(new Card(4, true, DeckColor.YELLOW));
            }
        }
        if(color==DeckColor.RED) {
            for (int i = 0; i < 3; i++) {
                _cards.add(new Card(0, false, DeckColor.RED));
                _cards.add(new Card(0, false, DeckColor.RED));
                _cards.add(new Card(2, false, DeckColor.RED));
                _cards.add(new Card(3, false, DeckColor.RED));
                _cards.add(new Card(3, false, DeckColor.RED));
                _cards.add(new Card(4, true, DeckColor.RED));
            }
        }
        if(color==DeckColor.BLACK) {
            for (int i = 0; i < 3; i++) {
                _cards.add(new Card(0, false, DeckColor.BLACK));
                _cards.add(new Card(0, false, DeckColor.BLACK));
                _cards.add(new Card(3, false, DeckColor.BLACK));
                _cards.add(new Card(3, false, DeckColor.BLACK));
                _cards.add(new Card(4, false, DeckColor.BLACK));
                _cards.add(new Card(5, true, DeckColor.BLACK));
            }
        }
        reshuffleDiscardPile();
    }

    public void reset(){
        _cards.forEach(card->{
            card.reset();
        });
    }

    public void reshuffleDiscardPile(){
        _cards.stream().filter(card->card.getStatus()==CardStatus.DISCARDED).forEach(Card::reset);
        Collections.shuffle(_cards);
    }

    public Card drawCard(){
        if(cardsAvailableCount()>0){
            if(getCardsByStatus(CardStatus.DECK).count()==0){
                reshuffleDiscardPile();
            }
            Card cardToDraw = getCardsByStatus(CardStatus.DECK).findFirst().orElse(null);
            cardToDraw.draw();
            return cardToDraw;
        }else{
            return null;
        }
    }

    public Stream<Card> getCardsByStatus(CardStatus status){
        return _cards.stream().filter(card->card.getStatus()==status);
    }


    public int cardsAvailableCount(){
        int cardsNotReveled = (int) _cards.stream().filter(card->card.getStatus()!=CardStatus.REVEALED).count();
        int freeSpaces = (16-cardsNotReveled);
        if(cardsNotReveled>freeSpaces) return freeSpaces;
        return cardsNotReveled;
    }


    public void drawCards(int amount){
        for(int i=0;i<amount;i++){
            drawCard();
        }
    }
}
