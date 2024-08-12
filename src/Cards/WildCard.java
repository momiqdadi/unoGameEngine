package Cards;

import actionAbility.ChaneColorAbility;

public class WildCard extends Card {
    public WildCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new ChaneColorAbility());
    }

    @Override
    public String toString() {
        return "wildCard(" + super.toString() + ")";
    }


}