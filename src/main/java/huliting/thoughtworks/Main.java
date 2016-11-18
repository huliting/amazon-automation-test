package huliting.thoughtworks;

import huliting.thoughtworks.scenario.Card;
import huliting.thoughtworks.util.CardFactory;
import huliting.thoughtworks.util.Report;

import java.util.List;

/**
 * Created on 11/18/16.
 */
public class Main {
    public static void main(String[] args) {
        List<Card> autoTestCards = CardFactory.getAllTestCards();
        autoTestCards.stream().forEach(Card::autoTest);
        Report.completeAndCreateReport();
    }
}
