package br.com.lucasbdourado.baralho.domain;

public class Rules {
    public Rules(){}

    public boolean checkCards(Player player, boolean displayMessage){
        boolean canPlay = true;
        int cardsValue = player.getCardsValue();

        if (cardsValue == 21) {
            canPlay = false;
            if(displayMessage) System.out.println("Blackjack!");
        } else if (cardsValue > 21) {
            canPlay = false;
            if(displayMessage) System.out.println("Estourou!");
        }

        return canPlay;
    }
}
