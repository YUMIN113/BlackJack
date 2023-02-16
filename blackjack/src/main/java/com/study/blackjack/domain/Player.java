package com.study.blackjack.domain;

import com.study.blackjack.PlayerType;

import java.util.List;

public interface Player {

    String getName();

    void receiveCard(Card card);

    void showCards();

    List<Card> openCards();

    void turnOn();

    void turnOff();

    boolean isTurn();

    PlayerType getPlayerType();
}
