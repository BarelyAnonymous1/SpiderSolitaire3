package com.example.spidersolitaire3;

import sofia.graphics.Color;
import sofia.app.ShapeScreen;


/*SUMMARY OF WHAT I DID:
 * I created the major methods, i think have the logic for buildDeck working
 * My project is being stupid so haven't tested anything yet
 * Also, do we wanna like make an array of linked list instead of having them float around?
 * did not touch the GUI
 */
import sofia.util.Random;
import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import sofia.app.ShapeScreen;
/**
 * // -------------------------------------------------------------------------
/**
 *  Logic for the spider solitare game
 *  @author Anna Bosco, Preston Lattimer, Jonathan DeFreeuw
 *  @version Mar 29, 2015
 */
public class SpiderSolitaire extends ShapeScreen
{
    /**
     *
     */
    private Stack<Card> deck;
    /**
     * Array of Linked List Objects
     */
    private LinkedList<Card> [] cols;

    /**
     * builds the gui
     */
    public void initialize()
    {
        deck = new Stack<Card>();
        cols = new LinkedList[10];
        for(int i = 0; i < cols.length; i++) {
            cols[i] = new LinkedList<Card>();
        }
        this.buildDeck();
        this.moveCard();
        this.deal(1);

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
            for(int j = 0; j < cols.length; j++) {
                Card holder = deck.pop();
                cols[j].add(holder);
                //holder.remove();
                holder.setLeftTop(100 * i, 300);
                holder.setRightBottom(100 * i + 71, 398);
                this.add(holder);
            }
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
        while(count < 52) {
            num = rando.nextInt(13) + 1;
            intSuit = rando.nextInt(4);
            suit = num2Char(intSuit);
            Card holder = new Card(0, 0, 71, 98, num, suit);
            if(!checkRepeat(num, suit)) {
                //THE POSTITION VALUES SHOULD ALL BE THE SAME, IN DECK LOCATION
                deck.push(holder);
                this.add(holder);
                count++;
            }
        }
        //deck.push(new Card(0, 0, 71, 98, 3, 'c'));
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
                return true;
            }
        }
        return false;
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