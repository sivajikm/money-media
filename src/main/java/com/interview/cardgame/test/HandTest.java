package com.interview.cardgame.test;

import com.interview.cardgame.Card;
import com.interview.cardgame.Deck;
import com.interview.cardgame.Hand;

public class HandTest {
    public static void main(String... string)
    {
        Deck deck;
        Card[] player1 = new Card[5];
        int i;

        deck = new Deck();
        deck.shuffle();

        for ( i = 0; i < 5; i++ )
            player1[i] = deck.dealCard();

        System.out.print("Hand:         ");
        for ( i = 0; i < 5; i++ )
            System.out.print( player1[i] + "  ");
        System.out.println();

        Hand.sortByRank(player1);

        System.out.print("Sort by rank: ");
        for ( i = 0; i < 5; i++ )
            System.out.print( player1[i] + "  ");
        System.out.println();

        Hand.sortBySuit(player1);

        System.out.print("Sort by suit: ");
        for ( i = 0; i < 5; i++ )
            System.out.print( player1[i] + "  ");

        System.out.println();
        boolean isFlush;
        boolean isStraight;

        isFlush = Hand.isFlush(player1);
        System.out.println("isFlush: " + isFlush);
        System.out.println();

        isStraight = Hand.isStraight(player1);
        System.out.println("isStraight: " + isStraight);

        System.out.println();
        new Hand().display(player1);

        System.out.println();
        System.out.println("Value of hand = " + Hand.hasStraight(player1) );


    }
}
