package Cards;

import actionAbility.SkipPlayerAbility;

public class SkipCard extends Card {
    public SkipCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new SkipPlayerAbility());
    }

    @Override
    public String toString() {
        return "skipCard(" + super.toString() + ")";
    }

}