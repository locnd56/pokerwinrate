/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

// TODO: Auto-generated Javadoc
/**
 * The Enum RANK.
 *
 * @author nuitran
 */
public enum RANK {

    /** The One. */
    One(14),
    /** The Two. */
    Two(2),
    /** The Three. */
    Three(3),
    /** The Four. */
    Four(4),
    /** The Five. */
    Five(5),
    /** The Six. */
    Six(6),
    /** The Seven. */
    Seven(7),
    /** The Eight. */
    Eight(8),
    /** The Nine. */
    Nine(9),
    /** The Ten. */
    Ten(10),
    /** The Jack. */
    Jack(11),
    /** The Queen. */
    Queen(12),
    /** The King. */
    King(13);

    /** The value. */
    public final Integer value;

    /** The Constant map. */
    private static final Map<Integer, RANK> map = new HashMap<>();

    static {
//        Stream.of(values()).forEach(item -> map.put(item.getValue(), item));
    }

    /**
     * Value of.
     *
     * @param itemId
     *            the item id
     * @return the hand type
     */
    public static RANK valueOf(final int itemId) {
        return map.get(itemId);
    }

    /**
     * Instantiates a new hand type.
     *
     * @param value
     *            the value
     */
    RANK(int value) {
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
