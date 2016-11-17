package com.sotatek.locnguyen.pokertexasholdem.Utils;

import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardSuitEnum;
import com.sotatek.locnguyen.pokertexasholdem.enums.RankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.interfaces.IPlayer;
import com.sotatek.locnguyen.pokertexasholdem.model.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by locnguyen on 15/11/2016.
 */
public class RankingUtil {
    public RankingUtil() {
    }

    public static Integer getRankingToInt(IPlayer player) {
        return player.getRankingEnum().ordinal();
    }

    public static void checkRanking(IPlayer player, List<Card> tableCards) {
        //HIGH_CARD
        Card highCard = getHighCard(player, tableCards);
        player.setHighCard(highCard);

        //ROYAL_FLUSH
        List<Card> rankingList = getRoyalFlush(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.ROYAL_STRAIGHT_FLUSH, rankingList);
            return;
        }
        //STRAIGH_FLUSH
        rankingList = getStraightFlush(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.STRAIGHT_FLUSH, rankingList);
            return;
        }
        //FOUR_OF_A_KIND
        rankingList = getFourOfAKind(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.FOUR_OF_A_KIND, rankingList);
            return;
        }
        //FULL_HOUSE
        rankingList = getFullHouse(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.FULL_HOUSE, rankingList);
            return;
        }

        //FLUSH
        rankingList = getFlush(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.FLUSH, rankingList);
            return;
        }
        //STRAIGHT
        rankingList = getStraight(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.STRAIGHT, rankingList);
            return;
        }
        //THREE_OF_A_KIND
        rankingList = getThreeOfAKind(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.THREE_OF_A_KIND, rankingList);
            return;
        }
        //TWO_PAIR
        rankingList = getTwoPair(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.TWO_PAIR, rankingList);
            return;
        }
        //ONE_PAIR
        rankingList = getOnePair(player, tableCards);
        if (rankingList != null) {
            setRankingEnumAndList(player, RankingEnum.ONE_PAIR, rankingList);
            return;
        }
    }

    private static List<Card> getOnePair(IPlayer player, List<Card> tableCards) {
        List<Card> merged = getMergedCardList(player, tableCards);
        return checkPair(merged, 2);
    }

    private static List<Card> getTwoPair(IPlayer player, List<Card> tableCards) {
        List<Card> merged = getMergedCardList(player, tableCards);
        List<Card> twoPair1 = checkPair(merged, 2);
        if (twoPair1 != null) {
            merged.removeAll(twoPair1);
            List<Card> twoPair2 = checkPair(merged, 2);
            if (twoPair2 != null) {
                twoPair1.addAll(twoPair2);
                return twoPair1;
            }
        }
        return null;
    }

    private static List<Card> getThreeOfAKind(IPlayer player, List<Card> tableCards) {
        List<Card> merged = getMergedCardList(player, tableCards);
        return checkPair(merged, 3);
    }

    private static List<Card> getStraight(IPlayer player, List<Card> tableCards) {
        return getSequence(player, tableCards, 5, false);
    }

    private static List<Card> getFlush(IPlayer player, List<Card> tableCards) {
        List<Card> merged = getMergedCardList(player, tableCards);
        List<Card> flushList = new ArrayList<>();
        for (Card card1 : merged) {
            for (Card card2 : merged) {
                if (card1.getSuit().equals(card2.getSuit())) {
                    if (!flushList.contains(card1)) {
                        flushList.add(card1);
                    }
                    if (!flushList.contains(card2)) {
                        flushList.add(card2);
                    }
                }
            }
            if (flushList.size() == 5) {
                return flushList;
            }
            flushList.clear();
        }
        return null;
    }

    private static List<Card> getFullHouse(IPlayer player, List<Card> tableCards) {
        List<Card> merged = getMergedCardList(player, tableCards);
        List<Card> threeList = checkPair(merged, 3);
        if (threeList != null) {
            merged.removeAll(threeList);
            List<Card> twoList = checkPair(merged, 2);
            if (twoList != null) {
                threeList.addAll(twoList);
                return threeList;
            }
        }
        return null;
    }

    private static List<Card> getFourOfAKind(IPlayer player, List<Card> tableCards) {
        List<Card> merged = getMergedCardList(player, tableCards);
        return checkPair(merged, 4);
    }

    private static List<Card> checkPair(List<Card> merged, int pairSize) {
        List<Card> checkedPair = new ArrayList<>();
        for (Card card1 : merged) {
            checkedPair.add(card1);
            for (Card card2 : merged) {
                if (!card1.equals(card2) && card1.getRank().equals(card2.getRank())) {
                    checkedPair.add(card2);
                }
            }
            if (checkedPair.size() == pairSize) {
                return checkedPair;
            }
            checkedPair.clear();
        }
        return null;
    }

    private static void setRankingEnumAndList(IPlayer player, RankingEnum rankingEnum, List<Card> rankingList) {
        player.setRankingEnum(rankingEnum);
        player.setRankingList(rankingList);
    }

    private static List<Card> getRoyalFlush(IPlayer player, List<Card> tableCards) {
        if (!isSameSuit(player, tableCards)) {
            return null;
        }
        List<CardRankingEnum> rankEnumList = toRankEnumList(player, tableCards);
        if (rankEnumList.contains(CardRankingEnum.CARD_10)
                && rankEnumList.contains(CardRankingEnum.JACK)
                && rankEnumList.contains(CardRankingEnum.QUEEN)
                && rankEnumList.contains(CardRankingEnum.KING)
                && rankEnumList.contains(CardRankingEnum.ACE)) {
            return getMergedCardList(player, tableCards);
        }
        return null;
    }

    private static List<Card> getStraightFlush(IPlayer player, List<Card> tableCards) {
        return getSequence(player, tableCards, 5, true);
    }

    private static List<Card> getSequence(IPlayer player, List<Card> tableCards, int sequenceSize, boolean compareSuit) {
        List<Card> orderedList = getOrderedCardList(player, tableCards);
        List<Card> sequenceList = new ArrayList<>();

        Card cardPrevious = null;
        for (Card card : orderedList) {
            if (cardPrevious != null) {
                if ((card.getRankToInt() - cardPrevious.getRankToInt()) == 1) {
                    if (!compareSuit || cardPrevious.getSuit().equals(card.getSuit())) {
                        if (sequenceList.size() == 0) {
                            sequenceList.add(cardPrevious);
                        }
                        sequenceList.add(card);
                    } else {
                        if (sequenceList.size() == sequenceSize) {
                            return sequenceList;
                        }
                        sequenceList.clear();
                    }
                }
            }
            cardPrevious = card;
        }
        return (sequenceList.size() == sequenceSize) ? sequenceList : null;
    }

    private static List<Card> getOrderedCardList(IPlayer player, List<Card> tableCards) {
        List<Card> ordered = getMergedCardList(player, tableCards);
        Collections.sort(ordered, new Comparator<Card>() {
            @Override
            public int compare(Card card, Card c2) {
                return card.getRankToInt() < c2.getRankToInt() ? -1 : 1;
            }
        });
        return ordered;
    }

    private static List<Card> getMergedCardList(IPlayer player, List<Card> tableCards) {
        List<Card> merged = new ArrayList<>();
        merged.addAll(tableCards);
        merged.add(player.getCards()[0]);
        merged.add(player.getCards()[1]);
        return merged;
    }

    private static List<CardRankingEnum> toRankEnumList(IPlayer player, List<Card> tableCards) {
        List<CardRankingEnum> rankEnumList = new ArrayList<>();
        for (Card card : tableCards) {
            rankEnumList.add(card.getRank());
        }

        rankEnumList.add(player.getCards()[0].getRank());
        rankEnumList.add(player.getCards()[1].getRank());
        return rankEnumList;
    }

    private static boolean isSameSuit(IPlayer player, List<Card> tableCards) {
        //TODO need check why same suit with all card on table => need check 3/5

        CardSuitEnum suit = player.getCards()[0].getSuit();
        if (!suit.equals(player.getCards()[1].getSuit())) {
            return false;
        }
        for (Card card : tableCards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    public static Card getHighCard(IPlayer player, List<Card> tableCards) {
        List<Card> allCards = new ArrayList<>();
        allCards.addAll(tableCards);
        allCards.add(player.getCards()[0]);
        allCards.add(player.getCards()[1]);

        Card highCard = allCards.get(0);
        for (Card card : allCards) {
            if (card.getRankToInt() > highCard.getRankToInt()) {
                highCard = card;
            }
        }
        return highCard;
    }

}


