package DeckOfCardsAPI;

public class Deck {
    private String deckID;
    private boolean shuffled;
    private long remainingAmnt;
    ApiAccess apiAccess;

    public Deck(String deckID, long remainingAmnt) {
        this.deckID = deckID;
        this.remainingAmnt = remainingAmnt;
        apiAccess = new ApiAccess();
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
        apiAccess.shuffle(this.deckID);
        shuffled = true;
        return shuffled;
    }



}
