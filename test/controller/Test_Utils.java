/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.UnoCard;
import model.UnoCardColour;
import model.UnoCardValue;
import model.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.rules.ExpectedException;

/**
 *
 * @author j_a_m
 */
public class Test_Utils {
    
    public Test_Utils() {
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
     * Test of cardSelectionIsValid method, of class utils.
     */
    @Test(expected = Exception.class)
    public void testCardSelectionIsValid_FALSE() throws Exception {
        System.out.println("cardSelectionIsValid not valid");
        UnoCard cardSelection = new UnoCard(UnoCardColour.RED, UnoCardValue.TWO);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.ONE);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        utils.cardSelectionIsValid(cardSelection, drawCard, wildColour);
       
    }
    
     /**
     * Test of cardSelectionIsValid method, of class utils.
     */
    @Test
    public void testCardSelectionIsValid_TRUE() throws Exception {
        System.out.println("cardSelectionIsValid not valid");
        UnoCard cardSelection = new UnoCard(UnoCardColour.BLUE, UnoCardValue.TWO);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.ONE);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        utils.cardSelectionIsValid(cardSelection, drawCard, wildColour);
    }

    /**
     * Test of cardCanPlay method, of class utils.
     */
    @Test
    public void testCardCanPlay_TRUE() {
        System.out.println("cardCanPlay TRUE COLOUR");
        UnoCard cardSelection = new UnoCard(UnoCardColour.BLUE, UnoCardValue.TWO);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.ONE);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        boolean result = utils.cardCanPlay(cardSelection, drawCard, wildColour);
        assertEquals(true, result);
    }
    
    /**
     * Test of cardCanPlay method, of class utils.
     */
    @Test
    public void testCardCanPlay_FALSE() {
        System.out.println("cardCanPlay FALSE COLOUR");
        UnoCard cardSelection = new UnoCard(UnoCardColour.RED, UnoCardValue.TWO);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.ONE);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        boolean result = utils.cardCanPlay(cardSelection, drawCard, wildColour);
        assertEquals(false, result);
    }
    
    /**
     * Test of cardCanPlay method, of class utils.
     */
    @Test
    public void testCardCanPlay_TRUE_VALUE() {
        System.out.println("cardCanPlay TRUE VALUE");
        UnoCard cardSelection = new UnoCard(UnoCardColour.RED, UnoCardValue.TWO);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.TWO);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        boolean result = utils.cardCanPlay(cardSelection, drawCard, wildColour);
        assertEquals(true, result);
    }
    
    /**
     * Test of cardCanPlay method, of class utils.
     */
    @Test
    public void testCardCanPlay_FALSE_VALUE() {
        System.out.println("cardCanPlay FALSE VALUE");
        UnoCard cardSelection = new UnoCard(UnoCardColour.RED, UnoCardValue.TWO);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.THREE);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        boolean result = utils.cardCanPlay(cardSelection, drawCard, wildColour);
        assertEquals(false, result);
    }
    
    /**
     * Test of cardCanPlay method, of class utils.
     */
    @Test
    public void testCardCanPlay_WILD() {
        System.out.println("cardCanPlay WILD");
        UnoCard cardSelection = new UnoCard(UnoCardColour.WILD, UnoCardValue.ONE);
        UnoCard drawCard = new UnoCard(UnoCardColour.BLUE, UnoCardValue.THREE);
        UnoCardColour wildColour = UnoCardColour.BLUE;
        boolean result = utils.cardCanPlay(cardSelection, drawCard, wildColour);
        assertEquals(true, result);
    }
    
}
