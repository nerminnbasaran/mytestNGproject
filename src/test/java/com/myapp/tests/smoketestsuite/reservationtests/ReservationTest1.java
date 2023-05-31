package com.myapp.tests.smoketestsuite.reservationtests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class ReservationTest1 {

    @Test
    public void reservationTest01(){

        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage.loginLink.click();

//        As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
        rentalLoginPage.userEmail.sendKeys("jack");

//        Error Message: email must be a valid email
        ReusableMethods.verifyExpectedAndActualTextMatch("email must be a valid email",rentalLoginPage.invalidEmailMessage);

//        When I enter a valid email domain, then I should not see the error message

//        https://email-verify.my-addr.com/list-of-most-popular-email-domains.php
    }
}
