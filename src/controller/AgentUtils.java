package controller;

import java.util.ArrayList;
import java.util.Random;
import model.UnoCard;
import model.UnoCardColour;
import model.Player;

public class AgentUtils {

    public static ArrayList<UnoCard> getPlayableCards(Player player, UnoCard drawCard, UnoCardColour wildColour) {
        ArrayList<UnoCard> playCards = new ArrayList<>();
        for (UnoCard card : player.getPlayerCards()) {
            if (drawCard.getColour() == UnoCardColour.WILD || drawCard.getColour() == UnoCardColour.WILD_FOUR) {
                if (card.getColour().equals(wildColour)) {
                    playCards.add(card);
                }
            } else if (card.getColour().equals(drawCard.getColour())) {
                playCards.add(card);
            } else if (card.getValue().equals(drawCard.getValue())) {
                playCards.add(card);
            } else if (card.getColour() == UnoCardColour.WILD || card.getColour() == UnoCardColour.WILD_FOUR) {
                playCards.add(card);
            }
        }
        return playCards;
    }
    
    public static UnoCardColour askPlayerWildColour(Player player){
        Random random = new Random();
        switch (random.nextInt(4)){
            case 0: return UnoCardColour.BLUE;
            case 1: return UnoCardColour.GREEN;
            case 2: return UnoCardColour.RED;
            case 3: return UnoCardColour.YELLOW;
        }
        
        for(UnoCard card : player.getPlayerCards()) {
            //TODO: to implement something here
        }
        return null;
    }
    
    public static int randomCard(ArrayList<UnoCard> playCards) {
        Random random = new Random();
        int randomCard = random.nextInt(playCards.size());
        return randomCard;
    }
}
