package actionAbility;

import Cards.Card;
import Cards.CardEffect;

public class NoAbility implements CardAbility {


    @Override
    public CardEffect act(Card card) {
        return new CardEffect();
    }
}
