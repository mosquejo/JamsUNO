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
public class Test_Deck {
    
    public Test_Deck() {
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
     * Test of getCard method, of class Deck.
     */
    @Test
    public void testNewDeck() {
        System.out.println("createDeck");
        UnoDeck instance = new UnoDeck();
        assertEquals(instance.getDeck().size(), 108);
    }
    

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        UnoDeck instance = new UnoDeck();
        instance.shuffle();
        assertEquals(instance.getDeck().size(), 108);
    }

    /**
     * Test of dealCard method, of class Deck.
     */
    @Test
    public void testDealCard() {
        System.out.println("dealCard");
        UnoDeck instance = new UnoDeck();
        UnoCard result = instance.drawCard();
        assertEquals(instance.getDeck().size(), 107);
    }

    /**
     * Test of clear method, of class Deck.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        UnoDeck instance = new UnoDeck();
        instance.clear();
        assertEquals(instance.getDeck().size(), 0);
    }
    
}
