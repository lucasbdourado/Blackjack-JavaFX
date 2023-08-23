/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/

package br.com.lucasbdourado.baralho.domain;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Hands {

    @FXML
    private VBox table;
    @FXML
    private Pane playerHands;

    @FXML
    private Label handsLabel = new Label("");
    @FXML
    private HBox buttons;
    @FXML
    private Button cardButton;
    @FXML
    private Button stopButton;
    @FXML
    private boolean mounted = false;

    private Player player;

    public Hands(Player player){
        this.player = player;
        this.table = new VBox(5);
        this.table.setAlignment(Pos.CENTER);
    }

    public Pane getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(Pane playerHands) {
        this.playerHands = playerHands;

        buttons = new HBox(5);

        buttons.setVisible(false);
        buttons.setAlignment(Pos.CENTER);

        cardButton = new Button("Pedir Carta");
        stopButton = new Button("Parar / Desistir");

        cardButton.setOnAction(event -> {
            Game.getGame().getDealer().giveCard(player);

            player.showCards();

            Game.getGame().playersPlays();
        });

        stopButton.setOnAction(event -> {
            disableButtons();

            Game.getGame().changeTurn();
        });

        cardButton.setDisable(true);
        stopButton.setDisable(true);

        buttons.getChildren().addAll(cardButton, stopButton);

        table.getChildren().add(buttons);

        table.getChildren().add(this.playerHands);
    }

    public VBox getTable() {
        return table;
    }

    public void mountPlayer(String playerName,Integer cardsValue) {

        this.handsLabel.setText(playerName + ": " + cardsValue);
        this.handsLabel.setTextFill(Color.BLACK);

        if(!mounted) table.getChildren().add(this.handsLabel);

        this.mounted = true;
    }

    public void displayButtons() {
       buttons.setVisible(true);
       cardButton.setDisable(false);
       stopButton.setDisable(false);

    }

    public void disableButtons() {
        buttons.setVisible(false);
        cardButton.setDisable(true);
        stopButton.setDisable(true);
    }
}