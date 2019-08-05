
package model;

import interfaces.Deck;
import java.util.Collections;
import java.util.Stack;

public class UnoDrawPile implements Deck{
    
    private Stack<UnoCard> drawPile;

    public UnoDrawPile() {
        drawPile = new Stack<>();
    }
    
    public UnoDrawPile(UnoDeck deck){
        drawPile = new Stack<>();
        while (!deck.getDeck().isEmpty()) {
            UnoCard tempCard = (UnoCard)deck.getDeck().remove(deck.getDeck().size()-1);
            drawPile.push(tempCard);
        }
    }

    public void addCard(UnoCard card) {
        drawPile.push(card);
    }

    @Override
    public UnoCard peekCard() {
        return drawPile.peek();
    }

    public Stack<UnoCard> getDrawPile() {
        return drawPile;
    }
    
    public UnoCard drawCard(UnoDiscardPile discardPile){
        if(drawPile.isEmpty()){
            UnoCard card = discardPile.drawCard();
            discardPile.shuffle();
            while(!discardPile.getDiscardPile().isEmpty()) {
                UnoCard tempCard = discardPile.drawCard();
                drawPile.push(tempCard);
            }
            discardPile.addCard(card);
        }
        return drawPile.pop();
           
    }
    
    @Override
    public UnoCard drawCard() {
        return drawPile.pop();
    }
    
    @Override
    public void shuffle() {
        Collections.shuffle(drawPile);
    }
    
    @Override
    public void clear() {
        drawPile.clear();
    }
    
}
