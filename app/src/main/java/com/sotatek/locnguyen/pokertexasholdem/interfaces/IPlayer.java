package com.sotatek.locnguyen.pokertexasholdem.interfaces;

import com.sotatek.locnguyen.pokertexasholdem.enums.RankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.model.Card;

import java.util.List;

/**
 * Created by locnguyen on 15/11/2016.
 */
public interface IPlayer {
    public Card[] getCards();

    public List<Card> getRankingList();

    public void setRankingList(List<Card> rankingList);

    public RankingEnum getRankingEnum();

    public void setRankingEnum(RankingEnum rankingEnum);

    public Card getHighCard();

    public void setHighCard(Card highCard);
}
