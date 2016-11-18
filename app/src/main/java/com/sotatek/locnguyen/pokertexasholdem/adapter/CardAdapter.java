/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem.adapter;


import com.sotatek.locnguyen.pokertexasholdem.enums.HandType;
import com.sotatek.locnguyen.pokertexasholdem.enums.RANK;
import com.sotatek.locnguyen.pokertexasholdem.enums.SUIT;
import com.sotatek.locnguyen.pokertexasholdem.model.Best5Cards;
import com.sotatek.locnguyen.pokertexasholdem.model.Card;
import com.sotatek.locnguyen.pokertexasholdem.model.CardUnit;
import com.sotatek.locnguyen.pokertexasholdem.model.Hand;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author nuitran
 *
 */
public class CardAdapter {
    private Map<String, CardUnit> mapCard = new HashMap<>();

    private Map<Integer, Hand> players = new HashMap<>();

    private CardUnit[] board = new CardUnit[5];

    public CardAdapter() {
        initial();
    }

    private void initial() {
        SUIT[] suits = SUIT.values();
        RANK[] ranks = RANK.values();
        for (SUIT suit : suits) {
            for (RANK rank : ranks) {
                // mapCard.put(rank.toString() + suit.toString(), new Card(suit,
                // rank));
                CardUnit card = new CardUnit(suit, rank);
                resumeCard(card);
            }
        }
    }

    public void createHand(Integer index, CardUnit card1, CardUnit card2) {
        players.put(index, new Hand(card1, card2));
    }

    public void killCard(CardUnit card) {
        mapCard.remove(card.rank.toString() + card.suit.toString());
    }

    public void resumeCard(CardUnit card) {
        mapCard.put(card.rank.toString() + card.suit.toString(), card);
    }

    public void resumeCard(List<CardUnit> cards) {
        for (CardUnit element : cards) {
            mapCard.put(element.rank.toString() + element.suit.toString(), element);
        }
    }

    public void flop(CardUnit card1, CardUnit card2, CardUnit card3) {
        board[0] = card1;
        board[1] = card2;
        board[2] = card3;
    }

    public void turn(CardUnit card4) {
        board[3] = card4;
    }

    public void river(CardUnit card5) {
        board[4] = card5;
    }

    public void calculateFlop() {
        cleanRateAndCount();
        Integer count = 0;
        for (String key1 : mapCard.keySet()) {
            CardUnit card4 = mapCard.get(key1);
            board[3] = card4;
            for (String key2 : mapCard.keySet()) {
                CardUnit card5 = mapCard.get(key2);
                if (card5 == card4) {
                    continue;
                }
                board[4] = card5;
                calculate();
                count++;
            }
        }
        board[3] = null;
        board[4] = null;
        calculateRate(count);
        recreateDeck();
    }

    public void calculateTurn() {
        cleanRateAndCount();
        Integer count = 0;
        for (String key : mapCard.keySet()) {
            CardUnit card5 = mapCard.get(key);
            board[4] = card5;
            calculate();
            count++;
        }
        board[4] = null;
        calculateRate(count);
        recreateDeck();
    }

    public void calculateRiver() {
        cleanRateAndCount();
        calculate();
        calculateRate(1);
        recreateDeck();
    }

    private void cleanRateAndCount() {
        for (Integer key : players.keySet()) {
            Hand hand = players.get(key);
            hand.countBestHand = 0.0;
            hand.countSplit = 0.0;
            mapCard.remove(hand.card1.rank.toString() + hand.card1.suit.toString());
            mapCard.remove(hand.card2.rank.toString() + hand.card2.suit.toString());
        }
        for (int i = 0; i < board.length; i++) {
            CardUnit card = board[i];
            if (card != null) {
                mapCard.remove(card.rank.toString() + card.suit.toString());
            }
        }
    }

    private void recreateDeck() {
        for (Integer key : players.keySet()) {
            CardUnit card1 = players.get(key).card1;
            CardUnit card2 = players.get(key).card2;
            mapCard.put(card1.rank.toString() + card1.suit.toString(), card1);
            mapCard.put(card2.rank.toString() + card2.suit.toString(), card2);
        }
        for (int i = 0; i < board.length; i++) {
            CardUnit card = board[i];
            if (card != null) {
                mapCard.put(card.rank.toString() + card.suit.toString(), card);
            }
        }
    }

    private void calculateRate(int count) {
        for (Integer key : players.keySet()) {
            players.get(key).setRate(new BigDecimal(players.get(key).countBestHand / count * 100));
            players.get(key).setSplit(new BigDecimal(players.get(key).countSplit / count * 100));
        }
    }

    private void calculate() {
        List<Best5Cards> hands = new ArrayList<>();
        Map<Integer, Best5Cards> result = new HashMap<>();
        for (Integer key : players.keySet()) {
            Best5Cards hand = getBestOfHand(players.get(key));
            hands.add(hand);
            result.put(key, hand);
        }
        Best5Cards max = Collections.max(hands);
        List<Integer> bestHandKeys = new ArrayList<>();
        for (Integer key : players.keySet()) {
            if (max.compareTo(result.get(key)) == 0) {
                bestHandKeys.add(key);
            }
        }
        if (bestHandKeys.isEmpty()) {
            return;
        }
        if (bestHandKeys.size() == 1) {
            players.get(bestHandKeys.get(0)).countBestHand++;
        } else {
            for (Integer key : bestHandKeys) {
                players.get(key).countSplit++;
            }
        }

    }

    public Best5Cards getBestOfHand(Hand hand) {
        // keep two card
        Best5Cards case11 = getResult(hand.card1, hand.card2, board[0], board[1], board[2]);
        Best5Cards case12 = getResult(hand.card1, hand.card2, board[0], board[1], board[3]);
        Best5Cards case13 = getResult(hand.card1, hand.card2, board[0], board[1], board[4]);
        Best5Cards case14 = getResult(hand.card1, hand.card2, board[1], board[2], board[3]);
        Best5Cards case15 = getResult(hand.card1, hand.card2, board[1], board[2], board[4]);
        Best5Cards case16 = getResult(hand.card1, hand.card2, board[2], board[3], board[4]);
        // keep 1st card
        Best5Cards case21 = getResult(hand.card1, board[0], board[1], board[2], board[3]);
        Best5Cards case22 = getResult(hand.card1, board[0], board[1], board[2], board[4]);
        Best5Cards case23 = getResult(hand.card1, board[0], board[1], board[3], board[4]);
        Best5Cards case24 = getResult(hand.card1, board[0], board[2], board[3], board[4]);
        Best5Cards case25 = getResult(hand.card1, board[1], board[2], board[3], board[4]);
        // keep 2nd card
        Best5Cards case31 = getResult(hand.card2, board[0], board[1], board[2], board[3]);
        Best5Cards case32 = getResult(hand.card2, board[0], board[1], board[2], board[4]);
        Best5Cards case33 = getResult(hand.card2, board[0], board[1], board[3], board[4]);
        Best5Cards case34 = getResult(hand.card2, board[0], board[2], board[3], board[4]);
        Best5Cards case35 = getResult(hand.card2, board[1], board[2], board[3], board[4]);
        // discard 2 card in hand
        Best5Cards case41 = getResult(board[0], board[1], board[2], board[3], board[4]);

        Best5Cards max = Collections.max(Arrays.asList(case11, case12, case13, case14, case15, case16, case21, case22,
                case23, case24, case25, case31, case32, case33, case34, case35, case41));

        return max;
    }

    public Best5Cards getResult(CardUnit card1, CardUnit card2, CardUnit card3, CardUnit card4, CardUnit card5) {
        List<CardUnit> cards = new LinkedList<CardUnit>(Arrays.asList(card1, card2, card3, card4, card5));
        Collections.sort(cards);
        Best5Cards result = new Best5Cards();
        result = isStraightFlush(cards);
        if (result != null) {
            return result;
        }
        result = isFourOfAKind(cards);
        if (result != null) {
            return result;
        }
        result = isFullHouse(cards);
        if (result != null) {
            return result;
        }
        result = isFlush(cards);
        if (result != null) {
            return result;
        }
        result = isStraight(cards);
        if (result != null) {
            return result;
        }
        result = isThreeOfAKind(cards);
        if (result != null) {
            return result;
        }
        result = isTwoPair(cards);
        if (result != null) {
            return result;
        }
        result = isPair(cards);
        if (result != null) {
            return result;
        }
        result = isHighCard(cards);
        if (result != null) {
            return result;
        }
        return null;
    }

    public Best5Cards isStraightFlush(List<CardUnit> cards) {
        // case A 2 3 4 5 => card(4) is A and cards(3) is Five
        if (cards.get(4).rank.value.equals(14) && cards.get(3).rank.value.equals(5) && cards.get(2).rank.value.equals(4)
                && cards.get(1).rank.value.equals(3) && cards.get(0).rank.value.equals(2)
                && cards.get(0).suit.equals(cards.get(1).suit) && cards.get(0).suit.equals(cards.get(2).suit)
                && cards.get(0).suit.equals(cards.get(3).suit) && cards.get(0).suit.equals(cards.get(4).suit)) {
            Best5Cards result = new Best5Cards();
            result.handType = HandType.STRAIGHT_FLUSH;
            result.cards = cards;
            result.keyCard = cards.get(3);
            return result;
        }
        if (cards.get(0).rank.value.equals((cards.get(1).rank.value - 1))
                && cards.get(0).rank.value.equals((cards.get(2).rank.value - 2))
                && cards.get(0).rank.value.equals((cards.get(3).rank.value - 3))
                && cards.get(0).rank.value.equals((cards.get(4).rank.value - 4))
                && cards.get(0).suit.equals(cards.get(1).suit) && cards.get(0).suit.equals(cards.get(2).suit)
                && cards.get(0).suit.equals(cards.get(3).suit) && cards.get(0).suit.equals(cards.get(4).suit)) {
            Best5Cards result = new Best5Cards();
            result.handType = HandType.STRAIGHT_FLUSH;
            result.cards = cards;
            result.keyCard = cards.get(4);
            return result;
        }
        return null;
    }

    public Best5Cards isFourOfAKind(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        if (cards.get(0).equals(cards.get(1)) && cards.get(0).equals(cards.get(2))
                && cards.get(0).equals(cards.get(3))) {
            result.handType = HandType.FOUR_OF_A_KIND;
            result.odds = Arrays.asList(cards.remove(4));
            result.cards = cards;
            result.keyCard = cards.get(0);
            return result;
        } else if (cards.get(1).equals(cards.get(2)) && cards.get(1).equals(cards.get(3))
                && cards.get(1).equals(cards.get(4))) {
            result.handType = HandType.FOUR_OF_A_KIND;
            result.odds = Arrays.asList(cards.remove(0));
            result.cards = cards;
            result.keyCard = cards.get(3);
            return result;
        } else {
            return null;
        }
    }

    public Best5Cards isFullHouse(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        if (cards.get(0).equals(cards.get(1)) && cards.get(2).equals(cards.get(3))
                && cards.get(2).equals(cards.get(4))) {
            result.handType = HandType.FULL_HOUSE;
            result.cards = cards;
            result.keyCard = cards.get(2);
            result.odds = Arrays.asList(cards.get(0));
            return result;
        } else if (cards.get(0).equals(cards.get(1)) && cards.get(0).equals(cards.get(2))
                && cards.get(3).equals(cards.get(4))) {
            result.handType = HandType.FULL_HOUSE;
            result.cards = cards;
            result.keyCard = cards.get(0);
            result.odds = Arrays.asList(cards.get(3));
            return result;
        } else {
            return null;
        }

    }

    public Best5Cards isFlush(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        if (cards.get(0).suit.equals(cards.get(1).suit) && cards.get(0).suit.equals(cards.get(2).suit)
                && cards.get(0).suit.equals(cards.get(3).suit) && cards.get(0).suit.equals(cards.get(4).suit)) {
            result.handType = HandType.FLUSH;
            result.cards = cards;
            result.keyCard = cards.get(4);
            result.odds = cards;
            return result;
        } else {
            return null;
        }
    }

    public Best5Cards isStraight(List<CardUnit> cards) {
        // case A 2 3 4 5 => card(4) is A and cards(3) is Five
        if (cards.get(4).rank.value.equals(14) && cards.get(3).rank.value.equals(5) && cards.get(2).rank.value.equals(4)
                && cards.get(1).rank.value.equals(3) && cards.get(0).rank.value.equals(2)) {
            Best5Cards result = new Best5Cards();
            result.handType = HandType.STRAIGHT;
            result.cards = cards;
            result.keyCard = cards.get(3);
            return result;
        }
        if (cards.get(0).rank.value.equals((cards.get(1).rank.value - 1))
                && cards.get(0).rank.value.equals((cards.get(2).rank.value - 2))
                && cards.get(0).rank.value.equals((cards.get(3).rank.value - 3))
                && cards.get(0).rank.value.equals((cards.get(4).rank.value - 4))) {
            Best5Cards result = new Best5Cards();
            result.handType = HandType.STRAIGHT;
            result.cards = cards;
            result.keyCard = cards.get(4);
            return result;
        }
        return null;
    }

    public Best5Cards isThreeOfAKind(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        if ((cards.get(0).equals(cards.get(1)) && cards.get(0).equals(cards.get(2)))) {
            result.handType = HandType.THREE_OF_A_KIND;
            result.cards = cards;
            result.keyCard = cards.get(0);
            result.odds = Arrays.asList(cards.get(3), cards.get(4));
            Collections.sort(result.odds);
            return result;
        } else if ((cards.get(1).equals(cards.get(2)) && cards.get(1).equals(cards.get(3)))) {
            result.handType = HandType.THREE_OF_A_KIND;
            result.cards = cards;
            result.keyCard = cards.get(1);
            result.odds = Arrays.asList(cards.get(0), cards.get(4));
            Collections.sort(result.odds);
            return result;
        } else if ((cards.get(2).equals(cards.get(3)) && cards.get(2).equals(cards.get(4)))) {
            result.handType = HandType.THREE_OF_A_KIND;
            result.cards = cards;
            result.keyCard = cards.get(2);
            result.odds = Arrays.asList(cards.get(0), cards.get(1));
            Collections.sort(result.odds);
            return result;
        } else {
            return null;
        }
    }

    public Best5Cards isTwoPair(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        if (cards.get(0).equals(cards.get(1)) && cards.get(2).equals(cards.get(3))) {
            result.handType = HandType.TWO_PAIR;
            result.cards = cards;
            result.keyCard = cards.get(2);
            result.odds = Arrays.asList(cards.get(4), cards.get(0));
            return result;
        } else if (cards.get(0).equals(cards.get(1)) && cards.get(3).equals(cards.get(4))) {
            result.handType = HandType.TWO_PAIR;
            result.cards = cards;
            result.keyCard = cards.get(3);
            result.odds = Arrays.asList(cards.get(2), cards.get(0));
            return result;
        } else if (cards.get(1).equals(cards.get(2)) && cards.get(3).equals(cards.get(4))) {
            result.handType = HandType.TWO_PAIR;
            result.cards = cards;
            result.keyCard = cards.get(3);
            result.odds = Arrays.asList(cards.get(0), cards.get(1));
            return result;
        } else {
            return null;
        }
    }

    public Best5Cards isPair(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        if (cards.get(0).equals(cards.get(1))) {
            result.handType = HandType.PAIR;
            result.cards = cards;
            result.keyCard = cards.get(0);
            result.odds = Arrays.asList(cards.get(2), cards.get(3), cards.get(4));
            Collections.sort(result.odds);
            return result;
        } else if (cards.get(1).equals(cards.get(2))) {
            result.handType = HandType.PAIR;
            result.cards = cards;
            result.keyCard = cards.get(1);
            result.odds = Arrays.asList(cards.get(0), cards.get(3), cards.get(4));
            Collections.sort(result.odds);
            return result;
        } else if (cards.get(2).equals(cards.get(3))) {
            result.handType = HandType.PAIR;
            result.cards = cards;
            result.keyCard = cards.get(2);
            result.odds = Arrays.asList(cards.get(0), cards.get(1), cards.get(4));
            Collections.sort(result.odds);
            return result;
        } else if (cards.get(3).equals(cards.get(4))) {
            result.handType = HandType.PAIR;
            result.cards = cards;
            result.keyCard = cards.get(3);
            result.odds = Arrays.asList(cards.get(0), cards.get(1), cards.get(2));
            Collections.sort(result.odds);
            return result;
        } else {
            return null;
        }
    }

    public Best5Cards isHighCard(List<CardUnit> cards) {
        Best5Cards result = new Best5Cards();
        result.handType = HandType.HIGH_CARD;
        result.keyCard = cards.get(4);
        result.odds = cards;
        return result;
    }

    public void printResult() {
        System.out.println("======Result rate=======");
        for (Integer key : players.keySet()) {
            BigDecimal result = players.get(key).rate;
            result.setScale(2, RoundingMode.HALF_UP);
            System.out.print("Player " + key + " : " + result.setScale(2, RoundingMode.HALF_UP) + " % ");
            BigDecimal split = players.get(key).splitRate;
            System.out.println("- Split:  " + split.setScale(2, RoundingMode.HALF_UP) + " %");
        }
        // System.out.println("Split : " + split.setScale(2,
        // RoundingMode.HALF_UP) + " %");
    }
}
