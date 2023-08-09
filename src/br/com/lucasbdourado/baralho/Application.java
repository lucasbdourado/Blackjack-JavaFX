package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.domain.Dealer;
import br.com.lucasbdourado.baralho.domain.Deck;
import br.com.lucasbdourado.baralho.domain.Card;
import br.com.lucasbdourado.baralho.domain.Jogador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {

        List<Jogador> jogadores = new ArrayList<>();

        Deck deck = new Deck();

        deck.shuffle();

        Dealer dealer = new Dealer(deck);

        jogadores.add(new Jogador("Lucas"));
        jogadores.add(new Jogador("Dourado"));

        for (int i=0; i<2; i++) {
            for (Jogador jogador : jogadores) {
                dealer.giveCard(jogador);
            }
        }

        for (Jogador jogador : jogadores) {
            System.out.print(jogador.getName() + ": ");
            for (Card card: jogador.getCards()) {
                System.out.print(card.getNumber() + card.getSuit() + " ");
            }
            System.out.println("\n---------------------------");
        }
    }
}