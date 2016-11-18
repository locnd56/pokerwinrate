/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem;

import com.sotatek.locnguyen.pokertexasholdem.adapter.CardAdapter;
import com.sotatek.locnguyen.pokertexasholdem.enums.HandType;
import com.sotatek.locnguyen.pokertexasholdem.enums.RANK;
import com.sotatek.locnguyen.pokertexasholdem.enums.SUIT;
import com.sotatek.locnguyen.pokertexasholdem.model.Best5Cards;
import com.sotatek.locnguyen.pokertexasholdem.model.CardUnit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author nuitran
 *
 */
public class CardAdapterTest {

    @Test
    public void testStraighFlush001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card4 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Five);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.STRAIGHT_FLUSH);
    }

    @Test
    public void testStraighFlush002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card4 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Five);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.STRAIGHT_FLUSH);
    }

    @Test
    public void testFourOfAKind001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card3 = new CardUnit(SUIT.Heart, RANK.Two);
        CardUnit card4 = new CardUnit(SUIT.Club, RANK.Two);
        CardUnit card5 = new CardUnit(SUIT.Spade, RANK.Two);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.FOUR_OF_A_KIND);
    }

    @Test
    public void testFourOfAKind002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card3 = new CardUnit(SUIT.Heart, RANK.Eight);
        CardUnit card4 = new CardUnit(SUIT.Club, RANK.Eight);
        CardUnit card5 = new CardUnit(SUIT.Spade, RANK.Eight);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.FOUR_OF_A_KIND);
    }

    @Test
    public void testFullHouse001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Three);
        CardUnit card3 = new CardUnit(SUIT.Heart, RANK.Two);
        CardUnit card4 = new CardUnit(SUIT.Club, RANK.Two);
        CardUnit card5 = new CardUnit(SUIT.Spade, RANK.Two);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.FULL_HOUSE);
    }

    @Test
    public void testFullHouse002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Three);
        CardUnit card3 = new CardUnit(SUIT.Club, RANK.Three);
        CardUnit card4 = new CardUnit(SUIT.Club, RANK.Two);
        CardUnit card5 = new CardUnit(SUIT.Spade, RANK.Two);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.FULL_HOUSE);
    }

    @Test
    public void testFlush001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Five);
        CardUnit card4 = new CardUnit(SUIT.Diamond, RANK.Jack);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Queen);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.FLUSH);
    }

    @Test
    public void testStraight001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card3 = new CardUnit(SUIT.Club, RANK.Five);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.STRAIGHT);
    }

    @Test
    public void testStraight002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card3 = new CardUnit(SUIT.Club, RANK.Five);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.STRAIGHT);
    }

    @Test
    public void testThreeOfAKind001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.THREE_OF_A_KIND);
    }

    @Test
    public void testThreeOfAKind002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.THREE_OF_A_KIND);
    }

    @Test
    public void testThreeOfAKind003() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Jack);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.THREE_OF_A_KIND);
    }

    @Test
    public void testTwoPair001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.TWO_PAIR);
    }

    @Test
    public void testTwoPair002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.TWO_PAIR);
    }

    @Test
    public void testTwoPair003() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Four);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Five);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.TWO_PAIR);
    }

    @Test
    public void testPair001() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Five);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.PAIR);
    }

    @Test
    public void testPair002() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Five);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.PAIR);
    }

    @Test
    public void testPair003() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Five);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.PAIR);
    }

    @Test
    public void testPair004() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Nine);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.PAIR);
    }

    @Test
    public void testHighCard() {
        CardUnit card1 = new CardUnit(SUIT.Diamond, RANK.Jack);
        CardUnit card2 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card3 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card4 = new CardUnit(SUIT.Spade, RANK.Nine);
        CardUnit card5 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardAdapter adapter = new CardAdapter();
        Best5Cards result = adapter.getResult(card1, card2, card3, card4, card5);
        assertEquals(result.handType, HandType.HIGH_CARD);
    }

    // test best 5 cards
    // difference hand type value
    @Test
    public void testBest5Cards001() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.One);
        CardUnit card23 = new CardUnit(SUIT.Spade, RANK.One);
        CardUnit card24 = new CardUnit(SUIT.Club, RANK.One);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Jack);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    // straight flush
    @Test
    public void testBest5Cards101() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card22 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card23 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertEquals(result, 0);
    }

    @Test
    public void testBest5Cards102() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card22 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card23 = new CardUnit(SUIT.Diamond, RANK.Three);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result < 0);
    }

    @Test
    public void testBest5Cards201() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Heart, RANK.One);
        CardUnit card13 = new CardUnit(SUIT.Club, RANK.One);
        CardUnit card14 = new CardUnit(SUIT.Spade, RANK.One);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.One);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.One);
        CardUnit card24 = new CardUnit(SUIT.Spade, RANK.One);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Four);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards202() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card14 = new CardUnit(SUIT.Spade, RANK.Queen);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Queen);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card24 = new CardUnit(SUIT.Spade, RANK.Five);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards203() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card14 = new CardUnit(SUIT.Spade, RANK.Queen);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Queen);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Eight);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Eight);
        CardUnit card24 = new CardUnit(SUIT.Spade, RANK.One);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    // flush
    @Test
    public void testBest5Cards301() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Diamond, RANK.Two);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Five);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Eight);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.King);
        CardUnit card22 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card23 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Nine);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards302() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Diamond, RANK.King);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Four);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Three);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card22 = new CardUnit(SUIT.Diamond, RANK.King);
        CardUnit card23 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Four);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    // straight
    @Test
    public void testBest5Cards401() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.King);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Queen);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Ten);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Jack);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Queen);
        CardUnit card22 = new CardUnit(SUIT.Diamond, RANK.King);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Jack);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Ten);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards402() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.King);
        CardUnit card13 = new CardUnit(SUIT.Diamond, RANK.Queen);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Ten);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Jack);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Queen);
        CardUnit card22 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Jack);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Ten);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    // three of a kind
    @Test
    public void testBest5Cards501() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Jack);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Queen);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Ten);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Eight);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards502() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Jack);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.Queen);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Eight);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Eight);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.One);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.King);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards503() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Ten);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.King);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.King);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Five);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    // two pair
    @Test
    public void testBest5Cards601() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.King);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Five);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Five);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards602() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.Jack);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards603() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Six);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.King);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Eight);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }
    // one pair

    @Test
    public void testBest5Cards701() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Seven);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.King);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Eight);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Eight);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards702() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Seven);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Six);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.King);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }

    @Test
    public void testBest5Cards703() {
        CardAdapter adapter = new CardAdapter();

        CardUnit card11 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card12 = new CardUnit(SUIT.Club, RANK.Nine);
        CardUnit card13 = new CardUnit(SUIT.Heart, RANK.Seven);
        CardUnit card14 = new CardUnit(SUIT.Diamond, RANK.Six);
        CardUnit card15 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result1 = adapter.getResult(card11, card12, card13, card14, card15);

        CardUnit card21 = new CardUnit(SUIT.Diamond, RANK.Nine);
        CardUnit card22 = new CardUnit(SUIT.Heart, RANK.Nine);
        CardUnit card23 = new CardUnit(SUIT.Club, RANK.Two);
        CardUnit card24 = new CardUnit(SUIT.Diamond, RANK.Seven);
        CardUnit card25 = new CardUnit(SUIT.Diamond, RANK.One);
        Best5Cards result2 = adapter.getResult(card21, card22, card23, card24, card25);

        int result = result1.compareTo(result2);
        assertTrue(result > 0);
    }
}
