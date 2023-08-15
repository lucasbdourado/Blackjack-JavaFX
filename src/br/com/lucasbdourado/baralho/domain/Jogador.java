package br.com.lucasbdourado.baralho.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Jogador {

    private String name;
    private List<Card> cards = new ArrayList<>();

    public Jogador(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }
    public void removeAllCards(){
        getCards().removeAll(cards);
    }
}
