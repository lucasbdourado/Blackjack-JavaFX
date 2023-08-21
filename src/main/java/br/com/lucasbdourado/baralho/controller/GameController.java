package br.com.lucasbdourado.baralho.controller;

import br.com.lucasbdourado.baralho.domain.*;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;

public class GameController {

    @FXML
    private BorderPane gamePainel;

    @FXML
    private BorderPane window;

    @FXML
    public void startGame() {
        Game game = Game.getGame();
        game.setScreen(gamePainel);




        game.addPlayer(new Player("Ygor"));
        game.addPlayer(new Player("Zé Lutim"));
        game.addPlayer(new Player("Nego"));
        game.addPlayer(new Player("Jack"));

        gamePainel.setStyle("-fx-background-color: #009933");

        Deck deck = new Deck();
        Rules rules = new Rules();

        deck.shuffle();

        Dealer dealer = new Dealer("Dealer", deck);

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
    }

    public BorderPane loadPane(){
        window = new BorderPane();

        MenuBar menuBar = mountMenuBar();

        gamePainel = new BorderPane();

        window.setTop(menuBar);
        window.setCenter(gamePainel);

        return window;
    }

    private MenuBar mountMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu gameMenu = new Menu("Jogo");
        MenuItem newGame = new MenuItem("Novo Jogo");
        MenuItem exit = new MenuItem("Sair");

        Menu helpMenu = new Menu("Ajuda");
        MenuItem howToPlay = new MenuItem("Como Jogar");

        gameMenu.getItems().addAll(newGame, exit);
        helpMenu.getItems().add(howToPlay);

        menuBar.getMenus().addAll(gameMenu, helpMenu);

        newGame.setOnAction(event -> {
            startGame();
        });

        return menuBar;
    }
}
