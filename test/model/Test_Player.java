/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
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
public class Test_Player {
    
    public Test_Player() {
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
     * Test of calculatePoints method, of class Player.
     */

    @Test
    public void testCalculatePoints() {
        System.out.println("Calculate Points");
        Player player = new Player("player1", "user");
        player.receiveCard(new Card(CardColour.BLUE, CardValue.ONE));
        player.receiveCard(new Card(CardColour.BLUE, CardValue.TWO));
        assertEquals(3, player.calculatePoints());
    }

    /**
     * Test of receiveCard method, of class Player.
     */

    @Test
    public void testReceiveCard() {
        System.out.println("receiveCard");
        Player player = new Player("player1", "user");
        player.receiveCard(new Card(CardColour.BLUE, CardValue.ONE));
        player.receiveCard(new Card(CardColour.BLUE, CardValue.TWO));
        assertEquals(2, player.getPlayerCards().size());

    }

    /**
     * Test of play method, of class Player.
     */

    @Test
    public void testPlay_int_DiscardPile() {
        System.out.println("playCard int to DiscardPile");
        Player player = new Player("player1", "user");
        DiscardPile discardPile = new DiscardPile();
        Card card1 = new Card(CardColour.BLUE, CardValue.ONE);
        Card card2 = new Card(CardColour.BLUE, CardValue.TWO);
        player.receiveCard(card1);
        player.receiveCard(card2);
        player.play(2, discardPile);
        assertEquals(1, player.getPlayerCards().size());
        assertEquals(1, discardPile.getDiscardPile().size());
    }

    /**
     * Test of play method, of class Player.
     */

    @Test
    public void testPlay_Card_DiscardPile() {
        System.out.println("playCard to DiscardPile");
        Player player = new Player("player1", "user");
        DiscardPile discardPile = new DiscardPile();
        Card card1 = new Card(CardColour.BLUE, CardValue.ONE);
        Card card2 = new Card(CardColour.BLUE, CardValue.TWO);
        player.receiveCard(card1);
        player.receiveCard(card2);
        player.play(card1, discardPile);
        assertEquals(1, player.getPlayerCards().size());
        assertEquals(1, discardPile.getDiscardPile().size());
    }

    /**
     * Test of wonGame method, of class Player.
     */
    @Test
    public void testWonGame_FALSE() {
        System.out.println("wonGame_TEST_FALSE");
        Player player = new Player("player1", "user");
        player.receiveCard(new Card(CardColour.BLUE, CardValue.ONE));
        player.receiveCard(new Card(CardColour.BLUE, CardValue.TWO));
        boolean result = player.wonGame();
        assertEquals(false, result);
    }
/**
     * Test of wonGame method, of class Player.
     */
    @Test
    public void testWonGame_TRUE() {
        System.out.println("wonGame_TEST_TRUE");
        Player player = new Player("player1", "user");
        boolean result = player.wonGame();
        assertEquals(true, result);
    }    
}
