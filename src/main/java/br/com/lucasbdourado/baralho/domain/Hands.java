package br.com.lucasbdourado.baralho.domain;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Hands {

    @FXML
    private VBox table;
    @FXML
    private Pane playerHands;

    public Hands(){
        this.table = new VBox();
        this.table.setAlignment(Pos.CENTER);
    }

    public Pane getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(Pane playerHands) {
        this.playerHands = playerHands;
        table.getChildren().add(this.playerHands);
    }

    public VBox getTable() {
        return table;
    }

    public void mountPlayer(String playerName,Integer cardsValue) {
        Label label = new Label(playerName + ": " + cardsValue);
        label.setTextFill(Color.WHITE);

        table.getChildren().add(label);
    }
}