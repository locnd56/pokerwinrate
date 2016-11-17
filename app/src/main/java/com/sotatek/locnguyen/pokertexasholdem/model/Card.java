package com.sotatek.locnguyen.pokertexasholdem.model;

import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardSuitEnum;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by locnguyen on 14/11/2016.
 */
public class Card implements Serializable {
    private CardSuitEnum suit;
    private CardRankingEnum rank;

    public Integer getRankToInt() {
        return rank.ordinal();
    }

    public Card(CardSuitEnum suit, CardRankingEnum rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CardSuitEnum getSuit() {
        return suit;
    }

    public void setSuit(CardSuitEnum suit) {
        this.suit = suit;
    }

    public CardRankingEnum getRank() {
        return rank;
    }

    public void setRank(CardRankingEnum rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Card)) {
            return false;
        } else {
            Card card2 = (Card) obj;
            return rank.equals(card2.getRank()) && suit.equals(card2.getSuit());
        }
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(String.valueOf(rank.ordinal()) + String.valueOf(suit.ordinal()));
    }

    @Override
    public String toString() {
        return "Suit: " + suit.toString() + ", Rank :" + rank.toString();
    }
}
