package com.sotatek.locnguyen.pokertexasholdem;

import com.sotatek.locnguyen.pokertexasholdem.interfaces.IPlayer;
import com.sotatek.locnguyen.pokertexasholdem.model.Card;
import com.sotatek.locnguyen.pokertexasholdem.model.Deck;
import com.sotatek.locnguyen.pokertexasholdem.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by locnguyen on 16/11/2016.
 */
public class GameExecuter {

    public static void main(String[] args) {
        getStatsSimple();
    }

    List<Player> players;
    Game game;

    public GameExecuter() {
        game = new Game();
    }

    private static void getStatsSimple() {
        Game game = new Game();
        IPlayer player = new Player();
        IPlayer dealer = new Player();
        game.newGame(new Deck(), dealer, player);
        game.deal();
        game.callFlop();
        game.betTurn();
        game.betRiver();
        IPlayer winner = game.getWinner().get(0);
    }

    private List<Player> setPlayers(int numberPlayer) {
        players = new ArrayList<>();
        for (int i = 0; i < numberPlayer; i++) {
            IPlayer player = new Player();
            players.add((Player) player);
        }
        game.newGameInput(new Deck(), players);
        return players;
    }

    private boolean setCardForPlayer(Card... cards) {
        boolean isNormal = game.dealHanlder(cards);
        return isNormal;
    }

    private void setCardFlop(Card... cards) {
        game.callFlopCardInput(cards);
    }

    private void setCardTurn(Card card) {
        game.betTurnInput(card);
    }

    private void setCardRiver(Card card) {
        game.betRiverInput(card);
    }
}
