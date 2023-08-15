package br.com.lucasbdourado.baralho.domain;

import br.com.lucasbdourado.baralho.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        this.makePlay(valores, bestHand, jogadores);
    }

    public void makePlay(List<Integer> hands, Integer bestHand, List<Jogador> jogadores){
        int result = 0;

        for (Card card: this.getCards()) {
            result = result + card.getValue();
        }

        System.out.println("Dealer Cards: " + result);
        boolean needBuy = false;
        for (int hand : hands) {
            if(result < hand && hand < 21 && hand <= bestHand && result != bestHand){
                needBuy = true;
            }
        }

        this.endPlay(needBuy, hands, bestHand, jogadores);
    }

    public void endPlay(boolean needBuy, List<Integer> hands, Integer bestHand, List<Jogador> jogadores){
        if(needBuy){
            this.addCard();
            this.showCards();
            this.makePlay(hands, bestHand, jogadores);
        }else{
            this.endGame(jogadores);
        }
    }

    public void endGame(List<Jogador> jogadores){
        List<Jogador> winners = new ArrayList<>();
        Rules rules = new Rules();

        int dealerHands = 0;

        for (Card card: this.getCards()) {
            dealerHands = dealerHands + card.getValue();
        }

        this.showCards();
        System.out.println("Dealer Cards: " + dealerHands);

        for (Jogador jogador: jogadores) {
            int result = 0;

            System.out.print(jogador.getName() + ": ");
            for (Card card: jogador.getCards()) {
                result = result + card.getValue();
                System.out.print(card.getNumber() + card.getSuit() + " ");
            }

            if(result > dealerHands && result <= 21 || dealerHands > 21 && result <= 21){
                winners.add(jogador);
            }

            int playerHands = 0;

            for (Card card : jogador.getCards()) {
                playerHands = playerHands + card.getValue();
            }

            System.out.print(playerHands + "\n");
        }


        if(winners.size() > 0){
            System.out.println("O(s) vencedor(es) são: ");
            for (Jogador jogador: winners) {
                System.out.println(jogador.getName());
            }
        }else{
            System.out.println("\n");
            System.out.println("O dealer ganhou a partida!");
        }

        boolean makedchoice = false;

        while (!makedchoice){
            System.out.print("\n------------------------------\n");
            System.out.println("Escolha uma opção. \n1 - Jogar novamente com outros jogadores \n2 - Jogar novamente com os mesmos jogadores \n3 - Sair do jogo");
            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);
            int choice =  scanner.nextInt();

            if(choice == 1){
                makedchoice = true;
                Application.mainMenu();
            } else if (choice == 2) {
                for (Jogador jogador: jogadores) {
                    jogador.removeAllCards();
                }

                Application.startGame(jogadores);

                makedchoice = true;
            } else if (choice == 3) {
                makedchoice = true;
            }
        }


    }
}
