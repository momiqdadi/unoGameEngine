package Cards;

import actionAbility.ReverseAbility;

public class ReverseCard extends Card {
    public ReverseCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new ReverseAbility());
    }

    @Override
    public String toString() {
        return "reverseCard(" + super.toString() + ")";
    }


}
