package com.study.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {

    private List<Card> cards;

    private static final int CAN_RECEIVE_POINT = 16;

    private boolean turn;

    public Dealer() {
        this.cards = new ArrayList<>();
    }

    @Override
    public void receiveCard(Card card) {


            if (this.isReceiveCard()) {
                this.cards.add(card);
                this.showCards();
            } else {
                System.out.println("카드의 총 합이 17 이상입니다. 더이상 카드를 받을 수 없습니다.");
                this.showCards();
            }
    }

    private boolean isReceiveCard() {
        return getPointSum() <= CAN_RECEIVE_POINT;
    }

    public int getPointSum() {

        int sum = 0;

        for(Card card : cards) {
            sum += card.getPoint();
        }

        return sum;

    }

    @Override
    public void showCards() {

        StringBuilder sb = new StringBuilder();
        sb.append("Dealer 님의 현재 보유 카드 목록" + "\n");

        for(Card card : cards) {

            sb.append(card);
            sb.append("\n");

        }

        System.out.println(sb.toString());
    }

    @Override
    public void turnOn() {
        this.setTurn(true);
    }

    @Override
    public void turnOff() {
        this.setTurn(false);
    }

    @Override
    public boolean isTurn() {
        return this.turn;
    }

    private void setTurn(boolean turn) {
        this.turn = turn;
    }

    @Override
    public List<Card> openCards() {
        return this.cards;
    }
}
