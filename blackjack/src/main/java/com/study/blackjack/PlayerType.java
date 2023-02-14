package com.study.blackjack;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum PlayerType {

    Dealer("딜러"), Gamer("게이머");

    private String playerType;

    PlayerType(String playerType) {
        this.playerType = playerType;
    }
}
