package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class Day20_PositiveLogin {

    @Test
    public void US100201_Admin_Login(){

//        As admin, I should be able to log in the application
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();

//        https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();

//        Admin email: jack@gmail.com
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");

//        Admin password: 12345
        rentalLoginPage.userPassword.sendKeys("12345");

//        Click login button
        rentalLoginPage.loginButton.click();

//        Verify login is successful
        ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);

        Driver.closeDriver();

    }
}
