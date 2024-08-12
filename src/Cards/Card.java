package Cards;

import actionAbility.CardAbility;

import java.util.ArrayList;

public abstract class Card {
    private String color;
    private String value;
    private int score;
    private ArrayList<CardAbility> abilities = new ArrayList<>();


    public Card(String color, String value, int score) {
        this.color = color;
        this.value = value;
        this.score = score;
    }

    public void setAbility(CardAbility ability) {
        this.abilities.add(ability);
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return color + "-" + value ;
    }


    public CardEffect  performAbility(Card card) {
        CardEffect result = new CardEffect();
        for (CardAbility ability : abilities) {
            CardEffect temp = ability.act(card);
            result = result.combineEffects(temp);
        }
        return result;
    }
}
