import DeckOfCardsAPI.ApiAccess;
import DeckOfCardsAPI.Card;
import DeckOfCardsAPI.Deck;

import static org.junit.Assert.*;

import DeckOfCardsAPI.Pile;
import org.junit.Test;

import java.util.List;

public class DeckOfCardsTest {
    ApiAccess apiAccess = new ApiAccess();
    Deck deck = apiAccess.createDeck();
    Deck largeDeck = apiAccess.createDeck(6);
    @Test
    public void createStandardDeckTest(){
        assertTrue(deck.exists());
    }
    @Test
    public void createLargeDeckTest(){
        assertEquals(312, largeDeck.getRemainingAmnt());
    }

    @Test
    public void shuffleTest(){
        assertTrue(deck.shuffle());
    }

    @Test
    public void drawCardsTest(){
        deck.drawCards(2);
        assertEquals(50, deck.getRemainingAmnt());
    }

    @Test
    public void createPileTest(){
        deck.shuffle();
        List<Card> cards = deck.drawCards(2);
        List<Object>responses = apiAccess.createPile(deck.getDeckID(), "player1",cards);
        assertTrue((Boolean)responses.get(0));
    }
    @Test
    public void shufflePileTest(){
        List<Card> cards = deck.drawCards(3);
        Pile pile = (Pile) apiAccess.createPile(deck.getDeckID(),"player1", cards).get(1);
        assertTrue(pile.shuffle());
    }
}
