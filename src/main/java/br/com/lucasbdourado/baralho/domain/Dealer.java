/*
    @Author: Lucas Barbosa Dourado - lucasbdourado
*/

package br.com.lucasbdourado.baralho.domain;

import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player {
    private Deck deck;
    private List<Card> cards = new ArrayList<>();

    private Hands hands;

    public Dealer(String name, Deck deck){
        super(name);
        this.deck = deck;
    }

    public void giveCard(Player player){
        Card card = deck.getCard();

        player.addCard(card);
    }

    public void setPlayerHand(Hands hands) {
        this.hands = hands;
    }

    public void addCard(){
        Card card = deck.getCard();

        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }


    public void showCards(boolean showOnlyFirstCard) {
        hands.getPlayerHands().getChildren().clear();

        if(showOnlyFirstCard){
            cards.get(0).show(hands.getPlayerHands());
            cards.get(1).hide(hands.getPlayerHands());
            return;
        }

        for (Card card: cards) {
            card.show(hands.getPlayerHands());
        }

        hands.mountPlayer(this.getName(), getCardsValue());
    }

    public Integer getCardsValue() {
        int result = 0;

        for (Card card: cards) {
            result = result + card.getValue();
        }

        return result;
    }

    public void checkPlay(){
        Game game = Game.getGame();
        List<Player> players = game.getPlayers();
        int bestHand = 0;

        for (Player player : players) {
            int playerHands = player.getCardsValue();

            if(playerHands > bestHand && playerHands <= 21){
                bestHand = playerHands;
            }
        }

        System.out.println("Valor da melhor Mão: " + bestHand);

        this.makePlay(bestHand, players);
    }

    public void makePlay(Integer bestHand, List<Player> players){
        int dealerHand = this.getCardsValue();

        this.showCards(false);

        boolean needBuy = false;
        for (Player player : players) {
            int playerHand = player.getCardsValue();

            if(playerHand <= 21 && dealerHand < playerHand && playerHand <= bestHand){
                needBuy = true;
            }
        }

        this.endPlay(needBuy, bestHand, players);
    }

    public void endPlay(boolean needBuy, Integer bestHand, List<Player> players){
        if(needBuy){
            this.addCard();
            delay(2000, () -> this.makePlay(bestHand, players));
        }else{
            this.endGame(players);
        }
    }

    public void endGame(List<Player> players){
        Game game = Game.getGame();
        List<Player> winners = new ArrayList<>();

        int dealerHands = this.getCardsValue();

        for (Player player : players) {
            int playerHand = player.getCardsValue();

            if(playerHand > dealerHands && playerHand <= 21 || dealerHands > 21 && playerHand <= 21){
                winners.add(player);
            }
        }

        if(!winners.isEmpty()){
            System.out.println("O(s) vencedor(es) são: ");
            for (Player player : winners) {
                System.out.println(player.getName());
            }
        }else{
            System.out.println("O dealer ganhou a partida!");
        }

    }

    public void giveCardsForAllPlayers(List<Player> players) {
        for (int i=0; i<2; i++) {
            for (Player player : players) {
                this.giveCard(player);
            }
            this.addCard();
        }
    }

    public void setTable() {
        Game game = Game.getGame();

        HBox table = new HBox(5);

        table.setAlignment(Pos.CENTER);

        table.setStyle("-fx-background-color: #009933");

        Hands hands = new Hands(this);

        hands.setPlayerHands(table);

        setPlayerHand(hands);

        game.getScreen().setCenter(hands.getTable());
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
}
