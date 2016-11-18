/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem.model;

import com.sotatek.locnguyen.pokertexasholdem.enums.RANK;
import com.sotatek.locnguyen.pokertexasholdem.enums.SUIT;

/**
 * @author nuitran
 *
 */
public class CardUnit implements Comparable<CardUnit> {
    public SUIT suit;
    public RANK rank;

    public CardUnit() {
    }

    public CardUnit(SUIT suit, RANK rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CardUnit)) {
            return false;
        }
        return this.rank.value.equals(((CardUnit) obj).rank.value);
    }

    @Override
    public int compareTo(CardUnit o) {
        return this.rank.value.compareTo(o.rank.value);
    }

}
