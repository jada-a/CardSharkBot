import DeckOfCardsAPI.ApiAccess;
import DeckOfCardsAPI.Deck;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckOfCardsTest {
    ApiAccess apiAccess = new ApiAccess();
    Deck deck = apiAccess.createDeck();
    @Test
    public void createDeckTest(){
        assertTrue(deck.exists());
    }
    public void shuffleTest(){
        assertTrue(deck.shuffle());
    }
    public void createCardsTest(){
        deck.drawCards(2);
        assertEquals(50, deck.getRemainingAmnt());
    }
}
