package br.com.lucasbdourado.baralho.domain;

import br.com.lucasbdourado.baralho.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

    private static Game game;
    private List<Player> players = new ArrayList<>();

    private Game(){

    }

    private void GameFactory(Game game){

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public static Game getGame() {
        if (game == null) {
            game = initGame();
        }

        return game;
    }

    private static Game initGame() {
        return new Game();
    }

    public void gameOver(){
        boolean makedchoice = false;

        while (!makedchoice){
            System.out.print("\n------------------------------\n");
            System.out.println("Escolha uma opção. \n1 - Jogar novamente com outros jogadores \n2 - Jogar novamente com os mesmos jogadores \n3 - Sair do jogo");
            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);
            int choice =  scanner.nextInt();

            if(choice == 1){
                makedchoice = true;
                game.close();
                Application.playerSelection();
            } else if (choice == 2) {
                makedchoice = true;
                for (Player player : getPlayers()) {
                    player.removeAllCards();
                }

                Application.startGame(players);
            } else if (choice == 3) {
                makedchoice = true;
            }
        }
    }

    private void close() {
        players.clear();
        Game game = null;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
