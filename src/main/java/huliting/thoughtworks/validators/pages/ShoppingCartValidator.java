package huliting.thoughtworks.validators.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import huliting.thoughtworks.util.BrowserManager;
import org.seleniumhq.selenium.fluent.Period;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.seleniumhq.selenium.fluent.Period.secs;

/**
 * Created by Victor Wang.
 * Created on 16/11/20 15:25
 */
public class ShoppingCartValidator {
    private static final Period WAITING_TIME = secs(30);

    public static void checkAddItemSuccessful(ExtentTest extentTest) {
        BrowserManager.getFluentWebDriver()
                .within(WAITING_TIME)
                .div(id("huc-v2-order-row-confirm-text"))
                .h1()
                .getText()
                .shouldBe("商品已加入购物车");

        extentTest.log(LogStatus.INFO, "add product into shopping cart successful");
    }

    public static void checkProductPriceCorrect(ExtentTest extentTest, String price) {
        BrowserManager.getFluentWebDriver()
                .div(id("hlb-subcart"))
                .span(className("a-color-price hlb-price a-inline-block a-text-bold"))
                .getText()
                .shouldBe(price);

        extentTest.log(LogStatus.INFO, "product price is correct");
    }
}
