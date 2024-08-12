package actionAbility;


import Cards.Card;
import Cards.CardEffect;

public interface CardAbility {
    CardEffect act(Card card);
}
