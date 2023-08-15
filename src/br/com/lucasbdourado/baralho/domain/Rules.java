package br.com.lucasbdourado.baralho.domain;

import java.util.List;

public class Rules {

    private int winCondition = 21;

    public Rules(){}

    public boolean checkCards(Jogador jogador){
        int result = 0;
        boolean canPlay = true;

        for (Card card : jogador.getCards()) {
            result = result + card.getValue();
        }

        System.out.print(result);

        int winner = checkWinCondition(result);

        if(winner > 0){
            canPlay = false;
        }

        return canPlay;
    }

    public int checkWinCondition(int result){
        int winner = 0;

        if(result == 21){
            winner = 1;
            System.out.println("\nDealer: Blackjack!!!");
        } else if (result > 21) {
            winner = 2;
            System.out.println("\nDealer: Você estourou!");
        }

        return winner;
    }

}
