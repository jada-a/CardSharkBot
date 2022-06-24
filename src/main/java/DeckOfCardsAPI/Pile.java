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

    public String getPileName() {
        return pileName;
    }

    public void setPileName(String pileName) {
        this.pileName = pileName;
    }

    @Override
    public boolean shuffle(){
        return apiAccess.shuffle(getDeckID(), getPileName());
    }
    public void addCards(List<Card> newCards){
        cards.addAll(newCards);
    }
    public void addCards(int num) {
        List<Card> newCards = drawCards(num);
        addCards(newCards);
    }



}
