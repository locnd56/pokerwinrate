/**
 * 
 */
package com.sotatek.locnguyen.pokertexasholdem;

import com.sotatek.locnguyen.pokertexasholdem.adapter.CardAdapter;
import com.sotatek.locnguyen.pokertexasholdem.enums.RANK;
import com.sotatek.locnguyen.pokertexasholdem.enums.SUIT;
import com.sotatek.locnguyen.pokertexasholdem.model.CardUnit;

/**
 * @author nuitran
 *
 */
public class MainClazz {

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        CardAdapter adapter = new CardAdapter();
        adapter.createHand(1, new CardUnit(SUIT.Diamond, RANK.One), new CardUnit(SUIT.Diamond, RANK.Two));
        adapter.createHand(2, new CardUnit(SUIT.Diamond, RANK.Three), new CardUnit(SUIT.Diamond, RANK.Four));
        adapter.createHand(3, new CardUnit(SUIT.Diamond, RANK.Five), new CardUnit(SUIT.Diamond, RANK.Six));
//        adapter.createHand(4, new Card(SUIT.Diamond, RANK.Seven), new Card(SUIT.Diamond, RANK.Eight));
//        adapter.createHand(5, new Card(SUIT.Diamond, RANK.Nine), new Card(SUIT.Diamond, RANK.Ten));
//        adapter.createHand(6, new Card(SUIT.Diamond, RANK.Jack), new Card(SUIT.Diamond, RANK.Queen));
//        adapter.createHand(7, new Card(SUIT.Diamond, RANK.King), new Card(SUIT.Heart, RANK.One));
//        adapter.createHand(8, new Card(SUIT.Heart, RANK.Two), new Card(SUIT.Heart, RANK.Three));
//        adapter.createHand(9, new Card(SUIT.Heart, RANK.Four), new Card(SUIT.Heart, RANK.Five));
        adapter.flop(new CardUnit(SUIT.Spade, RANK.Queen), new CardUnit(SUIT.Heart, RANK.Queen), new CardUnit(SUIT.Club, RANK.Queen));
        adapter.calculateFlop();
        adapter.printResult();
        adapter.turn(new CardUnit(SUIT.Diamond, RANK.Queen));
        adapter.calculateTurn();
        adapter.printResult();
        adapter.river(new CardUnit(SUIT.Club, RANK.One));
        adapter.calculateRiver();
        adapter.printResult();
        long b = System.currentTimeMillis();
        System.out.println(Long.toString(b - a));
    }
}
