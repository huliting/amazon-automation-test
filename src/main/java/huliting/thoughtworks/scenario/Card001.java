package huliting.thoughtworks.scenario;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import huliting.thoughtworks.util.BrowserManager;
import huliting.thoughtworks.util.Report;
import org.openqa.selenium.WebDriver;

/**
 * Created on 11/18/16.
 * 1.open amazon website
 * 2.search 软件测试
 * 3.except we can get 软件测试(原书第2版)
 */
public class Card001 implements Card {
    public void autoTest() {
        ExtentTest extentTest = Report.reporter().startTest("Card001", "Open amazon website and search '软件测试'");
        WebDriver webDriver = BrowserManager.getWebDriver();

        try {
            BrowserManager.maxBrowser();
            webDriver.get("https://www.amazon.cn/");
            extentTest.log(LogStatus.INFO, "Navigated to https://www.amazon.cn/");


            extentTest.log(LogStatus.PASS, "Card001 verified");
        } catch (Exception e) {
            String screenPic = Report.takeScreenShot(webDriver);
            Report.takeErrorReport(extentTest, screenPic);
        }

        Report.reporter().endTest(extentTest);
    }
}
