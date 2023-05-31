package com.myapp.tests.smoketestsuite.logintests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class Day20_BadCredentials {

    @Test
    public void Day20_US413123_Bad_Credentials(){

        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();

//        As admin or customer, I should be able to see error message,
//        When I provide a correct email address BUT incorrect password in a pop up window
        rentalLoginPage.userEmail.sendKeys("jack@gmail.com");//correct email
        rentalLoginPage.userPassword.sendKeys("23435");//incorrect password
        rentalLoginPage.loginButton.click();

//        Error Message: Bad credentials
        ReusableMethods.verifyExpectedAndActualTextMatch("Bad credentials",rentalLoginPage.errorMessage_incorrectEmailAndPass);

        Driver.closeDriver();


    }
}
