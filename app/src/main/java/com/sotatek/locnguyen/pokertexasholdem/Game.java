package com.sotatek.locnguyen.pokertexasholdem;

import com.sotatek.locnguyen.pokertexasholdem.Utils.RankingUtil;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardRankingEnum;
import com.sotatek.locnguyen.pokertexasholdem.enums.CardSuitEnum;
import com.sotatek.locnguyen.pokertexasholdem.interfaces.IDeck;
import com.sotatek.locnguyen.pokertexasholdem.interfaces.IPlayer;
import com.sotatek.locnguyen.pokertexasholdem.model.Card;
import com.sotatek.locnguyen.pokertexasholdem.model.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by locnguyen on 15/11/2016.
 */
public class Game implements Serializable {
    private IDeck deck;
    private List<IPlayer> players;
    private List<Card> tableCards;

    public void newGame(IDeck deck, IPlayer player1, IPlayer... _player) {
        this.deck = deck;
        tableCards = new ArrayList<>();
        players = new ArrayList<>();
        players.add(player1);
        players.addAll(Arrays.asList(_player));
    }

    public void newGameInput(IDeck deck, List<Player> _player) {
        this.deck = deck;
        tableCards = new ArrayList<>();
        players = new ArrayList<>();
        players.addAll(_player);
    }

    public boolean dealHanlder(Card... cards) {
        int sumCards = cards.length;
        if (sumCards % 2 != 0 || sumCards == 0) {
            return false;
        } else {
            int quantity = (sumCards / 2);
            for (int i = 0; i < quantity; i++) {
                players.get(i).getCards()[0] = cards[i];
                players.get(i).getCards()[1] = cards[((i * 2) + 1)];
            }
            return true;
        }
    }

    public void deal() {
        for (IPlayer player : players) {
            player.getCards()[0] = deck.pop();
            player.getCards()[1] = deck.pop();
        }
        checkPlayerRanking();
    }

    public void callFlop() {
        //Burn
        deck.pop();
//        fakeCalleFlop();
        tableCards.add(deck.pop());
        tableCards.add(deck.pop());
        tableCards.add(deck.pop());
        checkPlayerRanking();
    }

    public void callFlopCardInput(Card... cards) {
        deck.pop();
        if ((cards.length % 2) != 0 || cards.length == 0) {
            return;
        }
        for (Card card : cards) {
            tableCards.add(deck.popCard(card));
        }
        checkPlayerRanking();
    }

    public void betTurn() {
        deck.pop();
        tableCards.add(deck.pop());
        checkPlayerRanking();
    }

    public void betTurnInput(Card card) {
        deck.pop();
        tableCards.add(deck.popCard(card));
        checkPlayerRanking();
    }

    public void betRiver() {
        deck.pop();
        tableCards.add(deck.pop());
        checkPlayerRanking();
    }

    public void betRiverInput(Card card) {
        deck.pop();
        tableCards.add(deck.popCard(card));
        checkPlayerRanking();
    }

    public List<IPlayer> getWinner() {
        checkPlayerRanking();
        List<IPlayer> winnerList = new ArrayList<>();
        IPlayer winner = players.get(0);
        Integer winnerRank = RankingUtil.getRankingToInt(winner);
        winnerList.add(winner);
        for (int i = 1; i < players.size(); i++) {
            IPlayer player = players.get(i);
            Integer playerRank = RankingUtil.getRankingToInt(player);
            //DrawGame
            if (winnerRank == playerRank) {
                IPlayer highHandPlayer = checkHighSequence(winner, player);
                if (highHandPlayer == null) {
                    highHandPlayer = checkHighCardWinner(winner, player);
                }
                if (highHandPlayer != null && !winner.equals(highHandPlayer)) {
                    winner = highHandPlayer;
                    winnerList.clear();
                    winnerList.add(winner);
                } else if (highHandPlayer == null) {
                    winnerList.add(winner);
                }
            } else if (winnerRank < playerRank) {
                winner = player;
                winnerList.clear();
                winnerList.add(winner);
            }
            winnerRank = RankingUtil.getRankingToInt(winner);
        }
        return winnerList;
    }

    private IPlayer checkHighCardWinner(IPlayer player1, IPlayer player2) {
        IPlayer winnner = compareHighCard(player1, player1.getHighCard(), player2, player2.getHighCard());
        if (winnner == null) {
            Card player1Card = RankingUtil.getHighCard(player1, Collections.EMPTY_LIST);
            Card player2Card = RankingUtil.getHighCard(player2, Collections.EMPTY_LIST);
            winnner = compareHighCard(player1, player1Card, player2, player2Card);
            if (winnner != null) {
                player1.setHighCard(player1Card);
                player2.setHighCard(player2Card);
            } else {
                player1Card = getSecondHighCard(player1, player1Card);
                player1Card = getSecondHighCard(player2, player2Card);
                winnner = compareHighCard(player1, player1Card, player2, player2Card);
                if (winnner != null) {
                    player1.setHighCard(player1Card);
                    player2.setHighCard(player2Card);
                }
            }
        }
        return winnner;
    }

    private Card getSecondHighCard(IPlayer player, Card playerCard) {
        if (player.getCards()[0].equals(playerCard)) {
            return player.getCards()[1];
        }
        return player.getCards()[0];
    }

    private IPlayer compareHighCard(IPlayer player1, Card highCard, IPlayer player2, Card highCard1) {
        if (highCard.getRankToInt() > highCard1.getRankToInt()) {
            return player1;
        } else if (highCard.getRankToInt() < highCard1.getRankToInt()) {
            return player2;
        }
        return null;
    }

    private IPlayer checkHighSequence(IPlayer winner, IPlayer player) {
        Integer player1Rank = sumRankingList(winner);
        Integer player2Rank = sumRankingList(player);
        if (player1Rank > player2Rank) {
            return winner;
        } else if (player2Rank > player1Rank) {
            return player;
        }
        return null;
    }

    private Integer sumRankingList(IPlayer player) {
        Integer sum = 0;
        for (Card card : player.getRankingList()) {
            sum += card.getRankToInt();
        }
        return sum;
    }

    private void checkPlayerRanking() {
        for (IPlayer player : players) {
            RankingUtil.checkRanking(player, tableCards);
        }
    }
}
