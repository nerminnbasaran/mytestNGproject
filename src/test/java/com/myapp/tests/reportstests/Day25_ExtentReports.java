package com.myapp.tests.reportstests;

import com.myapp.pages.OrangeHRMDashboardPage;
import com.myapp.pages.OrangeHRMLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Day25_ExtentReports {
    /*
    *How do you get reports?
      -GENERAL : I use Extent Report
      -SPECIFIC EXAMPLE 1: We have ExtentReportUtils.
                           It has reusable methods such as pass,info
                           I call them in my test cases
      -SPECIFIC EXAMPLE 2: I am able to capture screenshot with extent reports as well.
                           For example I created one extent reports methods that logs the message
                           and captures the screenshots
      -SPECIFIC EXAMPLE 2: Extent reports generates HTMT reports. I then upload those reports to the JIRA
                           Or I can share the reports with my team(Smoke test reports)
      *
     */

    @Test
    public void extentReportsTest() throws IOException {

        ExtentReportUtils.pass("Testing starts...");
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        OrangeHRMDashboardPage orangeHRMDashboardPage= new OrangeHRMDashboardPage();
//        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        ExtentReportUtils.pass("Going to the url..."+ConfigReader.getProperty("orange_app_url"));
        Driver.getDriver().get(ConfigReader.getProperty("orange_app_url"));

        ExtentReportUtils.pass("Entering username as Admin...");
        orangeHRMLoginPage.username.sendKeys("Admin");

        ExtentReportUtils.pass("Entering password as admin123");
        orangeHRMLoginPage.password.sendKeys("admin123");

        ExtentReportUtils.passAndCaptureScreenshot("Credentials are entered...");

        ExtentReportUtils.pass("Clicking on the submit button...");
        orangeHRMLoginPage.submitButton.click();

//      Verify the login is successful
        ExtentReportUtils.pass("Verifying the login");
        Assert.assertTrue(orangeHRMDashboardPage.profile.isDisplayed());

//        ExtentReportUtils.pass("Test is complete...");
        ExtentReportUtils.passAndCaptureScreenshot("Test is complete...");

        ExtentReportUtils.flush();//TO GENERATE THE REPORT

        Driver.closeDriver();
    }
}
