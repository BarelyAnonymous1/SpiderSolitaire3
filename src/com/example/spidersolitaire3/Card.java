package com.example.spidersolitaire3;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
/**
 * // -------------------------------------------------------------------------
/**
 *  A card object for the solitare game
 *
 *  @author Anna Bosco, Preston Lattimer, Jonathan DeFreeuw
 *  @version Mar 29, 2015
 */
public class Card extends RectangleShape
{
    /**
     * Number Property
     */
    int number;
    /**
     * Suit Property
     * clubs (c), diamonds (d), hearts (h), spades (s)
     */
    char suit;
    /**
     * is Revealed
     * true if face up
     */
    boolean isRevealed;

    /**
     * Constructor
     * @param num  - the card number
     * @param suitLetter - char value of suit
     * @param left - left coord
     * @param top  - top coord
     * @param right  - right coord
     * @param bottom -bottom coord
     */
    public Card(float left, float top, float right, float bottom, int num, char suitLetter)
    {
        super(left, top, right, bottom);
        setImage("back.png");
        //this.setColor(Color.black);
        number = num;
        suit = suitLetter;
        isRevealed = false;
    }
    /**
     * Constructor with default suit
     * @param left - left coord
     * @param top  - top coord
     * @param right  - right coord
     * @param bottom -bottom coord
     * @param num - the card number
     */
    public Card(float left, float top, float right, float bottom, int num) {

        super(left, top, right, bottom);
        number = num;
        suit = 's';
    }
    /**
     * @return number
     */
    public int getNumber() {
        return number;
    }
    /**
     * @param num  - what to set
     */
    public void setNumber(int num) {
        number = num;
    }
    /**
     * @return char suit name
     */
    public char getSuit() {
        return suit;
    }
    /**
     * @param suitLetter  - first letter of suit name to set
     */
    public void setSuit(char suitLetter) {
        suit = suitLetter;
    }
    /**
     * @return isRevealed
     */
    public boolean getIsRevealed() {
        return isRevealed;
    }
    /**
     * reveals the card object
     */
    public void reveal() {
        isRevealed = true;
        String img = "";
        img = Integer.toString(number) + Character.toString(suit);
        setImage(img);
    }
}
