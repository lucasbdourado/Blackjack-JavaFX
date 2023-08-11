package br.com.lucasbdourado.baralho.domain;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Jogador{

    private Deck deck;
    private List<Card> cards = new ArrayList<>();
    private Integer index = 0;

    public Dealer(String name, Deck deck){
        super(name);
        this.deck = deck;
    }

    public void giveCard(Jogador jogador){
        Card card = deck.getCard();

        jogador.addCard(card);
    }

    public void addCard(){
        Card card = deck.getCard();

        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
