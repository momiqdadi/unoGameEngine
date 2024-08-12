package unoRules;


import Cards.Card;
import Cards.CardEffect;

import java.util.ArrayList;
import java.util.Scanner;

public class Round {

    private Deck discardPile = new Deck();
    private Deck drawPile = new Deck();
    private Card lastCard;
    private boolean roundActive = true;
    private boolean gameDirection = true;
    private int currentPlayerPos ;
    private int roundScore = 0;
    private Player roundWinner ;
    private ArrayList<Player> players;
    private String validColor;
    private String validValue;

    private void setValidColor(String validColor) {
        this.validColor = validColor;
    }

    private void setValidValue(String validValue) {
        this.validValue = validValue;
    }

    public Round(ArrayList<Player> players) {
        this.players = players;
    }
    private boolean isLegalPlay(Card playedCard, String vcolor , String vvalue) {

        if (playedCard.getColor().equals( vcolor) || playedCard.getValue().equals(vvalue )|| playedCard.getColor().equals("Wild" )){
            return true;
        }
        else return false;
    }

    private void applyEffect(CardEffect cardEffect){


            
        if (!cardEffect.getColor().equals("Nothing")&& !cardEffect.getColor().equals(validColor)){
            validColor = cardEffect.getColor();
            System.out.println("color changed to :"+validColor);
        }
        if (cardEffect.isSkippable()){
            currentPlayerPos = getNextTurn();
            System.out.println("SKIPPED!");
        }
        if (cardEffect.isReversible()){
            gameDirection ^= true;
            System.out.println("REVERSED THE GAME DIRECTION!");
        }
        if (cardEffect.getNumOfDraws() > 0){
            drawPile.drawCardsTo(players.get(getNextTurn()).getPlayerHand(), cardEffect.getNumOfDraws());
            System.out.println("NEXT PLAYER HAS SOME NEW CARDS!");
        }
    }

    private int getNextTurn(){
        if (gameDirection == true){
        return  (currentPlayerPos + 1) % players.size();
    } else {
            if (currentPlayerPos <= 0){
                return players.size() - 1;}
            else
                return  (currentPlayerPos - 1) % players.size();
        }
    }
    public void playRound(){
        System.out.println("\n \n NEW ROUND!!!");
        Scanner scan = new Scanner(System.in);
        spreadCards(7);
        lastCard = discardPile.getCard(discardPile.deckSize()-1);
        System.out.print("the first card on Ground is:\n");
        System.out.println(lastCard.toString());
        validColor = lastCard.getColor() ;
        validValue = lastCard.getValue() ;
        currentPlayerPos = 0;
        boolean didDrawCard = false;
        while(roundActive) {
            Player currentPlayer = players.get(currentPlayerPos);

            System.out.println("------ " + currentPlayer.getName() + "'s turn! \nValid color and value are  = " + validColor + " - "+ validValue);
            System.out.println("Choose a number from your hand or ( 0 ) if you don't have cards to play: ");
            currentPlayer.PrintPlayerHand();

            int playedCard = scan.nextInt() -1;
            if (playedCard + 1 == 0 && didDrawCard == false){
                drawPile.drawCardsTo(currentPlayer.getPlayerHand(),1);
                System.out.println("You got a new Card from the Draw plie!");
                didDrawCard = true;
                continue;
            }
            else if(playedCard >= 0 && playedCard < currentPlayer.getNumberOfCardsInHand()){
            if(isLegalPlay(currentPlayer.getPlayerHand().getCard(playedCard),validColor,validValue)) {
                CardEffect cardEffect = currentPlayer.playCard(currentPlayer.getPlayerHand().getCard(playedCard));
                discardPile.addCardToDeck(currentPlayer.getPlayerHand().getCard(playedCard));
                setValidColor(discardPile.getCard(discardPile.deckSize() - 1).getColor());
                setValidValue(discardPile.getCard(discardPile.deckSize() - 1).getValue());
                currentPlayer.getPlayerHand().removeCardFromDeck(playedCard);
                applyEffect(cardEffect);
                if (currentPlayer.getNumberOfCardsInHand()==1){
                    System.out.println(currentPlayer.getName()+" Says UNO!!");
                } else if (currentPlayer.getNumberOfCardsInHand()==0) {
                    System.out.println(currentPlayer.getName()+" is The WINNER");
                    roundWinner = currentPlayer;
                    break;
                }
                currentPlayerPos = getNextTurn();
                didDrawCard = false;
            }
            else System.out.println("Play a Valid Card");
        }
            else {
                System.out.println("Player passed!");
                currentPlayerPos = getNextTurn();
                didDrawCard = false;
        }
            if(drawPile.deckSize() <= 5 ){
                discardPile.shuffle();
                drawPile = discardPile;
                discardPile= new Deck();

            }
        }
        sumScore();
        System.out.println("Round Score = " + roundScore +" winner score = "+roundWinner.getScore());

    }

    private void spreadCards(int numForEach){
        drawPile.initDeck();
        drawPile.shuffle();
        for (Player player: players) {
            drawPile.drawCardsTo(player.getPlayerHand(),numForEach);
        }
        drawPile.drawCardsTo(discardPile,1);


    }
    private void sumScore(){
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.get(i).getNumberOfCardsInHand() ; j++) {
                roundScore = roundScore + players.get(i).getPlayerHand().getDeck().get(j).getScore();
            }
        }
        roundWinner.incrementScore(roundScore);
    }


}
