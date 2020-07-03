/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 * @modifier Meetkumar Rachhadia, 2020
 */
public class Card 
{
    
    enum SUIT{
        HEARTS,
        DIAMONDS,
        SPADES,
        CLUBS
    }
    //default modifier for child classes
    
    private SUIT suit;
    private int number;
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    public void setSuit(SUIT suit){
        this.suit = suit;
    }
    
    public SUIT getSuit(){
        return this.suit;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public int getNumber(){
        return this.number;
    }
    
    public String toString(){
        if(this.number==11){
            return "Jack of " + this.suit;
        } else if(this.number==12){
            return "Queen of " + this.suit;
        } else if(this.number==13){
            return "King of " + this.suit;
        } else if(this.number==1){
            return "Ace of " + this.suit;
        } else{
            return this.number + " of " + this.suit;
        }
    }
    
}
