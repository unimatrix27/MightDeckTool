package com.example.myapplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardDeckTest {
    private CardDeck cardDeck;

    @Test
    public void drawCard() {
        cardDeck = new CardDeck(DeckColor.YELLOW);
        Card card1=cardDeck.drawCard();
        Card card2=cardDeck.drawCard();
        assertEquals(2,cardDeck.getCardsByStatus(CardStatus.REVEALED).count());
        assertEquals(CardStatus.REVEALED,card1.getStatus());
        cardDeck.discard();
        assertEquals(CardStatus.DISCARDED,card1.getStatus());
        cardDeck.reset();
        assertEquals(CardStatus.DECK,card1.getStatus());
    }

    @Test
    public void getCardsByStatus() {
        cardDeck = new CardDeck(DeckColor.YELLOW);
        cardDeck.drawCards(9);
        assertEquals(9,cardDeck.getCardsByStatus(CardStatus.REVEALED).count());
        cardDeck.discard();
        assertEquals(0,cardDeck.getCardsByStatus(CardStatus.REVEALED).count());
        assertEquals(9,cardDeck.getCardsByStatus(CardStatus.DISCARDED).count());
        cardDeck.drawCards(5);
        assertEquals(5,cardDeck.getCardsByStatus(CardStatus.REVEALED).count());
        cardDeck.discard();
        assertEquals(14,cardDeck.getCardsByStatus(CardStatus.DISCARDED).count());
        cardDeck.drawCards(5);
        assertEquals(5,cardDeck.getCardsByStatus(CardStatus.REVEALED).count());
        assertEquals(0,cardDeck.getCardsByStatus(CardStatus.DISCARDED).count());
    }

    @Test
    public void cardsAvailableCount() {
        cardDeck = new CardDeck(DeckColor.YELLOW);
        assertEquals(10,cardDeck.cardsAvailableCount());
        cardDeck.drawCards(4);
        assertEquals(6,cardDeck.cardsAvailableCount());
        cardDeck.drawCards(4);
        assertEquals(2,cardDeck.cardsAvailableCount());
        cardDeck.drawCards(4);
        assertEquals(0,cardDeck.cardsAvailableCount());
        cardDeck.reset();
        assertEquals(10,cardDeck.cardsAvailableCount());
        cardDeck.drawCards(9);
        assertEquals(1,cardDeck.cardsAvailableCount());
        cardDeck.discard();
        assertEquals(10,cardDeck.cardsAvailableCount());
        cardDeck.drawCards(8);
        assertEquals(2,cardDeck.cardsAvailableCount());
    }

}