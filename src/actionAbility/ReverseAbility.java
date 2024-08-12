package actionAbility;


import Cards.Card;
import Cards.CardEffect;

public class ReverseAbility implements CardAbility {


    @Override
    public CardEffect act(Card card) {
        CardEffect cardEffect = new CardEffect();
        cardEffect.setReversible(true);
        return cardEffect;

    }
}
