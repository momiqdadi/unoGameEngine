package gameCommands;

import unoRules.Player;
import unoRules.Round;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {
    private int score = 100;
    private ArrayList<Player> players ;
    private int numberOfPlayers;

    public void setScore(int score) {
        this.score = score;
    }

    public Game() {
    }
    private void inputNumberOfPlayers() {
        Scanner scan = new Scanner(System.in);
        int number;
        while (true){
            System.out.println("Enter the number of players (2 - 10): ");
            number = scan.nextInt();

            if (number < 2 || number > 10) {
                System.out.println("Invalid number of players, please enter a number between 2 - 10.");
            }
            else {
                break;
            }
        }
        System.out.println("We have : " + number + " Players!");
        numberOfPlayers = number;
    }
    private ArrayList<Player> initPlayers(){
        Scanner scan = new Scanner(System.in);
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers ; i++){
            System.out.println("Please enter player number "+(i+1)+" name: ");
            String name = scan.next();
            players.add(new Player(name));
        }
        System.out.print("Welcome! ");
        return players;
    }
    private boolean gameOn(ArrayList<Player> players){
        boolean gameOn = true;
        for (Player player : players) {
            if (player.getScore() > score){
                System.out.println("Game Winner Is: " + player.getName());

                gameOn = false;
            }
            else gameOn = true;
        }
        if (!gameOn){
            for (Player player : players) {
                System.out.println(player.getName() + " Score= " + player.getScore());

            }
        }
        return gameOn;

    }

    public void play(){
        inputNumberOfPlayers();
        players = initPlayers();
        while (gameOn(players)) {
            Round round = new Round(players);
            round.playRound();

        }
    }

}
