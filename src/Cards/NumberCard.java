package Cards;

import actionAbility.NoAbility;

public class NumberCard extends Card {
    public NumberCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new NoAbility());
    }

    @Override
    public String toString() {
        return "numberCard(" + super.toString() + ")";
    }

}
