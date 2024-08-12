package Cards;


import actionAbility.DrawCardsAbility;

public class DrawTwoCard extends Card {

    public DrawTwoCard(String color, String value, int score) {
        super(color, value, score);
        setAbility(new DrawCardsAbility());
    }

    @Override
    public String toString() {
        return "drawTwoCard(" + super.toString() + ")";
    }


}