package com.example.spidersolitaire3;

import java.util.Stack;
import sofia.util.Random;

public class SpiderSolitaireTests extends student.TestCase
{
    /**
     * SpiderSolitare object
     */
    SpiderSolitaire screenObj;

    /**
     * setup method, runs before each testcase
     */
    public void setUp() {
        screenObj = new SpiderSolitaire();
        screenObj.initialize();
    }
    /**
     * tests the buildDeck method
     */
    public void testBuildDeck() {
        //2 decks, in numerical order so i wouldn't forget any
     //   assertEquals(screenObj.getDeck().size(), 0);
        Random.setNextInts(0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4,
            4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9,
            9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13,
            0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5,
            5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10,
            10, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 13, 13);
        //assert object added to screen?
        screenObj.buildDeck();
       // assertEquals(screenObj.getDeck().size(), 104);
    }

    /**
     * tests the moveCard method
     */
    public void testMoveCard() {
        //this would invole me knowing what moveCard does...
    }
    /**
     * tests the buildBorad method
     */
    public void testBuildBoard() {
        screenObj.buildBoard();
     //   assertEquals(screenObj.getCols()[1].size(), 5);
     //   assertEquals(screenObj.getCols()[4].size(), 4);
    }

}

