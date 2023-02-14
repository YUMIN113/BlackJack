package com.study.blackjack;

import com.study.blackjack.domain.*;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 게임에 필요한 클래스들의 인스턴스 생성
public class Game {

    private static final int INIT_RECEIVE_CARD_COUNT = 2;

    private static final String STOP_RECEIVE_CARD = "0";

    public void play() {

        System.out.println("========== BlackJack ==========");

        Scanner sc = new Scanner(System.in);

        List<Player> players = Arrays.asList(new Gamer("사용자1"), new Dealer());

        CardDeck cardDeck = new CardDeck();

        initPhase(cardDeck, players);
        List<Player> cardReceivePlayers = playingPhase(sc, cardDeck, players);


        Rule rule = new Rule();
        String winner = rule.getWinner(players);

        System.out.println("========== winner ==========");
        System.out.println("winner = " + winner + "입니다." );
        System.out.println("========== winner ==========");
    }

    private List<Player> initPhase(CardDeck cardDeck,
                           List<Player> players) {

        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");

        for(int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {

            for(Player player : players) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
            }
        }
        return players;
    }

    private List<Player> playingPhase(Scanner sc,
                              CardDeck cardDeck,
                              List<Player> players) {

        List<Player> cardReceivePlayers;

        while(true) {

            cardReceivePlayers = receiveCardAllPlayers(sc, cardDeck, players);

            if(isAllPlayerTurnOff(cardReceivePlayers)) {
                break;
            }
        }
        return cardReceivePlayers;
    }

    private List<Player> receiveCardAllPlayers(Scanner sc,
                                               CardDeck cardDeck,
                                               List<Player> players) {


        for(Player player : players) {
            if (isReceiveCard(sc)) {
                Card card = cardDeck.draw();
                player.receiveCard(card);
                player.turnOn();
            } else {
                player.turnOff();
            }
        }

        return players;
    }

    private boolean isAllPlayerTurnOff(List<Player> players) {
        for(Player player : players) {
            if(player.isTurn()) {
                return false;
            }
        }
        return true;
    }

    private boolean isReceiveCard(Scanner sc) {
        System.out.println("카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
        return !sc.nextLine().equals(STOP_RECEIVE_CARD); // 0 과 같지 않으면 true 리턴 함
    }
}


