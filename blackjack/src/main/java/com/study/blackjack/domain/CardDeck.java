package com.study.blackjack.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class CardDeck {

    private List<Card> cards;

    private static final String[] PATTERNS = {"SPADE", "HEART", "DIAMOND", "CLUB"};
    private static final int CARD_COUNT = 13;

    // 전체 카드 생성 (52개)
    public CardDeck() {

        this.cards = this.generateCards();

    }

    public List<Card> generateCards() {

        cards = new LinkedList<>();

        for(String pattern : PATTERNS) {

            for(int i = 1; i <= CARD_COUNT; i++) {
                String denomination = this.numberToDenomination(i);
                Card card = new Card(pattern, denomination);

                cards.add(card);
            }
        }

        return cards;
    }

    public String numberToDenomination(int i) {

        if(i == 1) {
            return "A";
        } else if(i == 11) {
            return "J";
        } else if(i == 12) {
            return "Q";
        } else if (i == 13) {
            return "K";
        } else {
            return String.valueOf(i);
        }
    }

    public Card draw() {

        // 랜덤으로 숫자 뽑기
        Card selectedCard = getRandomCard();

        System.out.println("==================Result=================");
        System.out.println("selectedCard = " + selectedCard);
        System.out.println("==================Result=================");
        
        // selectedCard 삭제
        cards.remove(selectedCard);

        return selectedCard;
        }


    private Card getRandomCard() {

        // cards list 에서 index 0 ~ 51 중 랜덤으로 숫자 뽑기
        int size = cards.size();
        int select = (int)(Math.random()*size); // size = 52, 0 ~ 51 중 랜덤으로 숫자 출력해 준다.
        return cards.get(select);

    }


    // 전체 카드 출력하기
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for(Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public Card getCard() {
        return null;
    }
}
