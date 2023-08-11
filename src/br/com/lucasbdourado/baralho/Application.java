package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Jogador> jogadores = new ArrayList<>();

        Deck deck = new Deck();
        Rules rules = new Rules();

        deck.shuffle();

        Dealer dealer = new Dealer("Dealer", deck);

        jogadores.add(new Jogador("Lucas"));
        jogadores.add(new Jogador("Dourado"));

        for (int i=0; i<2; i++) {
            for (Jogador jogador : jogadores) {
                dealer.giveCard(jogador);
            }
            dealer.addCard();
        }

        for (Jogador jogador : jogadores) {
            System.out.print(jogador.getName() + ": ");
            for (Card card: jogador.getCards()) {
                System.out.print(card.getNumber() + card.getSuit() + " ");
            }
            rules.checkCards(jogador);
            System.out.println("\n---------------------------");

        }
        System.out.print(dealer.getName() + ": " + dealer.getCards().get(0).getNumber() + dealer.getCards().get(0).getSuit() + " ");
    }
}