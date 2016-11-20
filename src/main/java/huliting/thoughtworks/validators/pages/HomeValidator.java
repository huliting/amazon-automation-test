package huliting.thoughtworks.validators.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import huliting.thoughtworks.util.BrowserManager;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;
import org.seleniumhq.selenium.fluent.Period;

import static org.openqa.selenium.By.*;
import static org.seleniumhq.selenium.fluent.Period.secs;

/**
 * Created on 11/18/16.
 */
public class HomeValidator {
    private static final Period WAITING_TIME = secs(30);

    public static FluentWebElement searchAndGetResult(ExtentTest extentTest, String keyWord, String itemName) {
        BrowserManager.getFluentWebDriver()
                .input(id("twotabsearchtextbox"))
                .sendKeys(keyWord);
        extentTest.log(LogStatus.INFO, "input search key word '" + keyWord + "'");

        BrowserManager.getFluentWebDriver()
                .div(className("nav-search-submit nav-sprite"))
                .input(className("nav-input"))
                .click();
        extentTest.log(LogStatus.INFO, "click search button");

        FluentWebElements resultList = BrowserManager.getFluentWebDriver()
                .within(WAITING_TIME)
                .ul(id("s-results-list-atf"))
                .lis();

        return resultList.first((webElement, ix) -> webElement.has().link(linkText(itemName)));
    }
}
