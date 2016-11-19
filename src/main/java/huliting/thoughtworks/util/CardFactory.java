package huliting.thoughtworks.util;

import huliting.thoughtworks.scenario.Card;
import huliting.thoughtworks.scenario.Card001;
import huliting.thoughtworks.scenario.Card002;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 11/18/16.
 */
public final class CardFactory {
    private CardFactory() {
    }

    public static List<Card> getAllTestCards() {
        List<Card> autoTestCards = new LinkedList<>();
        autoTestCards.add(new Card001());
        autoTestCards.add(new Card002());
        return autoTestCards;
    }
}
