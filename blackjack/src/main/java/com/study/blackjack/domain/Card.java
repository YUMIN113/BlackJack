package com.study.blackjack.domain;

import lombok.Getter;

@Getter
public class Card {

    private String pattern;
    private String denomination;
    private int point;

    public Card(String pattern, int index) {
        this.pattern = pattern;
        this.denomination = this.numberToDenomination(index);
        this.point = this.numberToPoint(index);
    }


    // denomination 할당하기 위한 로직
    public String numberToDenomination(int number) {

        if(number == 1) {
            return "A";
        } else if(number == 11) {
            return "J";
        } else if(number == 12) {
            return "Q";
        } else if (number == 13) {
            return "K";
        } else {
            return String.valueOf(number);
        }
    }

    // K, Q, J 는 10 으로 처리하기 위한 로직
    private int numberToPoint(int number) {

        if(number >= 11) {
            return 10;
        }
        return number;

    }


    // 전체 카드 출력하기
    @Override
    public String toString() {
        return  "pattern = " + pattern +
                ", denomination = " + denomination;
    }
}
