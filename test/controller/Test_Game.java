package controller;

import model.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class Test_Game {
    
    public Test_Game() {
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
     * Test of addPlayer method, of class Game.
     */
    @Test
    public void test_AddPlayer() {
        System.out.println("addPlayer");
        String name = "player1";
        String type = "user";
        String name2 = "player2";
        String type2 = "user";
        Game instance = new Game();
        assertEquals(0, instance.getPlayerList().size());
        instance.addPlayer(name, type);
        assertEquals(1, instance.getPlayerList().size());
        instance.addPlayer(name2, type2);
        assertEquals(2, instance.getPlayerList().size());
    }

    /**
     * Test of isThereAWinner method, of class Game.
     */

    @Test
    public void testIsThereAWinner_TRUE() {
        System.out.println("isThereAWinner TRUE");
        Game instance = new Game();
        instance.addPlayer("player1", "user");
        instance.addPlayer("player2", "user");
        instance.addPlayer("player3", "user");
        instance.addPlayer("player4", "user");
        
        instance.getPlayer(0).setPoints(600);
        assertTrue(instance.isThereAWinner());

    }
    
        /**
     * Test of isThereAWinner method, of class Game.
     */

    @Test
    public void testIsThereAWinner_FALSE() {
        System.out.println("isThereAWinner FALSE");
        Game instance = new Game();
        instance.addPlayer("player1", "user");
        instance.addPlayer("player2", "user");
        instance.addPlayer("player3", "user");
        instance.addPlayer("player4", "user");
        
        instance.getPlayer(0).setPoints(400);
        assertFalse(instance.isThereAWinner());

    }
    
     /**
     * Test of isThereAWinner method, of class Game.
     */

    @Test
    public void testgetWinner_TRUE() {
        System.out.println("get Winner TRUE");
        Game instance = new Game();
        instance.addPlayer("player1", "user");
        instance.addPlayer("player2", "user");
        instance.addPlayer("player3", "user");
        instance.addPlayer("player4", "user");
        
        instance.getPlayer(2).setPoints(600);
        assertEquals("player3", instance.getWinner());

    }
    
         /**
     * Test of isThereAWinner method, of class Game.
     */

    @Test
    public void testgetWinner_FALSE() {
        System.out.println("get Winner FALSE");
        Game instance = new Game();
        instance.addPlayer("player1", "user");
        instance.addPlayer("player2", "user");
        instance.addPlayer("player3", "user");
        instance.addPlayer("player4", "user");
        
        instance.getPlayer(2).setPoints(400);
        assertEquals("", instance.getWinner());

    }

    /**
     * Test of defineDealer method, of class Game.
     */
    
    @Test
    public void testDefineDealer() {
        System.out.println("defineDealer");
        Game instance = new Game();
        instance.addPlayer("player1", "user");
        instance.addPlayer("player2", "user");
        instance.addPlayer("player3", "user");
        instance.addPlayer("player4", "user");
        
        instance.defineDealer();
        assertNotNull(instance.getDealer());
    }

    /**
     * Test of setupRound method, of class Game.
     */

    @Test
    public void testSetupRound() {
        System.out.println("setupRound");
        Game instance = new Game();
        instance.addPlayer("player1", "user");
        instance.addPlayer("player2", "user");
        instance.addPlayer("player3", "user");
        instance.addPlayer("player4", "user");
        instance.defineDealer();
        instance.setupRound();
        for (Player player : instance.getPlayerList()) {
            assertEquals(7, player.getPlayerCards().size());
        }
        
        

    }
    
}
