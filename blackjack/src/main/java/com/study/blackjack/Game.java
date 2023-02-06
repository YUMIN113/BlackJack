package com.study.blackjack;

import com.study.blackjack.domain.CardDeck;
import com.study.blackjack.domain.Dealer;
import com.study.blackjack.domain.Gamer;
import com.study.blackjack.domain.Rule;

// 게임에 필요한 클래스들의 인스턴스 생성
public class Game {

    public void play() {

        System.out.println("========== BlackJack ==========");

        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
        System.out.print(cardDeck.toString());

        cardDeck.draw();


        System.out.println("========== Result ==========");

        System.out.print(cardDeck.toString());
    }
}
