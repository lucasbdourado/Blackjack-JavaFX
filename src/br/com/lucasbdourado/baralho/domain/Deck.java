/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/
package br.com.lucasbdourado.baralho.domain;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck(){

        // Paus
        cards.add(new Card("2", "♣", 2));
        cards.add(new Card("3", "♣", 3));
        cards.add(new Card("4", "♣", 4));
        cards.add(new Card("5", "♣", 5));
        cards.add(new Card("6", "♣", 6));
        cards.add(new Card("7", "♣", 7));
        cards.add(new Card("8", "♣", 8));
        cards.add(new Card("9", "♣", 9));
        cards.add(new Card("10", "♣", 10));
        cards.add(new Card("J", "♣", 10));
        cards.add(new Card("Q", "♣", 10));
        cards.add(new Card("K", "♣", 10));
        cards.add(new Card("A", "♣", 11));

        // Espadas
        cards.add(new Card("2", "♠", 2));
        cards.add(new Card("3", "♠", 3));
        cards.add(new Card("4", "♠", 4));
        cards.add(new Card("5", "♠", 5));
        cards.add(new Card("6", "♠", 6));
        cards.add(new Card("7", "♠", 7));
        cards.add(new Card("8", "♠", 8));
        cards.add(new Card("9", "♠", 9));
        cards.add(new Card("10", "♠", 10));
        cards.add(new Card("J", "♠", 10));
        cards.add(new Card("Q", "♠", 10));
        cards.add(new Card("K", "♠", 10));
        cards.add(new Card("A", "♠", 11));

        // Copas
        cards.add(new Card("2", "♥", 2));
        cards.add(new Card("3", "♥", 3));
        cards.add(new Card("4", "♥", 4));
        cards.add(new Card("5", "♥", 5));
        cards.add(new Card("6", "♥", 6));
        cards.add(new Card("7", "♥", 7));
        cards.add(new Card("8", "♥", 8));
        cards.add(new Card("9", "♥", 9));
        cards.add(new Card("10", "♥", 10));
        cards.add(new Card("J", "♥", 10));
        cards.add(new Card("Q", "♥", 10));
        cards.add(new Card("K", "♥", 10));
        cards.add(new Card("A", "♥", 11));

        // Ouros
        cards.add(new Card("2", "♦", 2));
        cards.add(new Card("3", "♦", 3));
        cards.add(new Card("4", "♦", 4));
        cards.add(new Card("5", "♦", 5));
        cards.add(new Card("6", "♦", 6));
        cards.add(new Card("7", "♦", 7));
        cards.add(new Card("8", "♦", 8));
        cards.add(new Card("9", "♦", 9));
        cards.add(new Card("10", "♦", 10));
        cards.add(new Card("J", "♦", 10));
        cards.add(new Card("Q", "♦", 10));
        cards.add(new Card("K", "♦", 10));
        cards.add(new Card("A", "♦", 11));
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void shuffle(){

        for(int i=0; i<cards.size(); i++){
            int random = (int) ((Math.random() * 52));

            Card oldCard = cards.get(i);
            Card newCard = cards.get(random);

            cards.set(i, newCard);
            cards.set(random, oldCard);
        }
    }
}
