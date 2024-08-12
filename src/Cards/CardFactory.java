package Cards;

public interface CardFactory {

    public static Card makeCard(String choice, String color, String value, int score) {
        return switch (choice) {
            case "Number" -> new NumberCard(color, value, score);
            case "DrawTwo" -> new DrawTwoCard(color, value, score);
            case "Reverse" -> new ReverseCard(color, value, score);
            case "Skip" -> new SkipCard(color, value, score);
            case "Wild" -> new WildCard(color, value, score);
            case "WildFour" -> new WildFourCard(color, value, score);
            default -> null;
        };
    }
}
