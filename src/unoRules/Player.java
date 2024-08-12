package unoRules;

import Cards.Card;
import Cards.CardEffect;

public class Player {
    private int score = 0;
    private String name;
    private Deck playerHand;
    public Player(String name) {
        this.name = name;
        this.playerHand = new Deck();
    }

    public void incrementScore(int score) {
        this.score = this.score + score;
    }
    public int getScore() {
        return score;
    }
    public void PrintPlayerHand(){
        for (int i = 0; i < playerHand.deckSize(); i++) {
            System.out.print("( "+ (1+i)+ " )" +playerHand.getCard(i)+",");
        }
        System.out.println();
    }
    public int getNumberOfCardsInHand(){
        return playerHand.deckSize();
    }
    public CardEffect playCard(Card card){
        return card.performAbility(card);
    }

    public String getName() {
        return name;
    }

    public Deck getPlayerHand() {
        return playerHand;
    }
}
