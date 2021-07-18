package com.interview.cardgame.test;

import com.interview.cardgame.Deck;

public class DeckTest {
    public static void main(String args[]) {
        Deck decks  = new Deck();
        int numHands = 4;
        int cardsPerHand = 30;

        for (int i=0; i < numHands; i++)
        {
            decks.shuffle();
            try {
                System.out.println("\n\nHand "+i+":"+cardsPerHand+" cards");
                decks.dealCard();
                decks.display();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
