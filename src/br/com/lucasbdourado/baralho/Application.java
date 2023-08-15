package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu(){
        boolean makedChoice = false;

        while (!makedChoice) {
            System.out.println("---------------------------");
            System.out.println("1 - Inciar jogo");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1) {
                makedChoice = true;
                playerSelection();
            } else {
                System.out.println("Opção errada!");
            }
        }
    }

    public static void playerSelection(){
        System.out.println("---------------------------");
        System.out.println("Informe quantos jogadores irão jogar a partida de Blackjack");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice <= 4) {
            List<Jogador> jogadores = new ArrayList<>();

            for(int i=1; i<=choice; i++){
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("Informe o nome do jogador " + i);

                String name = scanner1.nextLine();


                if(name.length() > 2){
                    jogadores.add(new Jogador(name));
                }else{
                    System.out.println("Digite o nome corretamente");
                    i--;
                }
            }

            if (jogadores.size() == choice){
                startGame(jogadores);
            }
        } else {
            System.out.println("Não é possivel iniciar a partida com essa quantidade de jogadores!");
            playerSelection();
        }
    }

    public static void startGame(List<Jogador> jogadores){

        System.out.println("\n---------------------------");
        System.out.println("-------- BlackJack --------");
        System.out.println("---------------------------");

        Deck deck = new Deck();
        Rules rules = new Rules();

        deck.shuffle();

        Dealer dealer = new Dealer("Dealer", deck);

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