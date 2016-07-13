package com.james;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashSet;



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
        Assert.assertTrue(value);
    }

    @Test
    public void testIsStraightFlush() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.THREE));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        boolean value = Main.isFlush(hand);
        Assert.assertTrue(value);
    }

    @Test
    public void testIsStraight() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.THREE));
        hand.add(new Card(Card.Suit.SPADES, Card.Rank.TWO));
        boolean value = Main.isStraight(hand);
        Assert.assertTrue(value);
    }

    @Test
    public void testIsFourOfaKind() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        boolean value = Main.isFourOfaKind(hand);
        Assert.assertTrue(value);
    }

    @Test
    public void testIsThreeOfaKind() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.FIVE));
        boolean value = Main.isThreeOfaKind(hand);
        Assert.assertTrue(value);
    }

    @Test
    public void testIsTwoPairs() {
        HashSet<Card> hand = new HashSet<>();
        hand.add(new Card(Card.Suit.CLUBS, Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        hand.add(new Card(Card.Suit.DIAMONDS, Card.Rank.FOUR));
        hand.add(new Card(Card.Suit.SPADES, Card.Rank.FOUR));
        boolean value = Main.isTwoPairs(hand);
        Assert.assertTrue(value);
    }
}
