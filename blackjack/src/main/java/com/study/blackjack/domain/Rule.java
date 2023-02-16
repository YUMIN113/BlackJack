package com.study.blackjack.domain;

import com.study.blackjack.PlayerType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Rule {

    private String winner;

    private static final int CRITERION_SCORE = 21;

    private int getScore(List<Card> cards) {

        int totalScore = cards.stream()
                .map(it -> it.getPoint())
                .reduce(0,(x, y) -> x + y);

        return totalScore;
    }

    public String getWinner(List<Player> players) {


        List<Card> cardsOfDealer = getCardsOfDealer(players);
        int totalScoreOfDealer = getScore(cardsOfDealer);

        List<Card> cardsOfGamer = getCardsOfGamer(players);
        int totalScoreOfGamer = getScore(cardsOfGamer);

        if(totalScoreOfDealer <= CRITERION_SCORE && totalScoreOfGamer <= CRITERION_SCORE) {

            winner = (totalScoreOfGamer > totalScoreOfDealer) ? "Gamer" : "Dealer";

        }

        if(totalScoreOfDealer == CRITERION_SCORE && totalScoreOfGamer == CRITERION_SCORE) {

            winner = "무승부";

        }

        if (totalScoreOfDealer > CRITERION_SCORE) {

            winner = "Gamer";

        }

        if (totalScoreOfGamer > CRITERION_SCORE) {

            winner = "Dealer";

        }

        return winner;
    }


    private static List<Card> getCardsOfDealer(List<Player> players) {
        return players.stream()
                .filter(it -> PlayerType.Dealer.equals(it.getPlayerType()))
                .map(Player::openCards)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<Card> getCardsOfGamer(List<Player> players) {
        return players.stream()
                .filter(it -> PlayerType.Gamer.equals(it.getPlayerType()))
                .map(Player::openCards)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
