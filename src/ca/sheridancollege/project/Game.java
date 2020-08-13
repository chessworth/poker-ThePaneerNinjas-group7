/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 * @modifier Meetkumar Rachhadia, 2020
 */
public class Game
{
    private final String gameName;//the title of the game
    private ArrayList <Player> players = new ArrayList<Player>(6);// the players of the game
    
    Scanner in = new Scanner(System.in);
    
    public Game(String givenName)
    {
        gameName = givenName;
        
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers() 
    {
        
        System.out.println("The game needs at least two players and max of 6:");
        int playerCount = 0;
        
        while(playerCount<6){
            if(playerCount<2){
                System.out.println("Player-" + (playerCount+1) + " enter your name:");
                String playerName = in.nextLine();
                Player playerObject = new Player(playerName);
                playerObject.setPlayerID(playerCount);
                
                //Should be a positive integer
                System.out.println("Enter your buy in amount:");
                int playerMoney = in.nextInt();
                in.nextLine();
                playerObject.setPlayerMoney(playerMoney);
                
                this.players.add(playerObject);
                playerCount = playerCount + 1;
            } else{
                System.out.println("Are there any more players[y/n]:");
                String ans = in.nextLine();
                if(ans.equalsIgnoreCase("y")){
                    System.out.println("Player-" + (playerCount+1) + " enter your name:");
                    String playerName = in.nextLine();
                    Player playerObject = new Player(playerName);
                    playerObject.setPlayerID(playerCount);
                    
                    //Should be a positive integer
                    System.out.println("Enter your buy in amount:");
                    int playerMoney = in.nextInt();
                    in.nextLine();
                    playerObject.setPlayerMoney(playerMoney);
                    
                    playerCount = playerCount + 1;
                    this.players.add(playerObject);
                } else{
                    System.out.println("The game will start now:");
                    Play playObj = new Play(players);
                    break;
                }
            }
        }
        if(playerCount==6){
            System.out.println("The game will start now:");
            Play playObj = new Play(players);
        }
    }
    
}//end class
