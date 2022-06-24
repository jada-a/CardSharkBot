import DeckOfCardsAPI.ApiAccess;
import DeckOfCardsAPI.Deck;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckOfCardsTest {
    ApiAccess apiAccess = new ApiAccess();
    @Test
    public void createDeckTest(){
        Deck deck = apiAccess.createDeck();
        assertTrue(deck.exists());
    }
}
