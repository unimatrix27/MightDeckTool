package com.example.myapplication;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class CardTest {

    private Card card;

    @Test
    public void getValueOf0() {
        card = new Card(0,false,DeckColor.WHITE);
        assertEquals(0,card.getValue());
    }
    @Test
    public void getValueOf1() {
        card = new Card(1,false,DeckColor.WHITE);
        assertEquals(1,card.getValue());
    }

    @Test
    public void isCriticalTrue() {
        card = new Card(1,true,DeckColor.WHITE);
        assertTrue(card.isCritical());
    }
    @Test
    public void isCriticalFalse() {
        card = new Card(1,false,DeckColor.WHITE);
        assertFalse(card.isCritical());
    }

    @Test
    public void getTextCrit1() {
        card = new Card(1,true,DeckColor.WHITE);
       assertEquals("{1}",card.getText());
    }
    @Test
    public void getTextCrit3() {
        card = new Card(3,true,DeckColor.WHITE);
        assertEquals("{3}",card.getText());
    }
    @Test
    public void getText1() {
        card = new Card(1,false,DeckColor.WHITE);
        assertEquals("1",card.getText());
    }

    @Test
    public void getColor() {
        card = new Card(1,false,DeckColor.WHITE);
        assertEquals(DeckColor.WHITE,card.getColor());
    }

    @Test
    public void getStatus() {
        card = new Card(1,false,DeckColor.WHITE);
        assertEquals(CardStatus.DECK,card.getStatus());
    }

    @Test
    public void draw() {
        card = new Card(1,false,DeckColor.WHITE);
        card.draw();
        assertEquals(CardStatus.REVEALED,card.getStatus());
    }

    @Test
    public void discard() {
        card = new Card(1,false,DeckColor.WHITE);
        card.draw();
        card.discard();
        assertEquals(CardStatus.DISCARDED,card.getStatus());
    }

    @Test
    public void reset() {
        card = new Card(1,false,DeckColor.WHITE);
        card.draw();
        card.discard();
        card.reset();
        assertEquals(CardStatus.DECK,card.getStatus());
    }
}