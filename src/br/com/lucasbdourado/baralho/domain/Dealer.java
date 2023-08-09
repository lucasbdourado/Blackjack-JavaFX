package br.com.lucasbdourado.baralho.domain;

import java.util.List;

public class Dealer {

    private Deck deck;
    private Integer index = 0;

    public Dealer(Deck deck){
        this.deck = deck;
    }

    public void giveCard(Jogador jogador){
        Card card = deck.getCard();

        jogador.addCard(card);
    }
}
