package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    protected DeckController getWhiteController(CardBar cardBar){
        List<CardDisplay> displaysIndividualOathWhite= new ArrayList<CardDisplay>();
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard1)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard2)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard3)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard4)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard5)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard6)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard7)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard8)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard9)));
        displaysIndividualOathWhite.add(new CardDisplay(findViewById(R.id.btnOathWhiteCard10)));
        DisplayOfRevealedCards displayOathWhite=new DisplayOfRevealedCards(displaysIndividualOathWhite,DeckColor.WHITE);
        CardDeckMissDisplay whiteMissDisplay = new CardDeckMissDisplay(findViewById(R.id.textMissWhite));
        DeckController whiteController = new DeckController(displayOathWhite,whiteMissDisplay,cardBar.getCounter(DeckColor.WHITE));
        return whiteController;
    }
    protected DeckController getYellowController(CardBar cardBar){
        List<CardDisplay> displaysIndividualOathYellow= new ArrayList<CardDisplay>();
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard1)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard2)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard3)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard4)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard5)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard6)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard7)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard8)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard9)));
        displaysIndividualOathYellow.add(new CardDisplay(findViewById(R.id.btnOathYellowCard10)));
        DisplayOfRevealedCards displayOathYellow=new DisplayOfRevealedCards(displaysIndividualOathYellow,DeckColor.YELLOW);
        CardDeckMissDisplay yellowMissDisplay = new CardDeckMissDisplay(findViewById(R.id.textMissYellow));
        DeckController yellowController = new DeckController(displayOathYellow,yellowMissDisplay,cardBar.getCounter(DeckColor.YELLOW));
        return yellowController;
    }
    protected DeckController getRedController(CardBar cardBar){
        List<CardDisplay> displaysIndividualOathred= new ArrayList<CardDisplay>();
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard1)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard2)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard3)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard4)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard5)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard6)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard7)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard8)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard9)));
        displaysIndividualOathred.add(new CardDisplay(findViewById(R.id.btnOathRedCard10)));
        DisplayOfRevealedCards displayOathred=new DisplayOfRevealedCards(displaysIndividualOathred,DeckColor.RED);
        CardDeckMissDisplay redMissDisplay = new CardDeckMissDisplay(findViewById(R.id.textMissRed));
        DeckController redController = new DeckController(displayOathred,redMissDisplay,cardBar.getCounter(DeckColor.RED));
        return redController;
    }

    protected DeckController getBlackController(CardBar cardBar){
        List<CardDisplay> displaysIndividualOathblack= new ArrayList<CardDisplay>();
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard1)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard2)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard3)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard4)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard5)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard6)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard7)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard8)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard9)));
        displaysIndividualOathblack.add(new CardDisplay(findViewById(R.id.btnOathBlackCard10)));
        DisplayOfRevealedCards displayOathblack=new DisplayOfRevealedCards(displaysIndividualOathblack,DeckColor.BLACK);
        CardDeckMissDisplay blackMissDisplay = new CardDeckMissDisplay(findViewById(R.id.textMissBlack));
        DeckController blackController = new DeckController(displayOathblack,blackMissDisplay,cardBar.getCounter(DeckColor.BLACK));
        return blackController;
    }
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardBar oathCardBar = new CardBar(findViewById(R.id.btnOathWhite),findViewById(R.id.btnOathYellow),findViewById(R.id.btnOathRed),findViewById(R.id.btnOathBlack));
        DeckController whiteController = getWhiteController(oathCardBar);
        DeckController yellowController = getYellowController(oathCardBar);
        DeckController redController = getRedController(oathCardBar);
        DeckController blackController = getBlackController(oathCardBar);

        List<DeckController> allDeckControllers = new ArrayList<DeckController>();
        allDeckControllers.add(whiteController);
        allDeckControllers.add(yellowController);
        allDeckControllers.add(redController);
        allDeckControllers.add(blackController);

        DrawController drawController = new DrawController(findViewById(R.id.btnOathDraw),allDeckControllers,findViewById(R.id.resultText),oathCardBar);



        // Drawbutton

    }
}