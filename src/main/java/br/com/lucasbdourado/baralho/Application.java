package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.domain.*;

import java.util.List;
import java.util.Scanner;

public class Application {
    /*public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu(){
        boolean makedChoice = false;

        while (!makedChoice) {
            System.out.println("---------------------------");
            System.out.println("1 - Inciar Blackjack");

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
        Game game = Game.getGame();

        System.out.println("---------------------------");
        System.out.println("Informe quantos jogadores irão jogar a partida de Blackjack");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice <= 4) {
            for(int i=1; i<=choice; i++){
                Scanner scanner1 = new Scanner(System.in);

                System.out.println("Informe o nome do jogador " + i);

                String name = scanner1.nextLine();


                if(name.length() > 2){
                    Game.getGame();
                    game.addPlayer(new Player(name));
                }else{
                    System.out.println("Digite o nome corretamente");
                    i--;
                }
            }

            if (game.getPlayers().size() == choice){
                List<Player> jogadores = game.getPlayers();
                startGame(game.getPlayers());
            }
        } else {
            System.out.println("Não é possivel iniciar a partida com essa quantidade de jogadores!");
            playerSelection();
        }
    }

    public static void startGame(List<Player> players){

        System.out.println("---------------------------");
        System.out.println("-------- BlackJack --------");
        System.out.println("---------------------------");

        Deck deck = new Deck();
        Rules rules = new Rules();

        deck.shuffle();

        Dealer dealer = new Dealer("Dealer", deck);

        dealer.giveCardsForAllPlayers(players);

        for (Player player : players) {
            player.showCards();
            rules.checkCards(player, true);
            System.out.println("---------------------------");
        }

        dealer.showCards(true);

        for(int i=0; i<players.size(); i++){
            Player player = players.get(i);
            boolean canPlay = rules.checkCards(player, false);
            Scanner scanner = new Scanner(System.in);

            while(canPlay) {
                System.out.println("---------------------------");
                System.out.println("Vez do " + player.getName());
                System.out.println("1 - Pedir mais uma carta");
                System.out.println("2 - Parar / Desistir");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    dealer.giveCard(player);
                    player.showCards();
                    canPlay = rules.checkCards(player, true);
                } else if (choice == 2) {
                    System.out.println("Você parou");
                    canPlay = false;
                } else {
                    System.out.println("Opção errada!");
                }
            }
        }
        System.out.println("---------------------------");
        dealer.checkPlay();
    }*/
}