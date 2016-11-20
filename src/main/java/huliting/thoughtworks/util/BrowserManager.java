package huliting.thoughtworks.util;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

import java.util.Set;

/**
 * Created on 11/18/16.
 */
public final class BrowserManager {
    private static final WebDriver webDriver = new ChromeDriver();
    private static final FluentWebDriver fluentWebDriver = new FluentWebDriver(webDriver);

    private BrowserManager() {
    }

    public static void maxBrowser() {
        webDriver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static FluentWebDriver getFluentWebDriver() {
        return fluentWebDriver;
    }

    public static void switchToNewWindow(String windowTitle) {
        Set<String> windowHandles = webDriver.getWindowHandles();
        String currentWindowHandle = webDriver.getWindowHandle();

        boolean switchSuccess = false;
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                if (webDriver.getTitle().equals(windowTitle)) {
                    switchSuccess = true;
                    break;
                }
            }
        }

        if (!switchSuccess) {
            throw new InvalidArgumentException("window title not exist!");
        }
    }

    public static void closeBrowser() {
        webDriver.quit();
    }
}
