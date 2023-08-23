/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/

package br.com.lucasbdourado.baralho.controller;

import br.com.lucasbdourado.baralho.domain.*;

import javafx.fxml.FXML;
import javafx.scene.layout.*;

public class GameController {
    @FXML
    public void startGame(BorderPane gameTable) {
        Game game = Game.getGame();
        game.setScreen(gameTable);

        game.addPlayer(new Player("Lucas"));
        game.addPlayer(new Player("Barbosa"));
        game.addPlayer(new Player("Dourado"));
        game.addPlayer(new Player("lucasbdourado"));

        gameTable.setStyle("-fx-background-color: #009933");

        Deck deck = new Deck();

        deck.shuffle();

        Dealer dealer = new Dealer("Dealer", deck);

        game.setDealer(dealer);

        dealer.setTable();

        for (int i=0; i<2; i++) {
            for (Player player: game.getPlayers()) {
                dealer.giveCard(player);
            }

            dealer.addCard();
        }

        for (Player player: game.getPlayers()) {
            player.showCards();
        }

        dealer.showCards(true);

        game.playersPlays();
    }
}
