/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem.model;

import com.sotatek.locnguyen.pokertexasholdem.enums.HandType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuitran
 *
 */
public class Best5Cards implements Comparable<Best5Cards> {
    public List<CardUnit> cards;
    /** The list of advantage card. */
    public List<CardUnit> odds;
    /** The key card to get a win within same type of hand with others. */
    public CardUnit keyCard;

    public HandType handType;

    public Best5Cards() {
        this.cards = new ArrayList<>();
        this.odds = new ArrayList<>();
    }

    @Override
    public int compareTo(Best5Cards o) {
        if (o == null) {
            return 1;
        }
        if (this.handType.equals(o.handType)) {
            if (this.keyCard.equals(o.keyCard)) {
                for (int i = this.odds.size() - 1; i >= 0; i--) {
                    if (this.odds.get(i).equals(o.odds.get(i))) {
                        continue;
                    } else {
                        return this.odds.get(i).compareTo(o.odds.get(i));
                    }
                }
            } else {
                return this.keyCard.compareTo(o.keyCard);
            }
        } else {
            return this.handType.value.compareTo(o.handType.value);
        }
        return 0;
    }
}
