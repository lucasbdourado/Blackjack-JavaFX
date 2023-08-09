/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/
package br.com.lucasbdourado.baralho.domain;

import java.util.ArrayList;
import java.util.List;

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

}
