package huliting.thoughtworks.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created on 11/18/16.
 */
public final class Report {
    private static final String REPORT_FOLDER = "./test_reports/";
    private static final ExtentReports report = new ExtentReports(REPORT_FOLDER + "test-reports.html", true);

    private Report() {
    }

    public static ExtentReports reporter() {
        return report;
    }

    public static void completeAndCreateReport() {
        BrowserManager.closeBrowser();
        report.flush();
    }

    public static void takeErrorReport(ExtentTest extentTest, String screenPic) {
        extentTest.log(LogStatus.ERROR, "Error Snapshot : " + extentTest.addScreenCapture(screenPic));
        report.endTest(extentTest);
    }

    public static String takeScreenShot(WebDriver webDriver) {
        File screenCapture = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String filePath = REPORT_FOLDER + createRandomErrorPicName();
        File saveFile = new File(filePath);
        try {
            FileUtils.copyFile(screenCapture, saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return saveFile.getAbsolutePath();
    }

    private static String createRandomErrorPicName() {
        return "error-image-" + System.currentTimeMillis() + ".png";
    }
}
