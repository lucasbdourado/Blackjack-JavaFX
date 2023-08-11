package br.com.lucasbdourado.baralho.domain;

import java.util.List;

public class Rules {

    private int winCondition = 21;

    public Rules(){}

    public int checkCards(Jogador jogador){
        int result = 0;

        for (Card card : jogador.getCards()) {
            result = result + card.getValue();
        }

        return result;
    }

}
