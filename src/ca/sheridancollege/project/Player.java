/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 * @modifier Meetkumar Rachhadia, 2020
 */
public class Player 
{
//    HIGHCARD=1,
//    ONEPAIR=2,
//    TWOPAIR=3,
//    THREEOFAKIND=4,
//    STRAIGHT=5,
//    FLUSH=6,
//    FULLHOUSE=7,
//    FOUROFAKIND=8,
//    STRAIGHTFLUSH=9,
//    ROYALFLUSH=10

    
    private int playerID; //the unique ID for this player
    private String playerName;
    private double playerMoney;
    private boolean playerActive;
    private boolean turnTaken;
    private int highestHand;
    
    /**
     * A constructor that allows you to set the player's name
     * @param playerName the name to assign to this player.
     */
    public Player(String playerName)
    {
        this.playerName = playerName;
        this.playerActive = true;
    }
    
    /**
     * @return the playerName
     */
    public String getPlayerName(){
        return this.playerName;
    }
    
    /**
     * @return the playerID
     */
    public int getPlayerID() 
    {
        return this.playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param playerID the playerID to set
     */
    public void setPlayerID(int playerID) 
    {
        this.playerID = playerID;
    }
    
    public double getPlayerMoney(){
        return this.playerMoney;
    }
    
    public void setPlayerMoney(double playerMoney){
        this.playerMoney = playerMoney;
    }
    
    public boolean getPlayerActive()
    {
        return this.playerActive;
    }
    
    public void setPlayerActive(boolean playerActive)
    {
        this.playerActive = playerActive;
    }
    
    public boolean getPlayerTurnTaken(){
        return turnTaken;
    }
    
    public void setPlayerTurnTaken(boolean turn){
        turnTaken = turn;
    }
    
    public int getHighestHand(){
        return highestHand;
    }
    
    public void setHighestHand(int highHand){
        highestHand = highHand;
    }
    
}
