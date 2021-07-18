package com.interview.cardgame;

public class Application {
    public static void main(String[] args)
    {
        Deck deck;

        Card[] player1 = new Card[5];
        Card[] player2 = new Card[5];

        int i;

        deck = new Deck();
        System.out.println(deck);

        System.out.println("Shuffle cards....");
        deck.shuffle();
        System.out.println(deck);

        for ( i = 0; i < 5; i++ )
        {
            player1[i] = deck.dealCard();
            player2[i] = deck.dealCard();
        }

        System.out.print("Player 1's hand: ");
        for ( i = 0; i < 5; i++ )
            System.out.print( player1[i] + "  ");
        System.out.println(" - value = " +  Hand.hasStraight(player1) );

        System.out.print("Player 2's hand: ");
        for ( i = 0; i < 5; i++ )
            System.out.print( player2[i] + "  ");
        System.out.println(" - value = " +  Hand.hasStraight(player2) );

        if ( Hand.hasStraight(player1) > Hand.hasStraight(player2) )
            System.out.println("Player 1 wins");
        else if ( Hand.hasStraight(player1) < Hand.hasStraight(player2) )
            System.out.println("Player 2 wins");
        else
            System.out.println("Player hands are a tie");
        System.out.println();

    }
}
