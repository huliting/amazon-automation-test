package huliting.thoughtworks.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created on 11/18/16.
 */
public final class BrowserManager {
    private static final WebDriver webDriver = new ChromeDriver();

    private BrowserManager() {
    }

    public static void maxBrowser() {
        webDriver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void closeBrowser() {
        webDriver.quit();
    }
}
