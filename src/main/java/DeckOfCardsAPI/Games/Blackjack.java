package DeckOfCardsAPI.Games;

import DeckOfCardsAPI.ApiAccess;
import DeckOfCardsAPI.Deck;
import DeckOfCardsAPI.Pile;

public class Blackjack {
    private Deck deck;
    private Pile dealerPile;
    private Pile playerPile;
    ApiAccess apiAccess = new ApiAccess();

    public Blackjack(){
        deck = apiAccess.createDeck();
        deck.shuffle();
    }
    public Blackjack(int num){
        deck = apiAccess.createDeck(6);
        deck.shuffle();
    }

    public void openingDeal(){

    }


}
