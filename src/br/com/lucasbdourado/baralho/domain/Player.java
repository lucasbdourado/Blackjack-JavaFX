package br.com.lucasbdourado.baralho.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> cards = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void showCards(){
        int result = 0;

        System.out.print(name + ": ");
        for (Card card: cards) {
            System.out.print(card.getNumber() + card.getSuit() + " ");
            result = result + card.getValue();
        }

        System.out.println(result);
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
}
