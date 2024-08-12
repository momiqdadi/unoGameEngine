package actionAbility;

import Cards.Card;
import Cards.CardEffect;

public class SkipPlayerAbility implements CardAbility {

    @Override
    public CardEffect act(Card card) {
        CardEffect cardEffect = new CardEffect();
        cardEffect.setSkippable(true);
        return cardEffect;
    }
}
