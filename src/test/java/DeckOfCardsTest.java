import DeckOfCardsAPI.ApiAccess;
import DeckOfCardsAPI.Card;
import DeckOfCardsAPI.Deck;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCardsTest {
    ApiAccess apiAccess = new ApiAccess();
    Deck deck = apiAccess.createDeck();
    @Test
    public void createDeckTest(){
        assertTrue(deck.exists());
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
}
