package com.interview.cardgame;

import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class CardJunitTest {

    private Deck deck;
    private static final int TOTAL_NO_CARDS = 52;

    @Before
    public void setUp(){
        deck = new Deck();
    }

    @Test
    public void createSmallDeckWithoutShuffle() {
        deck.shuffle();
        Card cardOne = deck.dealCard();
        Card cardTwo = deck.dealCard();
        assertNotNull(cardOne);
        assertNotNull(cardTwo);
        assertNotEquals("cardOne and cardTwo should be different", cardOne, cardTwo);
    }

    @Test
    public void createSmallDeckWithShuffle() {
        deck.shuffle();
        Card cardOne = deck.dealCard();
        Card cardTwo = deck.dealCard();
        deck.shuffle();
        assertNotNull(cardOne);
        assertNotNull(cardTwo);
        assertNotEquals(cardOne, cardTwo);
    }

    @Test
    public void testShuffle() throws Exception{
        deck.shuffle();
        int TOTAL_NO_CARDS = 52;
        Card[] testDeck = new Card[ TOTAL_NO_CARDS ];
        int i = 0;
        for ( int suit = Card.CLUBS; suit <= Card.SPADES; suit++ )
            for ( int rank = 1; rank <= 13; rank++ )
                testDeck[i++] = new Card(suit, rank);
        assertTrue(testDeck.length == 52);
    }

    @Test
    public void testFlush() {

        Card[] hand = new Card[5];
        hand[0] = new Card(Card.CLUBS, 3);
        hand[1] = new Card(Card.CLUBS, 10);
        hand[2] = new Card(Card.CLUBS, 11);
        hand[3] = new Card(Card.CLUBS, 12);
        hand[4] = new Card(Card.CLUBS, 13);

        int nCount = Hand.hasStraight(hand);
        assertEquals("Expected Flush;", 536635,
                nCount);
    }

    @Test
    public void testStraight() {

        Card[] hand = new Card[5];
        hand[0] = new Card(Card.SPADES, 6);
        hand[1] = new Card(Card.SPADES, 5);
        hand[2] = new Card(Card.CLUBS, 4);
        hand[3] = new Card(Card.CLUBS, 3);
        hand[4] = new Card(Card.HEARTS, 2);

        int nCount = Hand.hasStraight(hand);
        assertEquals("Expected Straight;", 246044,
                nCount);
    }
}
