/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

import ca.sheridancollege.project.Card.SUIT;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * @modifier - Meetkumar Rachhadia
 * date modified - 28th June 2020
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        this.size = givenSize;
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        for(int i=0; i<4; i++){
            SUIT tempSuit = SUIT.values()[i];
            for(int j=0; j<13; j++){
                Card obj = new Card();
                obj.setNumber(j+1);
                obj.setSuit(tempSuit);
//                System.out.println(obj.toString());
                this.cards.add(obj);
            }
        }
//        Card obj2 = new Card();
//        this.cards.add(obj2);
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class
