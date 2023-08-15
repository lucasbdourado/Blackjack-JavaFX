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

    public void showCards(){
        for (Card card: this.getCards()) {
            System.out.print(card.getNumber() + card.getSuit() + " ");
        }
        System.out.println("\n---------------------------");
    }

    public void checkPlay(List<Jogador> jogadores){
        this.showCards();
        List<Integer> valores = new ArrayList<>();
        Integer bestHand = 0;


        for (Jogador jogador: jogadores) {
            int result = 0;
            for (Card card: jogador.getCards()) {
                result = result + card.getValue();
            }

            if(result > bestHand && result <= 21){
                bestHand = result;
            }

            valores.add(result);
        }

        System.out.println("Best Hand: " + bestHand);

        this.makePlay(valores, bestHand);
    }

    public void makePlay(List<Integer> hands, Integer bestHand){
        int result = 0;

        for (Card card: this.getCards()) {
            result = result + card.getValue();
        }

        System.out.println("Dealer Card: " + result);
        boolean needBuy = false;
        for (int hand : hands) {
            if(result < hand && hand < 21 && hand <= bestHand && result != bestHand){
                needBuy = true;
            }
        }

        this.endPlay(needBuy, hands, bestHand);
    }

    public void endPlay(boolean needBuy, List<Integer> hands, Integer bestHand){
        if(needBuy){
            this.addCard();
            this.showCards();
            this.makePlay(hands, bestHand);
        }
    }
}
