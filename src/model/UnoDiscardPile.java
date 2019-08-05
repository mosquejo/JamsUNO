package model;

import java.util.Collections;
import java.util.Stack;

public class UnoDiscardPile {
    
    private Stack<UnoCard> discardPile;

    public UnoDiscardPile(UnoDeck deck) {
        discardPile = new Stack<>();
        while (!deck.getDeck().isEmpty()) {
            UnoCard tempCard = (UnoCard)deck.getDeck().remove(deck.getDeck().size()-1);
            discardPile.add(tempCard);
        }
    }
    
    public UnoDiscardPile() {
        discardPile = new Stack<>();
        
    }

    public UnoCard drawCard() {
        return discardPile.pop();
    }

    public Stack<UnoCard> getDiscardPile() {
        return discardPile;
    }
    
    public void addCard(UnoCard card){
        discardPile.push(card);
    }
    
    public UnoCard peekCard(){
        return discardPile.peek();
    }
    
    public void shuffle(){
        Collections.shuffle(discardPile);
    }
    
}
