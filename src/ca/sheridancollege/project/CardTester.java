/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author meetr
 */
public class CardTester {
    public static void main(String args[]){
        
        GroupOfCards obj = new GroupOfCards(52);
        obj.shuffle();
        
        ArrayList<Card> cards = obj.showCards();
        for(Card card: cards){
            System.out.println(card.toString());
        }
    }
}
