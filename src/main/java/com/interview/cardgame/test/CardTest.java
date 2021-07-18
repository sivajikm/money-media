package com.interview.cardgame.test;

import com.interview.cardgame.Card;

public class CardTest {

    public static void main(String... str) {
        Card card;
        int rank;
        String suite;
        card = new Card( Card.DIAMONDS, 2);

        rank = card.suit();
        System.out.println("Suit  " + rank);

        rank = card.rank();
        System.out.println("Rank  " + rank);

        suite = card.getSuitValue();
        System.out.println("SuitValue " + suite);

        suite = card.getCardRankValue();
        System.out.println("rankValue " + suite);
    }
}
