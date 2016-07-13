package com.james;

import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by jamesyburr on 7/12/16.
 */
public class TestMain {
    @Test
    public void testIsFlush() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SIX));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        boolean value = Main.isFlush(hand);
        assertTrue(value);
    }
}
