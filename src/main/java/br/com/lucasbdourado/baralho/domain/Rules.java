/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/

package br.com.lucasbdourado.baralho.domain;

public class Rules {
    public Rules(){}

    public boolean checkCards(Player player){
        boolean canPlay = true;
        int cardsValue = player.getCardsValue();

        System.out.println(player.getName() + ": " + cardsValue);

        if (cardsValue == 21) {
            canPlay = false;
            player.getPlayerHand().disableButtons();
            Game.getGame().changeTurn();
        } else if (cardsValue > 21) {
            canPlay = false;
            player.getPlayerHand().disableButtons();
            Game.getGame().changeTurn();
        }

        return canPlay;
    }
}
