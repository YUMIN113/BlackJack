package com.study.blackjack.domain;

import lombok.Getter;

@Getter
public class Card {

    private String pattern;
    private String denomination;

    public Card(String pattern, String denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
    }

    // 전체 카드 출력하기
    @Override
    public String toString() {
        return "Card : " + "pattern = " + pattern + ", denomination = " + denomination;
    }
}
