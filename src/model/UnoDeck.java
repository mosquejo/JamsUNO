package model;

import interfaces.Deck;
import java.util.ArrayList;
import java.util.Collections;

public class UnoDeck implements Deck{
    
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
    
    
    @Override
    public UnoCard peekCard() {
        return deck.get(0);
    }

    public UnoCard peekCard(int index) {
        return deck.get(index);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    @Override
    public UnoCard drawCard() {
        
        return deck.remove(0);
    }

    @Override
    public void clear() {
        deck.clear();
    }

    public ArrayList getDeck() {
        return deck;
    }
    
}
