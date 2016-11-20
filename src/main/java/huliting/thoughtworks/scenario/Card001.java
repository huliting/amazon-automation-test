package huliting.thoughtworks.scenario;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import huliting.thoughtworks.util.BrowserManager;
import huliting.thoughtworks.util.Report;
import huliting.thoughtworks.validators.pages.HomeValidator;
import huliting.thoughtworks.validators.pages.ShoppingCartValidator;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import static org.openqa.selenium.By.id;

/**
 * Created on 11/18/16.
 * 1.open amazon website
 * 2.searchAndGetResult 软件测试
 * 3.click 软件测试(原书第2版) navigate to the page
 * 4.click 加入购物车 at new page
 * 5.excepted 商品已加入购物车 appeared
 * 6.excepted book price is 20.40
 */
public class Card001 implements Card {
    private static final String keyWord = "软件测试";

    public void autoTest() {
        ExtentTest extentTest = Report.reporter().startTest("Card001", "Open amazon website and searchAndGetResult '" + keyWord + "'");

        try {
            BrowserManager.maxBrowser();

            BrowserManager.getWebDriver().get("https://www.amazon.cn/");
            extentTest.log(LogStatus.INFO, "Navigated to https://www.amazon.cn/");

            FluentWebElement resultElement = HomeValidator.searchAndGetResult(extentTest, keyWord, "软件测试(原书第2版)");

            resultElement.link().click();
            BrowserManager.switchToNewWindow("《软件测试(原书第2版)》 佩腾【摘要 书评 试读】图书");
            extentTest.log(LogStatus.INFO, "Navigated to '" + keyWord + "' page");

            BrowserManager.getFluentWebDriver()
                    .input(id(("add-to-cart-button"))).click();
            extentTest.log(LogStatus.INFO, "add product into shopping cart");

            ShoppingCartValidator.checkAddItemSuccessful(extentTest);
            ShoppingCartValidator.checkProductPriceCorrect(extentTest, "￥ 20.40");

            extentTest.log(LogStatus.PASS, "Card001 verified");
        } catch (Exception e) {
            String screenPic = Report.takeScreenShot(BrowserManager.getWebDriver());
            Report.takeErrorReport(extentTest, screenPic, e);
        }

        Report.reporter().endTest(extentTest);
    }
}
