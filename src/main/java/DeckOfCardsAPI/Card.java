package DeckOfCardsAPI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Card {
    private final String img;
    private final String value;
    private final String suit;
    private final String code;

    final BufferedImage cardBack;


    public Card(String img, String value, String suit, String code) {
        this.img = img;
        this.value = value;
        this.suit = suit;
        this.code = code;
        {
            try {
                cardBack = ImageIO.read(Objects.requireNonNull(getClass().getResource("/resources/images/cardback.png")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public String getImg() {
        return img;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public String getCode() {
        return code;
    }

    public String toString(){
        return "This card is a " + value.toLowerCase() + " of " + suit.toLowerCase();
    }
}
