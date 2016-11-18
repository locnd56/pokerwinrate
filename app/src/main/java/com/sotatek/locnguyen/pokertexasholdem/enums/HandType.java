/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * The Enum HandType.
 *
 * @author nuitran
 */
public enum HandType {
    
    /** The high card. */
    HIGH_CARD(1),
    
    /** The pair. */
    PAIR(2),
    
    /** The two pair. */
    TWO_PAIR(3),
    
    /** The three of a kind. */
    THREE_OF_A_KIND(4),
    
    /** The straight. */
    STRAIGHT(5),
    
    /** The flush. */
    FLUSH(6),
    
    /** The full house. */
    FULL_HOUSE(7),
    
    /** The four of a kind. */
    FOUR_OF_A_KIND(8),
    
    /** The straight flush. */
    STRAIGHT_FLUSH(9);
    
    /** The value. */
    public final Integer value;
    
    /** The Constant map. */
    private static final Map<Integer, HandType> map = new HashMap<>();

    static {
        for (HandType handType : values()) {
            map.put(handType.getValue(), handType);
        }
    }
    
    /**
     * Value of.
     *
     * @param itemId the item id
     * @return the hand type
     */
    public static HandType valueOf(final int itemId) {
        return map.get(itemId);
    }
    
    /**
     * Instantiates a new hand type.
     *
     * @param value the value
     */
    HandType(int value) {
        this.value = value;
    }
    
    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }
}
