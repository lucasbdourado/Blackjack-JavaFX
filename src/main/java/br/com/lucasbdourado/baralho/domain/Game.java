/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/

package br.com.lucasbdourado.baralho.domain;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;

public class Game {

    private static Game game;
    private List<Player> players = new ArrayList<>();

    private Dealer dealer;

    @FXML
    private BorderPane screen;

    private int turn = 0;
    private Rules rules;

    private Game(){
        this.rules = new Rules();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public BorderPane getScreen() {
        return screen;
    }

    public Dealer getDealer() {
        return dealer;
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

                Hands hands = new Hands(player);

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setBottom(hands.getTable());
            }
            case 2 -> {
                VBox playerHands = new VBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");

                Hands hands = new Hands(player);

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setRight(hands.getTable());

            }
            case 3 -> {
                HBox playerHands = new HBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");
                screen.setTop(playerHands);

                Hands hands = new Hands(player);

                hands.setPlayerHands(playerHands);

                player.setPlayerHand(hands);

                screen.setTop(hands.getTable());
            }
            case 4 -> {
                VBox playerHands = new VBox(5);
                playerHands.setAlignment(Pos.CENTER);
                playerHands.setStyle("-fx-background-color: #009933");

                Hands hands = new Hands(player);

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

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void playersPlays() {
        if(turn >= players.size()){
            dealer.checkPlay();
            return;
        }

        Player player = players.get(turn);
        boolean canPlay = rules.checkCards(player);

        if(canPlay){
            player.setPlay();
        }
    }

    public void changeTurn() {
        turn++;
        playersPlays();
    }
}
