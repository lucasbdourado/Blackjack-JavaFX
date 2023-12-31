/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/

package br.com.lucasbdourado.baralho.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> cards = new ArrayList<>();
    private Hands playerHand;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Hands getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hands playerHand) {
        this.playerHand = playerHand;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void showCards(){
        playerHand.getPlayerHands().getChildren().clear();

        for (Card card: cards) {
            card.show(playerHand.getPlayerHands());
        }

        playerHand.mountPlayer(name, getCardsValue());
    }

    public Integer getCardsValue(){
        int result = 0;

        for (Card card: cards) {
            result = result + card.getValue();
        }

        return result;
    }

    public void removeAllCards() {
        cards.clear();
    }

    public void setPlay() {
        playerHand.displayButtons();
    }
}
