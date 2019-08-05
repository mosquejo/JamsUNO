package view;

import controller.AgentUtils;
import controller.Game;
import controller.Round;
import controller.utils;
import java.util.ArrayList;
import java.util.Scanner;
import model.UnoCard;
import model.UnoCardColour;
import model.UnoDiscardPile;
import model.UnoDrawPile;
import model.Player;

public class Tester {

    public static void main(String[] args) {

        //Create a new Game
        Game game = new Game();

        //Add players
        game.addPlayer("Juanita", "agent");
        game.addPlayer("Martin", "agent");
        game.addPlayer("Paola", "agent");
        game.addPlayer("Jorge", "agent");

        game.defineDealer();

        while (!game.isThereAWinner()) {

            System.out.println(game.toString());
            System.out.println("The dealer is: " + game.getDealer().getName());

            game.setupRound();
            while (game.getRound().isContinuePlaying()) {
                boolean cardPlayed = playerPlays(game.getRound());
                if (cardPlayed) {
                    if (game.getRound().getCurrentPlayer().wonGame()) {
                        game.getRound().checkFinalCard();
                        System.out.println(game.getRound().getCurrentPlayer().getName() + " won the round.");
                        game.getRound().getCurrentPlayer().setPoints(game.getRound().calculatePoints(game.getRound().getCurrentPlayer()));
                        game.getRound().setContinuePlaying(false);
                        game.getRound().clearPlayerCards();
                        game.setDealer(game.getRound().getCurrentPlayer()); //set the dealer for the next round
                    } else {
                        game.getRound().checkCard();
                    }
                } else {
                    game.getRound().getPlayerList().nextNode();
                }
            }
        }

        System.out.println(game.getWinner() + " won the game.");
        System.out.println(game.toString());
    }

    public static boolean playerPlays(Round round) {

        Player player = round.getCurrentPlayer();
        UnoCard drawCard = round.showDrawCard();
        UnoCardColour wildColour = round.getWildColour();
        UnoDrawPile drawPile = round.getDrawPile();
        UnoDiscardPile discardPile = round.getDiscardPile();

        boolean result = false;

        if (player.getType().equals("agent")) {
//            System.out.println("Im an agent, im learing to play");

            System.out.println("#########################");
            System.out.println("Player " + player.getName() + " plays.");
            System.out.println("Your cards:");
            System.out.println(player.showCards());
            System.out.println("The Draw Card is: " + drawCard.toString());
            if (drawCard.getColour() == UnoCardColour.WILD || drawCard.getColour() == UnoCardColour.WILD_FOUR) {
                System.out.println("The Colour is " + wildColour.toString());
            }

            ArrayList<UnoCard> playCards = AgentUtils.getPlayableCards(player, drawCard, wildColour);
            switch (playCards.size()) {
                case 0:
                    System.out.println("I dont have matching cards. I need to draw a card");
                    UnoCard card = drawPile.drawCard(discardPile);
                    player.receiveCard(card);
                    System.out.println("The card is " + card.toString());
                    if (utils.cardCanPlay(card, drawCard, wildColour)) {
                        System.out.println("Looks like I can play the card i just draw");
                        if (card.getColour() == UnoCardColour.WILD || card.getColour() == UnoCardColour.WILD_FOUR) {
                            round.setWildColour(AgentUtils.askPlayerWildColour(player));
                        }
                        player.play(card, discardPile);
                        System.out.println("I played: "+ card.toString());
                        result = true;

                    } else {
                        result = false;
                        System.out.println(player.getName() + " pass.");
                    }
                    break;
                case 1: 
                    System.out.println("OK I think I have a Card");
                    UnoCard card1 = playCards.get(0);
                    if (card1.getColour() == UnoCardColour.WILD || card1.getColour() == UnoCardColour.WILD_FOUR) {
                            round.setWildColour(AgentUtils.askPlayerWildColour(player));
                        }
                        player.play(card1, discardPile);
                        System.out.println("I played: "+ card1.toString());
                        result = true;
                    break; 
                default:
                    System.out.println("OK I have multiple options");
                    UnoCard card2 = playCards.get(AgentUtils.randomCard(playCards));
                    if (card2.getColour() == UnoCardColour.WILD || card2.getColour() == UnoCardColour.WILD_FOUR) {
                            round.setWildColour(AgentUtils.askPlayerWildColour(player));
                        }
                        player.play(card2, discardPile);
                        System.out.println("I played: "+ card2.toString());
                        result = true;
            }

        } else {
            Scanner scan = new Scanner(System.in);

            System.out.println("#########################");
            System.out.println("Player " + player.getName() + " plays.");
            System.out.println("Your cards:");
            System.out.println(player.showCards());
            System.out.println("The Draw Card is: " + drawCard.toString());
            if (drawCard.getColour() == UnoCardColour.WILD || drawCard.getColour() == UnoCardColour.WILD_FOUR) {
                System.out.println("The Colour is " + wildColour.toString());
            }

            boolean continueInput = true;
            int userInput = 0;
            do {
                try {
                    System.out.println("Please enter your option:");
                    System.out.println("1. Play Card from Players Cards");
                    System.out.println("2. Take Card from Draw Pile");
                    System.out.print("your option: ");
                    userInput = scan.nextInt();
                    if (userInput < 1 || userInput > 2) {
                        throw new Exception("Option not valid");
                    }
                    continueInput = false;
                } catch (Exception E) {
                    System.out.println("Option not valid");
                    scan.nextLine();

                }
            } while (continueInput);

            switch (userInput) {
                case 1:
                    boolean continueInput2 = true;
                    do {
                        try {
                            // todo: pending implemenentation to go back to menu
                            System.out.println("The Draw Card is: " + drawCard.toString());
                            if (drawCard.getColour() == UnoCardColour.WILD || drawCard.getColour() == UnoCardColour.WILD_FOUR) {
                                System.out.println("The Colour is " + wildColour.toString());
                            }
                            System.out.println("Your cards are:");
                            int counter = 1;
                            for (UnoCard card : player.getPlayerCards()) {
                                System.out.println(counter + ". " + card.toString());
                                counter++;
                            }
                            System.out.print("Which card do you want to play: ");

                            int cardSelection = scan.nextInt();
                            if (cardSelection > counter || cardSelection == 0) {
                                throw new Exception("Option not valid");
                            }

                            utils.cardSelectionIsValid(player.getPlayerCards().get(cardSelection - 1), drawCard, wildColour);

                            if (player.getPlayerCards().get(cardSelection - 1).getColour() == UnoCardColour.WILD || player.getPlayerCards().get(cardSelection - 1).getColour() == UnoCardColour.WILD_FOUR) {
                                round.setWildColour(utils.askPlayerWildColour(player));

                            }

                            player.play(cardSelection, discardPile);
                            continueInput2 = false;
                            result = true;
                        } catch (Exception E) {
                            System.out.println("Option Selected not valid");
                            scan.nextLine();
                        }

                    } while (continueInput2);
                    break;
                case 2:
                    UnoCard card = drawPile.drawCard(discardPile);
                    player.receiveCard(card);
                    System.out.println("The card is " + card.toString());
                    int userInput2 = 0;
                    if (utils.cardCanPlay(card, drawCard, wildColour)) {
                        boolean continueInput3 = false;
                        do {
                            try {
                                System.out.println("Would you like to play the card?");
                                System.out.println("1. Play the card");
                                System.out.println("2. Pass");
                                System.out.print("option?");
                                userInput2 = scan.nextInt();
                                if (userInput2 < 1 || userInput2 > 2) {
                                    throw new Exception("Invalid option");
                                }
                                continueInput3 = false;
                            } catch (Exception E) {
                                System.out.println("Option not valid");
                                scan.nextLine();
                            }
                        } while (continueInput3);

                        switch (userInput2) {
                            case 1:
                                if (card.getColour() == UnoCardColour.WILD || card.getColour() == UnoCardColour.WILD_FOUR) {
                                    round.setWildColour(utils.askPlayerWildColour(player));
                                }
                                player.play(card, discardPile);
                                result = true;
                                break;
                            case 2:
                                result = false;
                        }
                    } else {
                        result = false;
                        System.out.println(player.getName() + " pass.");
                    }
            }
        }
        return result;
    }

}
