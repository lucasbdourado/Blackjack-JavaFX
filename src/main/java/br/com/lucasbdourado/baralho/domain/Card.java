/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/
package br.com.lucasbdourado.baralho.domain;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card {
    private String number;
    private String suit;
    private Integer value;

    public Card(String number, String suit, int value){
        this.number = number;
        this.suit = suit;
        this.value = value;
    }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getSuit() { return suit; }

    public void setSuit(String suit) { this.suit = suit; }

    public Integer getValue() { return value; }

    public void setValue(Integer value) { this.value = value; }

    public void show(Pane position){
        Rectangle card = new Rectangle(45, 70, Color.WHITE);

        StackPane stackPane = new StackPane();

        Label label = new Label(number + suit);

        if(suit == "♥" || suit == "♦"){
            label.setTextFill(Color.RED);
        }

        stackPane.getChildren().addAll(card, label);

        position.getChildren().add(stackPane);
    }

    public void hide(Pane position){
        Rectangle card = new Rectangle(45, 70, Color.rgb(255, 135, 135, 1));

        position.getChildren().add(card);
    }
}
