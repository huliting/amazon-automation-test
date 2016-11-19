package huliting.thoughtworks;

import huliting.thoughtworks.scenario.Card;
import huliting.thoughtworks.util.CardFactory;
import huliting.thoughtworks.util.Report;

import java.util.List;
import java.util.MissingFormatArgumentException;

/**
 * Created on 11/18/16.
 */
public class Main {
    public static void main(String[] args) {
        checkParameters(args);
        System.setProperty("webdriver.chrome.driver", args[0]);

        List<Card> autoTestCards = CardFactory.getAllTestCards();
        autoTestCards.stream().forEach(Card::autoTest);

        Report.completeAndCreateReport();
    }

    private static void checkParameters(String[] args) {
        if (args.length < 1) {
            throw new MissingFormatArgumentException("please append webDriver path");
        }
    }
}
