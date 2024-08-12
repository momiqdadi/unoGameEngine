package Cards;


public class CardEffect {
    private String color;
    private int numOfDraws;
    private boolean reversible;
    private boolean skippable;

    public CardEffect() {
        this.color = "Nothing";
        this.numOfDraws = 0;
        this.reversible = false;
        this.skippable = false;
    }


    public CardEffect combineEffects(CardEffect cardEffect) {
        CardEffect result = new CardEffect();
        if (cardEffect.getColor().equals("Nothing")) result.setColor(this.getColor());
        else result.setColor(cardEffect.getColor());
        result.setNumOfDraws(this.numOfDraws + cardEffect.getNumOfDraws());
        result.setReversible(this.reversible || cardEffect.isReversible());
        result.setSkippable(this.skippable || cardEffect.isSkippable());
        return result;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumOfDraws() {
        return numOfDraws;
    }

    public void setNumOfDraws(int numOfDraws) {
        this.numOfDraws = numOfDraws;
    }

    public boolean isReversible() {
        return reversible;
    }

    public void setReversible(boolean reversible) {
        this.reversible = reversible;
    }

    public boolean isSkippable() {
        return skippable;
    }

    public void setSkippable(boolean skippable) {
        this.skippable = skippable;
    }
}
