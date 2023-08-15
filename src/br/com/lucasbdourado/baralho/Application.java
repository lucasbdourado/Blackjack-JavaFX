package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        System.out.println("\n---------------------------");
        int turnos = jogadores.size();

        for(int i=0; i<turnos; i++){
            Jogador jogador = jogadores.get(i);
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n---------------------------");
            System.out.println("Vez do " + jogador.getName());
            System.out.println("1 - Pedir mais uma carta");
            System.out.println("2 - Parar / Desistir");

            int choice = scanner.nextInt();
            boolean canPlay = true;

            if(choice == 1){
                dealer.giveCard(jogador);
                for (Card card: jogador.getCards()) {
                    System.out.print(card.getNumber() + card.getSuit() + " ");
                }
                canPlay = rules.checkCards(jogador);
                System.out.println("\n");
            }else if(choice == 2){
                System.out.println("Você parou");
                canPlay = false;
            }else{
                System.out.println("Opção errada!");
            }

            if(canPlay){i--;}
        }

        dealer.checkPlay(jogadores);
    }
}