package com.myapp.tests.topics;

import com.myapp.pages.OrangeHRMDashboardPage;
import com.myapp.pages.OrangeHRMLoginPage;
import com.myapp.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day19_POM_Login {

//    Create a test case to login the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    using page object model

    @Test
    public void loginTest(){

    /*
        1. LOCATE PAGE OBJECTS IN PAGE CLASS
        2. CREATE PAGE OBJECTS AND CALL THOSE PAGE OBJECTS
    */
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        OrangeHRMDashboardPage orangeHRMDashboardPage = new OrangeHRMDashboardPage();
//        Driver.getDriver().get(ConfigReader.getProperty("orange_app_url"));
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        orangeHRMLoginPage.username.sendKeys("Admin");
        orangeHRMLoginPage.password.sendKeys("admin123");
        orangeHRMLoginPage.submitButton.click();

//        Verify the login is successful
        Assert.assertTrue(orangeHRMDashboardPage.profile.isDisplayed());

//        Then logout the application


//        Then verify log out is successful

    }
}
