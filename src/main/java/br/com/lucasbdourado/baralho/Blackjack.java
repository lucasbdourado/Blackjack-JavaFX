package br.com.lucasbdourado.baralho;

import br.com.lucasbdourado.baralho.controller.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Blackjack extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameController gameController = new GameController();

        BorderPane gamePane = gameController.loadPane();

        Scene scene = new Scene(gamePane, 1200, 700);
        stage.setTitle("Blackjack");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}