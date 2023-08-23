package br.com.lucasbdourado.baralho.views;

import br.com.lucasbdourado.baralho.controller.GameController;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class GameView {
    @FXML
    private BorderPane gameTable;

    @FXML
    private BorderPane window;

    GameController gameController = new GameController();

    @FXML
    public BorderPane start() {
        window = new BorderPane();

        MenuBar menuBar = mountMenuBar();

        gameTable = new BorderPane();

        window.setTop(menuBar);
        window.setCenter(gameTable);

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
            gameController.startGame(gameTable);
        });

        return menuBar;
    }
}
