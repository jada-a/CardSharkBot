package DeckOfCardsAPI;

import java.util.List;

public class Pile extends Deck{
    String pileName;
    List<Card> cards;

    public Pile(String deckID, long remainingAmnt, String pileName) {
        super(deckID, remainingAmnt);
        this.pileName = pileName;
    }

    public Pile(String deckID, long remainingAmnt, String pileName, List<Card> cards) {
        super(deckID, remainingAmnt);
        this.pileName = pileName;
        this.cards = cards;
    }



}
