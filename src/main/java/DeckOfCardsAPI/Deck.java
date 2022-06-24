package DeckOfCardsAPI;

public class Deck {
    private String deckID;
    private boolean shuffled;
    private int remainingAmnt;

    public Deck(String deckID, int remainingAmnt) {
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

    public int getRemainingAmnt() {
        return remainingAmnt;
    }

    public void setRemainingAmnt(int remainingAmnt) {
        this.remainingAmnt = remainingAmnt;
    }




}
