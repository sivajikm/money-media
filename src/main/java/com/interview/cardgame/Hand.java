package com.interview.cardgame;


public class Hand
{
    public static final int STRAIGHT_FLUSH = 3000;
    public static final int FLUSH          = 2000;
    public static final int STRAIGHT       = 1000;
    private final int HAND_SIZE = 5;
    private Card[] hand;


    public void addCard(Card card) {
        if(card !=  null)
            hand[hand.length + 1] = card;
    }

    public void display(Card[] cards) {
        for (int handCounter = 0; handCounter < HAND_SIZE; handCounter++)
        {
            Card card = cards[handCounter];
            System.out.println( card.getCardRankValue() + card.getSuitValue());
        }

    }

    public static int hasStraight( Card[] cards )
    {
        if ( isFlush(cards) && isStraight(cards) )
            return valueStraightFlush(cards);
        else if ( isFlush(cards) )
            return valueFlush(cards);
        else if ( isStraight(cards) )
            return valueStraight(cards);
        else
            return valueHighCard(cards);
    }

    public static int valueStraightFlush( Card[] cards )
    {
        return STRAIGHT_FLUSH + valueHighCard(cards);
    }

    public static int valueFlush( Card[] cards)
    {
        return FLUSH + valueHighCard(cards);
    }

    public static int valueStraight( Card[] cards )
    {
        return STRAIGHT + valueHighCard(cards);
    }

    public static int valueHighCard( Card[] cards )
    {
        int val;

        sortByRank(cards);

        val = cards[0].rank() + 14* cards[1].rank() + 14*14* cards[2].rank()
                + 14*14*14* cards[3].rank() + 14*14*14*14* cards[4].rank();

        return val;
    }

    public static boolean isFlush( Card[] cards )
    {
        if ( cards.length != 5 )
            return(false);

        sortBySuit(cards);

        return( cards[0].suit() == cards[4].suit() );
    }


    public static boolean isStraight( Card[] cards )
    {
        int i, testRank;

        if ( cards.length != 5 )
            return(false);

        sortByRank(cards);

        if ( cards[4].rank() == 13 )
        {
            boolean a = cards[0].rank() == 2 && cards[1].rank() == 3 &&
                    cards[2].rank() == 4 && cards[3].rank() == 5 ;
            boolean b = cards[0].rank() == 10 && cards[1].rank() == 11 &&
                    cards[2].rank() == 12 && cards[3].rank() == 13 ;

            return ( a || b );
        }
        else
        {
            testRank = cards[0].rank() + 1;

            for ( i = 1; i < 5; i++ )
            {
                if ( cards[i].rank() != testRank )
                    return(false);

                testRank++;
            }

            return(true);
        }
    }

    public static void sortByRank( Card[] cards )
    {
        int i, j, min_j;
        for ( i = 0 ; i < cards.length ; i ++ )
        {
            min_j = i;
            for ( j = i+1 ; j < cards.length ; j++ )
            {
                if ( cards[j].rank() < cards[min_j].rank() )
                {
                    min_j = j;
                }
            }
            Card card = cards[i];
            cards[i] = cards[min_j];
            cards[min_j] = card;
        }
    }

    public static void sortBySuit( Card[] cards )
    {
        int i, j, min_j;
        for ( i = 0 ; i < cards.length ; i ++ )
        {
            min_j = i;
            for ( j = i+1 ; j < cards.length ; j++ )
            {
                if ( cards[j].suit() < cards[min_j].suit() )
                {
                    min_j = j;
                }
            }
            Card card = cards[i];
            cards[i] = cards[min_j];
            cards[min_j] = card;
        }
    }

}