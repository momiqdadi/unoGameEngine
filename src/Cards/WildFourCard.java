package Cards;

import actionAbility.ChangeColorAbility;
import actionAbility.DrawCardsAbility;

public class WildFourCard extends Card {
    public WildFourCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new ChangeColorAbility());
        setAbility(new DrawCardsAbility());
    }

    @Override
    public String toString() {
        return "wildFourCard(" + super.toString() + ")";
    }


}