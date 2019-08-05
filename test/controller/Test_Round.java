/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Card;
import model.CardColour;
import model.CardValue;
import model.DiscardPile;
import model.DrawPile;
import model.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author j_a_m
 */
public class Test_Round {

    public Test_Round() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculatePoints method, of class Round.
     */

    @Test
    public void testCalculatePoints() {
        System.out.println("calculatePoints");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        game.getPlayer(0).receiveCard(new Card(CardColour.WILD_FOUR, CardValue.ONE));
        game.getPlayer(0).receiveCard(new Card(CardColour.WILD, CardValue.ONE));
        game.getPlayer(0).receiveCard(new Card(CardColour.BLUE, CardValue.NINE));
        int result = instance.calculatePoints(game.getPlayer(1));
        assertEquals(109, result);
    }

    /**
     * Test of dealCards method, of class Round.
     */
    @Test
    public void testDealCards() {
        System.out.println("dealCards");
        String name = "player1";
        String type = "user";
        String name2 = "player2";
        String type2 = "user";
        Game game = new Game();
        game.addPlayer(name, type);
        game.addPlayer(name2, type2);
        game.defineDealer();
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        for (Player player : instance.getPlayerList()) {
            assertEquals(7, player.getPlayerCards().size());

        }
    }

    /**
     * Test of createDiscardPile method, of class Round.
     */
    @Test
    public void testCreateDiscardPile() {
        System.out.println("createDiscardPile");
        String name = "player1";
        String type = "user";
        String name2 = "player2";
        String type2 = "user";
        Game game = new Game();
        game.addPlayer(name, type);
        game.addPlayer(name2, type2);
        game.defineDealer();
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        assertEquals(1, instance.getDiscardPile().getDiscardPile().size());

    }

    /**
     * Test of createDrawPile method, of class Round.
     */
    @Test
    public void testCreateDrawPile() {
        System.out.println("createDrawPile");
        String name = "player1";
        String type = "user";
        String name2 = "player2";
        String type2 = "user";
        Game game = new Game();
        game.addPlayer(name, type);
        game.addPlayer(name2, type2);
        game.defineDealer();
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        assertEquals(94, instance.getDrawPile().getDrawPile().size());
    }

    /**
     * Test of checkFinalCard method DRAW TWO, of class Round.
     */

    @Test
    public void testCheckFinalCard_DRAW_TWO() {
        System.out.println("checkFinalCard_DRAW_TWO");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.DRAW_TWO));
        instance.checkFinalCard();
        assertEquals(9, game.getPlayer(1).getPlayerCards().size());
    }

   /**
     * Test of checkCard method SKIP, of class Round.
     */
    @Test
    public void testFinalCheckCard_DRAW_FOUR() {
        System.out.println("checkFinalCard DRAW FOUR");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.WILD_FOUR, CardValue.ONE));
        instance.checkFinalCard();
        assertEquals(11, game.getPlayer(1).getPlayerCards().size());
    }
    /**
     * Test of checkCard method SKIP, of class Round.
     */
    @Test
    public void testCheckCard_SKIP() {
        System.out.println("checkCard SKIP");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.SKIP));
        instance.checkCard();
        assertEquals("Player3", instance.getCurrentPlayer().getName());
    }

   /**
     * Test of checkCard method SKIP, of class Round.
     */
    @Test
    public void testCheckCard_REVERSE() {
        System.out.println("checkCard REVERSE");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.REVERSE));
        instance.checkCard();
        assertEquals("Player4", instance.getCurrentPlayer().getName());
    }
   /**
     * Test of checkCard method SKIP, of class Round.
     */
    @Test
    public void testCheckCard_DRAW_TWO() {
        System.out.println("checkCard DRAW TWO");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.DRAW_TWO));
        instance.checkCard();
        assertEquals("Player3", instance.getCurrentPlayer().getName());
        assertEquals(9, game.getPlayer(1).getPlayerCards().size());
    }
   /**
     * Test of checkCard method SKIP, of class Round.
     */
    @Test
    public void testCheckCard_DRAW_FOUR() {
        System.out.println("checkCard DRAW FOUR");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.WILD_FOUR, CardValue.ONE));
        instance.checkCard();
        assertEquals("Player3", instance.getCurrentPlayer().getName());
        assertEquals(11, game.getPlayer(1).getPlayerCards().size());
    }
    
    /**
     * Test of checkFirstDrawCard method, of class Round. when the Dealer is the
     * first player.
     */
    @Test
    public void testCheckFirstDrawCard_SKIP_DealerPlayer0() {
        System.out.println("testCheckFirstDrawCard Skip when Dealer is the first player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.SKIP));
        instance.checkFirstDrawCard();
        assertEquals("Player3", instance.getCurrentPlayer().getName());

    }

    /**
     * Test of checkFirstDrawCard method, of class Round. when the Dealer is the
     * last player.
     */
    @Test
    public void testCheckFirstDrawCard_SKIP_DealerPlayer3() {
        System.out.println("testCheckFirstDrawCard Skip when Dealer is the last player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(game.getPlayerList().size() - 1));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.SKIP));
        instance.checkFirstDrawCard();
        assertEquals("Player2", instance.getCurrentPlayer().getName());

    }

    /**
     * Test of checkFirstDrawCard method, of class Round. when the Dealer is the
     * last player.
     */
    @Test
    public void testCheckFirstDrawCard_SKIP_DealerPlayer2() {
        System.out.println("testCheckFirstDrawCard Skip when Dealer is before last player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(2));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.SKIP));
        instance.checkFirstDrawCard();
        assertEquals("Player1", instance.getCurrentPlayer().getName());

    }

    /**
     * Test of checkFirstDrawCard method, of class Round. Reverse when the
     * Dealer is the first player.
     */
    @Test
    public void testCheckFirstDrawCard_REVERSE_DealerPlayer0() {
        System.out.println("testCheckFirstDrawCard Reverse when Dealer is the first player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.REVERSE));
        instance.checkFirstDrawCard();
        assertEquals("Player1", instance.getCurrentPlayer().getName());

    }

    /**
     * Test of checkFirstDrawCard method, of class Round. Reverse when the
     * Dealer is the first player.
     */
    @Test
    public void testCheckFirstDrawCard_REVERSE_DealerPlayer3() {
        System.out.println("testCheckFirstDrawCard Reverse when Dealer is the last player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(game.getPlayerList().size() - 1));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.REVERSE));
        instance.checkFirstDrawCard();
        assertEquals("Player4", instance.getCurrentPlayer().getName());

    }

    /**
     * Test of checkFirstDrawCard method, of class Round. DRAW TWO when the
     * Dealer is the first player.
     */
    @Test
    public void testCheckFirstDrawCard_DRAW2_DealerPlayer0() {
        System.out.println("testCheckFirstDrawCard Draw2 when Dealer is the first player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.BLUE, CardValue.DRAW_TWO));
        instance.checkFirstDrawCard();
        assertEquals(9, game.getPlayer(1).getPlayerCards().size());
        assertEquals("Player3", instance.getCurrentPlayer().getName());
    }

    /**
     * Test of checkFirstDrawCard method, of class Round. DRAW TWO when the
     * Dealer is the first player.
     */
    @Test
    public void testCheckFirstDrawCard_DRAW4_DealerPlayer0() {
        System.out.println("testCheckFirstDrawCard Draw4 when Dealer is the first player");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.createDrawPile();
        instance.createDiscardPile();
        instance.getPlayerList().nextNode();
        instance.getDiscardPile().addCard(new Card(CardColour.WILD_FOUR, CardValue.ONE));
        instance.checkFirstDrawCard();
        assertTrue(instance.getDiscardPile().peekCard().getColour() != CardColour.WILD_FOUR);
    }

    /**
     * Test of clearPlayerCards method, of class Round.
     */
    @Test
    public void testClearPlayerCards() {
        System.out.println("clearPlayerCards");
        Game game = new Game();
        game.addPlayer("Player1", "agent");
        game.addPlayer("Player2", "agent");
        game.addPlayer("Player3", "agent");
        game.addPlayer("Player4", "user");
        game.setDealer(game.getPlayer(0));
        Round instance = new Round(game.getDealer(), game.getPlayerList());
        instance.dealCards();
        instance.clearPlayerCards();
        for (Player player : instance.getPlayerList()) {
            assertEquals(0, player.getPlayerCards().size());

        }

    }
}
