package model;

import interfaces.Deck;
import java.util.Collections;
import java.util.Stack;

public class UnoDiscardPile implements Deck{
    
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

    @Override
    public UnoCard drawCard() {
        return discardPile.pop();
    }

    public Stack<UnoCard> getDiscardPile() {
        return discardPile;
    }
    
    public void addCard(UnoCard card){
        discardPile.push(card);
    }
    
    @Override
    public UnoCard peekCard(){
        return discardPile.peek();
    }
    
    @Override
    public void shuffle(){
        Collections.shuffle(discardPile);
    }
    
    @Override
    public void clear() {
        discardPile.clear();
    }
    
}
