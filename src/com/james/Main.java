package com.james;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {

    static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }
        return deck;
    }

    static HashSet<HashSet<Card>> createHands(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet<>();
        for (Card c1 : deck) {
            HashSet<Card> deck2  = (HashSet<Card>) deck.clone();
            deck2.remove(c1);
            for (Card c2 : deck2) {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(c2);
                for (Card c3 : deck3) {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(c3);
                    for (Card c4 : deck4) {
                        HashSet<Card> hand = new HashSet<>();
                        hand.add(c1);
                        hand.add(c2);
                        hand.add(c3);
                        hand.add(c4);
                        hands.add(hand);
                    }
                }
            }
        }
        return hands;
    }

    static boolean isFlush(HashSet<Card> hand) {
        HashSet<Card.Suit> suits = hand.stream()
                .map(card -> card.suit)
                .collect(Collectors.toCollection(HashSet<Card.Suit>::new));
        return suits.size() == 1;
    }

    static boolean isStraightFlush(HashSet<Card> hand) {
        if (isFlush(hand) && isStraight(hand)) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean isStraight(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        ArrayList<Integer> sortedRanks = ranks.stream()
                .sorted((r1, r2) -> Integer.compare(r1.intValue(), r2.byteValue()))
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        if (sortedRanks.get(0) + 1 == sortedRanks.get(1) && sortedRanks.get(0) + 2 == sortedRanks.get(2) && sortedRanks.get(0) + 3 == sortedRanks.get(3)) {
            return true;
        }
        return false;
    }

    static boolean isFourOfaKind(HashSet<Card> hand) {
        HashSet<Card.Rank> ranks = hand.stream()
                .map(card -> card.rank)
                .collect(Collectors.toCollection(HashSet<Card.Rank>::new));
        return ranks.size() == 1;
    }

    static boolean isThreeOfaKind(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        for (int i = 1; i <= 13; i++) {
            int f = Collections.frequency(ranks, i);
            if (f == 3) {
                return true;
            }
        }
        return false;
    }

    static boolean isTwoPairs(HashSet<Card> hand) {
        ArrayList<Integer> ranks = hand.stream()
                .map(card -> card.rank.ordinal())
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
        int paircnt = 0;
        for (int i = 1; i <= 13; i++) {
            int freq = Collections.frequency(ranks, i);
            if (freq == 2) {
                paircnt++;
            }
        }
        if (paircnt == 2) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        HashSet<Card> deck = createDeck();
        HashSet<HashSet<Card>> hands = createHands(deck);
        HashSet<HashSet<Card>> flushes = hands.stream()
                .filter(Main::isFlush)
                .collect(Collectors.toCollection(HashSet<HashSet<Card>>::new));
        System.out.println(flushes.size());
    }
}
