package com.interview.cardgame;

public class Deck {
    public static final int TOTAL_NO_CARDS = 52;

    private Card[] originalDeck;
    private int currentCard;
    private Card[] notDealtDeck;
    private Card[] dealtDecks;

    public Deck( )
    {
        originalDeck = new Card[ TOTAL_NO_CARDS ];

        int i = 0;

        for ( int suit = Card.CLUBS; suit <= Card.SPADES; suit++ )
            for ( int rank = 1; rank <= 13; rank++ )
                originalDeck[i++] = new Card(suit, rank);

        currentCard = 0;
        notDealtDeck = originalDeck;
        dealtDecks = new Card[TOTAL_NO_CARDS];

    }

    public void shuffle()
    {
        for ( int i = originalDeck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = originalDeck[i];
            originalDeck[i] = originalDeck[rand];
            originalDeck[rand] = temp;
        }
        currentCard = 0;
    }


    public Card dealCard()
    {
        if ( currentCard < TOTAL_NO_CARDS )
        {
            dealtDecks[currentCard++] = notDealtDeck[ currentCard++ ];

            return ( notDealtDeck[ currentCard++ ] );
        }
        else
        {
            return null;
        }
    }

    public void display() {

        for(Card notDealt : notDealtDeck) {
            System.out.println("ND Values:  " + notDealt.getCardRankValue() + "  Suit :" + notDealt.getSuitValue());
        }

        for(Card dealt : dealtDecks) {
            System.out.println("ND Values:  " + dealt.getCardRankValue() + "  Suit :" + dealt.getSuitValue());
        }
    }
}
