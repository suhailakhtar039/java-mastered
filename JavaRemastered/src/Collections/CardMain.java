package Collections;

import java.util.List;

public class CardMain {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

    }
}

