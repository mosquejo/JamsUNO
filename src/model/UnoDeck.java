package model;

import java.util.ArrayList;
import java.util.Collections;

public class UnoDeck {
    
    private final ArrayList<UnoCard> deck = new ArrayList<>();

    public UnoDeck() {
        for(int i = 0; i < 2; i++) {

            for (UnoCardColour colour : UnoCardColour.values()) {
                for (UnoCardValue value : UnoCardValue.values()) {
                    if (colour == UnoCardColour.WILD || colour == UnoCardColour.WILD_FOUR) { }
                    else {
                        if(i==1 && value == UnoCardValue.ZERO) {}
                        else{
                            deck.add(new UnoCard(colour, value));
                        }
                    }
                }
            }
        }


        for(int i = 0; i < 4; i++) {
            deck.add(new UnoCard(UnoCardColour.WILD,UnoCardValue.ONE));
            deck.add(new UnoCard(UnoCardColour.WILD_FOUR,UnoCardValue.ONE));
        }
    }

    public UnoCard getCard() {
        return deck.get(0);
    }

    public UnoCard getCard(int index) {
        return deck.get(index);
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public UnoCard dealCard() {
        
        return deck.remove(0);
    }

    public void clear() {
        deck.clear();
    }

    public ArrayList getDeck() {
        return deck;
    }
    
}
