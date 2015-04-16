package com.example.spidersolitaire3;


public class CardTests extends student.TestCase
{
    // ----------------------------------------------------------
    /**
     * Card object for testing
     */
    Card testCard;

    /**
     * setup method, runs before each test case
     */
    public void setUp() {
        testCard = new Card(0 ,0 ,0 ,0, 2, 's');
    }
    /**
     * tests the getNumber method
     */
    public void testGetNumber() {
        assertEquals(testCard.getNumber(), 2);
    }
    /**
     * tests the setNumber method
     */
    public void testSetNumber() {
        testCard.setNumber(5);
        assertEquals(testCard.getNumber(), 5);
    }
    /**
     * tests the getSuit method
     */
    public void testGetSuit() {
        assertEquals(testCard.getSuit(), 's');
    }
    /**
     * tests the setSuit method
     */
    public void testSetSuit() {
        testCard.setSuit('d');
        assertEquals(testCard.getSuit(), 'd');
    }
    /**
     * tests the isRevealed method
     */
    public void testrevealed() {
        assertEquals(testCard.getIsRevealed(), false);
        testCard.reveal();
        assertEquals(testCard.getIsRevealed(), true);
    }
    /**
     * tests the reveal method
     */
    public void testReveal() {

    }

}

