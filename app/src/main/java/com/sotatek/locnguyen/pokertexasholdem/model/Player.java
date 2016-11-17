package com.sotatek.locnguyen.pokertexasholdem.model;

import com.sotatek.locnguyen.pokertexasholdem.enums.RankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.interfaces.IPlayer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by locnguyen on 14/11/2016.
 */
public class Player implements IPlayer, Serializable {

    private Card[] cards = new Card[2];
    private RankingEnum rankingEnum = null;
    private List<Card> rankingList = null;
    private Card highCard = null;

    @Override
    public Card[] getCards() {
        return cards;
    }

    @Override
    public List<Card> getRankingList() {
        return rankingList;
    }

    @Override
    public void setRankingList(List<Card> rankingList) {
        this.rankingList = rankingList;
    }

    @Override
    public RankingEnum getRankingEnum() {
        return rankingEnum;
    }

    @Override
    public void setRankingEnum(RankingEnum rankingEnum) {
        this.rankingEnum = rankingEnum;
    }

    @Override
    public Card getHighCard() {
        return highCard;
    }

    @Override
    public void setHighCard(Card highCard) {
        this.highCard = highCard;
    }
}
