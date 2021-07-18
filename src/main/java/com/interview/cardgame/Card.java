package com.interview.cardgame;


public class Card
{
    public static final int CLUBS       = 1;
    public static final int DIAMONDS    = 2;
    public static final int HEARTS      = 3;
    public static final int SPADES      = 4;


    private static final String[] Suit = { "*", "CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    private static final String[] CardRank = { "*", "2", "3", "4",
            "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private byte cardSuit;
    private byte cardRank;

    public Card( int suit, int rank )
    {
        cardRank = (byte) rank;
        cardSuit = (byte) suit;
    }

    public int suit()
    {
        return this.cardSuit;
    }

    public String getSuitValue()
    {
        return this.Suit[ this.cardSuit ];
    }

    public int rank()
    {
        return this.cardRank;
    }

    public String getCardRankValue()
    {
        return this.CardRank[ this.cardRank ];
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardSuit=" + cardSuit +
                ", cardRank=" + cardRank +
                '}';
    }

}