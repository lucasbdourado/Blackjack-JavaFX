package br.com.lucasbdourado.baralho.domain;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.*;

public class Game {

    private static Game game;
    private List<Player> players = new ArrayList<>();

    private BorderPane screen;

    private Game(){

    }

    private void GameFactory(Game game){

    }

    public List<Player> getPlayers() {
        return players;
    }

    public BorderPane getScreen() {
        return screen;
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
                //Application.playerSelection();
            } else if (choice == 2) {
                makedchoice = true;
                for (Player player : getPlayers()) {
                    player.removeAllCards();
                }

                //Application.startGame(players);
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

        switch (players.size()) {
            case 1 -> {
                HBox playerHands = new HBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");

                Hands hands = new Hands();

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setBottom(hands.getTable());
            }
            case 2 -> {
                VBox playerHands = new VBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");

                Hands hands = new Hands();

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setRight(hands.getTable());

            }
            case 3 -> {
                HBox playerHands = new HBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");
                screen.setTop(playerHands);

                Hands hands = new Hands();

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setTop(hands.getTable());
            }
            case 4 -> {
                VBox playerHands = new VBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");

                Hands hands = new Hands();

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setLeft(hands.getTable());
            }
            default -> throw new IllegalStateException("Unexpected value: " + players.size());
        }
    }

    public void setScreen(BorderPane screen) {
        this.screen = screen;
    }
}
