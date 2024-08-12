package Cards;

import actionAbility.ChangeColorAbility;

public class WildCard extends Card {
    public WildCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new ChangeColorAbility());
    }

    @Override
    public String toString() {
        return "wildCard(" + super.toString() + ")";
    }


}