package com.sotatek.locnguyen.pokertexasholdem.model;

import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardSuitEnum;
import com.sotatek.locnguyen.pokertexasholdem.interfaces.IDeck;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by locnguyen on 15/11/2016.
 */
public class Deck implements Serializable, IDeck {

    List<Card> cards;
    private Random random;

    public Deck() {
        this(new Random());
    }

    public Deck(Random random) {
        this.random = random;
        createDeck();
    }

    private void createDeck() {
        cards = new ArrayList<>();
        for (CardSuitEnum suit : CardSuitEnum.values()) {
            for (CardRankingEnum rank : CardRankingEnum.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    @Override
    public Card pop() {
        return cards.remove(random.nextInt(cards.size()));
    }

    @Override
    public Card pop(CardSuitEnum suit, CardRankingEnum ranking) {
        Card card = new Card(suit, ranking);
        cards.remove(card);
        return card;
    }

    @Override
    public Card popCard(Card card) {
        cards.remove(card);
        return card;
    }

}
