/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Meetkumar Rachhadia, 991587874, 2020
 */
public class Play {
    
    //Pot amount the amount is the potetial winning currently present in table
    private double potAmt = 0;
    private double currentBet = 100;
    private double prevBet;
    Scanner in = new Scanner(System.in);
    
    public Play(ArrayList<Player> players){
        
        //Starting the game by showing respective players with their cards along with community cards
        while(players.size()>1){
            
            //Creating Deck and shuffling
            GroupOfCards cards = new GroupOfCards(52);
            cards.shuffle();

            //Getting the shuffled Deck and creating arraylist for community cards
            ArrayList<Card> cardDeck = cards.showCards();
            Card[][] playerCards = new Card[players.size()][2];
            ArrayList<Card> communityCards = new ArrayList<Card>();

            //Distributing Cards to players according to their player ID
            int cardNumber = 0;
            for(int i=0; i<2; i++){
                for(int j=0; j<players.size(); j++){
                    playerCards[players.get(j).getPlayerID()][i] = cardDeck.get(cardNumber);
                    cardNumber+=1;
                }
            }

            //Creating Community Cards (initially 3 then opens up to 5)
            int tempCardNumber = cardNumber;
            for(int i=tempCardNumber; i<(tempCardNumber+3); i++){
                communityCards.add(cardDeck.get(i));
                cardNumber++;
            }

            int playerCount = players.size();

            while(communityCards.size()<5){
                int firstSession=1;
                for(int j=0; j<playerCount; j++){

                    System.out.println("Community Cards:");
                    for(int p=0; p<communityCards.size(); p++){
                        System.out.println((p+1) + ". " + communityCards.get(p).toString());
                    }

                    //If in any case player loses or quits this needs to be checked
                    if(players.get(j).getPlayerActive()){
                        System.out.println(players.get(j).getPlayerName() + "'s turn:");

                        //Showing cards to respective users with basic hand of currentBet from each player
                        for(int k=0; k<2; k++){
                            System.out.println(playerCards[players.get(j).getPlayerID()][k].toString());
                            if(firstSession==1){
                                potAmt += currentBet;
                                players.get(j).setPlayerMoney(players.get(j).getPlayerMoney()-currentBet);
                                firstSession=0;
                            }
                        }

                        // The choice to either bet, call, raise, fold or quit
                        System.out.println("Enter your choice");
                        if(players.get(j).getPlayerTurnTaken()){
                            System.out.println("1. Call");
                        } else{
                            System.out.println("2. Check");
                        }
                        System.out.println("3. Raise");
                        System.out.println("4. Fold");
                        System.out.println("Default Choice: Leave/Quit the game");

                        int playerChoice = in.nextInt();

                        switch (playerChoice) {
                            case 1:
                                {
                                    //The bet amount should deduce player money equally
                                    System.out.println("Call:");
                                    double betAmt = currentBet - prevBet;
                                    if(players.get(j).getPlayerMoney()>betAmt){
                                        potAmt += betAmt;
                                    } else{
                                        potAmt += players.get(j).getPlayerMoney();
                                        players.get(j).setPlayerMoney(0);
                                        System.out.println("You are ALL IN!");
                                    }
                                    players.get(j).setPlayerTurnTaken(true);
                                    break;
                                }
                            case 2:
                                {
                                    System.out.println("Check!");
                                    if(!players.get(j).getPlayerTurnTaken()){
                                        if(players.get(j).getPlayerMoney()>currentBet){
                                            potAmt += currentBet;
                                            players.get(j).setPlayerMoney(players.get(j).getPlayerMoney()-currentBet);
                                        } else{
                                            potAmt += players.get(j).getPlayerMoney();
                                            players.get(j).setPlayerMoney(0);
                                            System.out.println("You are ALL IN!");
                                        }
                                    }
                                    break;
                                }
                            case 3:
                                {
                                    System.out.println("Enter your amount to raise (should be greater than " + currentBet + "):");
                                    double raise = in.nextDouble();
                                    players.get(j).setPlayerMoney(players.get(j).getPlayerMoney()-raise);
                                    potAmt += raise;
                                    prevBet = currentBet;
                                    currentBet = raise;
                                    players.get(j).setPlayerTurnTaken(true);
                                    for(int tmp=0; tmp<playerCount; tmp++){
                                        if(tmp!=j){
                                            players.get(tmp).setPlayerTurnTaken(false);
                                        }
                                    }
                                    j=0;

                                    break;
                                }
                            case 4:
                                {
                                    players.get(j).setPlayerActive(false);
                                    break;
                                }
                            default:
                                {
                                    players.remove(j);
                                    playerCount -= 1;
                                    j=j-1;
                                    break;
                                }
                        }
                    }
                }
                    communityCards.add(cardDeck.get(cardNumber));
                    cardNumber++;
            }

            //Sir, please note that we were only able to implement three kind of winning hands
            
            System.out.println("Community Cards:");
            for(int p=0; p<communityCards.size(); p++){
                System.out.println((p+1) + ". " + communityCards.get(p).toString());
            }
            
            if(communityCards.size()==5){
                for(int i=0; i<players.size(); i++){
                    int pairs=0, threeOfAKind=0, fourOfAKind=0, highCard=0;
                    Card[] tempCardArray = new Card[7];
                    if(players.get(i).getPlayerActive()){
                        for(int k=0; k<7; k++){
                            if(k<2){
                                tempCardArray[k] = playerCards[players.get(i).getPlayerID()][k];
                            } else{
                                tempCardArray[k] = communityCards.get(k-2);
                            }
                        }

                        for(int j=0; j<7; j++){
                            for(int k=j+1; k<7; k++){
                                if(tempCardArray[k].toString().charAt(0) == tempCardArray[j].toString().charAt(0)){
                                    if(pairs>0){
                                        threeOfAKind = 1;
                                        players.get(i).setHighestHand(4);
                                    } else if(threeOfAKind>0){
                                        fourOfAKind = 1;
                                        players.get(i).setHighestHand(8);
                                    } else{
                                        pairs = 1;
                                        players.get(i).setHighestHand(2);
                                    }
                                }
                                
                            }
                        }
                    }
                }
                
                //Declaring a winner for that particular session
                int max = 0, winningPlayerIndex=0;
                for(int i=0; i<players.size(); i++){
                    if(players.get(i).getPlayerActive()){
                        if(players.get(i).getHighestHand()>max){
                            winningPlayerIndex = i;
                            max = players.get(i).getHighestHand();
                        }
                    }
                }
                System.out.println("Winner for this round:" + players.get(winningPlayerIndex).getPlayerName());
                players.get(winningPlayerIndex).setPlayerMoney(players.get(winningPlayerIndex).getPlayerMoney()+potAmt);
                System.out.println("Your total money:" + players.get(winningPlayerIndex).getPlayerMoney());
            }
        }
    }
}
