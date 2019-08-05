
package model;

import java.util.ArrayList;

public class Player {
    
    private String name;
    private int points;
    private ArrayList<UnoCard> playerCards;
    private String type;

    public Player(String name, String type) {
        this.name = name;
        this.points = 0;
        this.playerCards = new ArrayList<>();
        this.type = type;
    }
    
    public String getType() {
        return this.type;
    }

    public int calculatePoints(){
        int cardPoints = 0;
        for(UnoCard card:playerCards){
            cardPoints = cardPoints + card.getCardPoints();
        }
        return cardPoints;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points){
        this.points = this.points + points;
    }

    @Override
    public String toString() {
        return name + " " + points + "\n";
    }

    public void receiveCard(UnoCard card) {
        playerCards.add(card);
    }

    
    public String showCards() {
        String result = "";
        for(UnoCard card : playerCards){
            result += card.toString() +" - ";
        }
        return result;
    }

    public ArrayList<UnoCard> getPlayerCards(){
        return playerCards;
    }
    
    //TODO: cohesion -- verificar esta funcion. 
    public void play(int cardSelection, DiscardPile discardPile){
         discardPile.addCard(playerCards.remove(cardSelection-1));
    }
    
    //TODO: cohesion -- verificar esta funcion. 
    public void play(UnoCard card, DiscardPile discardPile){
        discardPile.addCard(playerCards.remove(playerCards.indexOf(card)));
    }

    public boolean wonGame() {
        return this.playerCards.isEmpty();
    }   
}
