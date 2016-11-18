package huliting.thoughtworks.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

/**
 * Created on 11/18/16.
 */
public final class Report {
    private static final ExtentReports report = new ExtentReports("./test-reports.html", false);

    private Report() {
    }

    public static ExtentReports reporter() {
        return report;
    }

    public static void completeAndCreateReport() {
        report.flush();
    }

    public static void stopByErrorAndCreateReport(ExtentTest extentTest) {
        extentTest.log(LogStatus.ERROR, "Error Snapshot : " + extentTest.addScreenCapture(createRandomErrorPicName()));

        BrowserManager.closeBrowser();
        extentTest.log(LogStatus.INFO, "Browser closed");

        report.endTest(extentTest);
        report.flush();

        System.exit(-1);
    }

    private static String createRandomErrorPicName() {
        return "error-image-" + System.currentTimeMillis() + ".png";
    }
}
