package com.study.blackjack;

import com.study.blackjack.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 게임에 필요한 클래스들의 인스턴스 생성
public class Game {

    private static final int INIT_RECEIVE_CARD_COUNT = 2;

    public void play() throws IOException {

        System.out.println("========== BlackJack ==========");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();

        initPhase(cardDeck, gamer, dealer);
        playingPhase(br, cardDeck, gamer, dealer);

    }

    private void initPhase(CardDeck cardDeck,
                           Gamer gamer,
                           Dealer dealer) {

        System.out.println("처음 2장의 카드를 각자 뽑겠습니다.");

        for(int i = 0; i < INIT_RECEIVE_CARD_COUNT; i++) {

            Card selectedCardForGamer = cardDeck.draw();
            gamer.receiveCard(selectedCardForGamer);

            System.out.println("여기까지 gamer 카드 입니다.");

            Card selectedCardForDealer = cardDeck.draw();
            dealer.receiveCard(selectedCardForDealer);

            System.out.println("여기까지 dealer 카드 입니다.");
        }

    }

    private void playingPhase(BufferedReader br,
                              CardDeck cardDeck,
                              Gamer gamer,
                              Dealer dealer) throws IOException {

        String gamerInput;
        boolean isGamerTurn = false,
                isDealerTurn = false;

        while (true) {
            System.out.println("Gamer 님, 카드를 뽑겠습니까? 종료를 원하시면 0을 입력하세요.");
            gamerInput = br.readLine();

            if (gamerInput.equals("0")) {
                isGamerTurn = true;
            } else {
                Card selectedCardForGamer = cardDeck.draw();
                gamer.receiveCard(selectedCardForGamer);
            }

            if(dealer.getPointSum() >= 17) {

                if(isDealerTurn == true) {
                    System.out.println("Dealer 님, 이미 한 장의 카드를 받으셨습니다. 더이상 카드를 받을 수 없습니다.");
                } else {

                    isDealerTurn = true;
                    System.out.println("Dealer 님, 카드의 총 합이 17 이상입니다. 더이상 카드를 받을 수 없습니다.");
                }
            }
                if(isDealerTurn == false) {
                    System.out.println("Dealer 님, 한 장의 카드를 더 받으실 수 있습니다.");

                    Card selectedCardForDealer = cardDeck.draw();
                    dealer.receiveCard(selectedCardForDealer);
                    isDealerTurn = true;

                }
                
            if(isGamerTurn && isDealerTurn) {
                break;
            }
        }
    }
}
