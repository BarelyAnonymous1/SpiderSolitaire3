package com.example.spidersolitaire3;

import sofia.graphics.Color;
import sofia.app.ShapeScreen;


import sofia.util.Random;
import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import sofia.app.ShapeScreen;
/**
 * // -------------------------------------------------------------------------
/**
 *  the screen class for spider solitare
 *
 *  @author Anna Bosco, Preston Lattimer, Jonathan DeFreeuw
 *  @version Mar 29, 2015
 */
public class SpiderSolitaire extends ShapeScreen
{
    /**
     * the deck
     */
    private Stack<Card> deck;
    /**
     * Array of Linked List Objects
     */
    private LinkedList<Card> [] cols;
    /**
     * boolean for clicking (true when cards are selected)
     */
    private boolean clicked;

    /**
     * builds the gui
     */
    public void initialize()
    {
        clicked = false;
        deck = new Stack<Card>();
        cols = new LinkedList[10];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new LinkedList<Card>();
        }
        this.buildDeck();
        this.moveCard();
        //this.deal(3);

        //this.setBackgroundColor(Color.blue);

    }
    /**
     * builds the board
     */
    public void buildBoard() {
        deal(4);
        cols[0].add(deck.pop());
        cols[1].add(deck.pop());
        cols[2].add(deck.pop());
        cols[3].add(deck.pop());
        reveal();
        //suit stack things

    }

    /**
     * reveals the top element of each stack
     */
    public void reveal() {
        //gui stuff...
    }
    /**
     * Deals the cards, one to each linked list
     * @param times
     */
    public void deal(int times) {
        for(int i = 0; i < times; i++) {
            //for(int j = 0; j < cols.length; j++) {
                Card holder = deck.pop();
                //cols[j].add(holder);
                holder.remove();
                holder.setLeftTop(100 * i, 300);
                holder.setRightBottom(100 * i + 71, 398);
                this.add(holder);
            //}
        }
    }
    // ----------------------------------------------------------
    /**
     * tester method
     */
    public void moveCard()
    {
        Card holder = deck.pop();
        holder.remove();
        holder.setPosition(500, 200);
        this.add(holder);
        // changint this stuff
    }
    /**
     * creates stack of 104 cards
     */
    public void buildDeck() {
        int count = 0;
        int num = 0;
        //0 = clubs, 1 = diamonds, 2 = hearts, 3 = spades
        int intSuit = 0;
        char suit = 'a';
        Random rando = new sofia.util.Random();
        while(count < 104) {
            num = rando.nextInt(14);
            intSuit = rando.nextInt(4);
            suit = num2Char(intSuit);
            if(!checkRepeat(num, suit) && num > 0) {
                //THE POSTITION VALUES SHOULD ALL BE THE SAME, IN DECK LOCATION
                Card holder = new Card(0, 0, 71, 98, num, suit);
                deck.push(holder);
                this.add(holder);
                count++;
            }
        }
    }
    /**
     * if the user touches the screen
     * @param x - the x cord
     * @param y - the y cord
     */
    public void onTouchDown(float x, float y) {
        processTouch(x, y);
    }
    /**
     * if the user swipes across the screen
     * @param x - the x cord
     * @param y - the y cord
     */
    public void onTouchMove(float x, float y) {
        processTouch(x, y);
    }
    /**
     * what to do if the screen is touched
     * @param xx - the x cord
     * @param yy - the y cord
     */
    private void processTouch(float xx, float yy) {
        //DO SHIT
    }
    /**
     * @param num - the number to check
     * @param suit - the char representation of suit
     * @return true if is a repeat
     */
    private boolean checkRepeat(int num, char suit) {
        int ct = 0;
        Card temp = null;
        Stack<Card> tempStack = deck;
        //check the cards already in the deck
        while(!tempStack.empty()) {
            temp = tempStack.pop();
            if(temp.getNumber() == num && temp.getSuit() == suit) {
                ct++;
            }
        }
        //if there are 8 return false
        if (ct < 2) {
            return false;
        }
        return true;
    }
    /**
     * translates the num suit into a char
     * 0= clubs, 1 = diamonds, 2 = hearts, 3 = spades
     */
    private char num2Char(int num) {
        if(num == 0) {
            return 'c';
        }
        else if (num == 1) {
            return 'd';
        }
        else if (num == 2) {
            return 'h';
        }
        else {
            return 's';
        }
    }

}