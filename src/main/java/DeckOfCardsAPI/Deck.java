package DeckOfCardsAPI;

import java.util.List;

public class Deck {
    private String deckID;
    private boolean shuffled;
    private long remainingAmnt;
    ApiAccess apiAccess = new ApiAccess();

    public Deck(String deckID, long remainingAmnt) {
        this.deckID = deckID;
        this.remainingAmnt = remainingAmnt;
    }
    public String getDeckID() {
        return deckID;
    }

    public void setDeckID(String deckID) {
        this.deckID = deckID;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    public long getRemainingAmnt() {
        return remainingAmnt;
    }

    public void setRemainingAmnt(long remainingAmnt) {
        this.remainingAmnt = remainingAmnt;
    }


    public boolean exists(){
        return deckID != null;
    }

    public boolean shuffle(){
        shuffled = apiAccess.shuffle(getDeckID());
        return shuffled;
    }
    public List<Card> drawCards(int num){
        setRemainingAmnt(remainingAmnt - num);
        List<Card> cards = apiAccess.drawCards(num, getDeckID());
        for(Card card: cards){
            System.out.println(card);
        }
        return cards;
    }



}
