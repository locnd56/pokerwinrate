/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author nuitran
 *
 */
public class Hand {
    public CardUnit card1;

    public CardUnit card2;

    public BigDecimal rate;

    public Double countBestHand;

    public BigDecimal splitRate;

    public Double countSplit;

    public Hand() {
    }

    /**
     * @param card1
     * @param card2
     */
    public Hand(CardUnit card1, CardUnit card2) {
        super();
        this.card1 = card1;
        this.card2 = card2;
        this.rate = BigDecimal.ZERO;
        this.rate.setScale(2, RoundingMode.HALF_UP);
        this.countBestHand = 0.0;
        this.countSplit = 0.0;
    }

    public void setRate(BigDecimal rate) {
        rate.setScale(0, RoundingMode.HALF_UP);
        this.rate = rate;
    }

    public void setSplit(BigDecimal split) {
        this.splitRate = split;
    }
}
