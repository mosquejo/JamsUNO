
package model;

import java.util.Stack;

public class DrawPile {
    
    private Stack<UnoCard> drawPile;

    public DrawPile() {
        drawPile = new Stack<>();
    }
    
    public DrawPile(Deck deck){
        drawPile = new Stack<>();
        while (!deck.getDeck().isEmpty()) {
            UnoCard tempCard = (UnoCard)deck.getDeck().remove(deck.getDeck().size()-1);
            drawPile.push(tempCard);
        }
    }

    public void addCard(UnoCard card) {
        drawPile.push(card);
    }

    public UnoCard peek() {
        return drawPile.peek();
    }

    public Stack<UnoCard> getDrawPile() {
        return drawPile;
    }
    
    public UnoCard drawCard(DiscardPile discardPile){
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
    
}
