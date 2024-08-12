package Cards;

import actionAbility.ChaneColorAbility;
import actionAbility.DrawCardsAbility;

public class WildFourCard extends Card {
    public WildFourCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new ChaneColorAbility());
        setAbility(new DrawCardsAbility());
    }

    @Override
    public String toString() {
        return "wildFourCard(" + super.toString() + ")";
    }


}