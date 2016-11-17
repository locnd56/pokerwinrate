package com.sotatek.locnguyen.pokertexasholdem.interfaces;

import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardSuitEnum;
import com.sotatek.locnguyen.pokertexasholdem.model.Card;

/**
 * Created by locnguyen on 15/11/2016.
 */
public interface IDeck {
    public Card pop();

    public Card pop(CardSuitEnum suit, CardRankingEnum ranking);

    public Card popCard(Card card);
}
