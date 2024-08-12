package unoRules;

import Cards.Card;

import java.util.ArrayList;
import java.util.Collections;

import static Cards.CardFactory.makeCard;

public class Deck {
    private ArrayList<Card> deck;

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    public void addCardToDeck(Card newCard) {
        deck.add(newCard);
    }

    public void removeCardFromDeck(int index) {
        deck.remove(index);
    }

    public int deckSize() {
        return this.deck.size();
    }

    public Card getCard(int index) {
        return deck.get(index);
    }


    public void drawCardsTo(Deck destenationDeck, int count) {
        for (int i = 0; i < count; i++) {
            destenationDeck.addCardToDeck(getCard(0));
            removeCardFromDeck(0);
        }
    }


    public void initDeck(){
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();


        //Add All Uno Colors
        colors.add("Red");colors.add("Yellow");colors.add("Green");colors.add("Blue");colors.add("Wild");
        //Add Values of Numbers 1-9
        values.add("Zero");values.add("One");values.add("Two");values.add("Three");values.add("Four");
        values.add("Five");values.add("Six");values.add("Seven");values.add("Eight");values.add("Nine");
        //Add Values of specialty cards
        values.add("Skip");values.add("Reverse"); values.add("DrawTwo");
        //Add Values of wild cards
        values.add("Wild");values.add("WildFour");

        for (int i = 0; i < colors.size() - 1 ; i++) {
            addCardToDeck(makeCard("Number",colors.get(i), values.get(0), 0));
        }
        for (int i = 0; i < colors.size() - 1 ; i++) {
            for (int j =1; j < values.size()-5; j++) {
                addCardToDeck(makeCard("Number",colors.get(i), values.get(j), j));
                addCardToDeck(makeCard("Number",colors.get(i), values.get(j), j));
            }
        }
        for (int i = 0; i < colors.size() - 1 ; i++) {
            addCardToDeck(makeCard("Skip",colors.get(i), values.get(10), 20));
            addCardToDeck(makeCard("Skip",colors.get(i), values.get(10), 20));
        }
        for (int i = 0; i < colors.size() - 1 ; i++) {
            addCardToDeck(makeCard("Reverse",colors.get(i), values.get(11), 20));
            addCardToDeck(makeCard("Reverse",colors.get(i), values.get(11), 20));
        }
        for (int i = 0; i < colors.size() - 1 ; i++) {
            addCardToDeck(makeCard("DrawTwo",colors.get(i), values.get(12), 20));
            addCardToDeck(makeCard("DrawTwo",colors.get(i), values.get(12), 20));
        }
        for (int i = 1; i < 5 ; i++) {
            addCardToDeck(makeCard("Wild",colors.get(colors.size()-1), values.get(13),50));
        }
        for (int i = 1; i < 5 ; i++) {
            addCardToDeck(makeCard("WildFour",colors.get(colors.size()-1), values.get(14),50));
        }

    }


}

