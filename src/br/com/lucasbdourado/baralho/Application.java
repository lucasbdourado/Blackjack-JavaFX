package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.domain.Baralho;
import br.com.lucasbdourado.baralho.domain.Card;

public class Application {
    public static void main(String[] args) {

        Baralho baralho = new Baralho();

        baralho.shuffle();

        for (Card card: baralho.getCards()) {
            System.out.println(card.getNumber() + card.getSuit());
        }

    }
}