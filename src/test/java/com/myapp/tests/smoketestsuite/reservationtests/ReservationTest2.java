package com.myapp.tests.smoketestsuite.reservationtests;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ReservationTest2 {
    @Test
    public void reservationTest2(){
        RentalHomePage rentalHomePage = new RentalHomePage();
        RentalLoginPage rentalLoginPage = new RentalLoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));


//        Given user is on the login page
//        And tries to book a car
        ReusableMethods.selectByVisibleText(rentalHomePage.carDropDown,"Maserati");
        rentalHomePage.pickUpLocation.sendKeys("Texas Dallas");
        rentalHomePage.dropOfLocation.sendKeys("Texas Dallas");
        rentalHomePage.pickUpDate.sendKeys("20052023");
        rentalHomePage.pickUpTime.sendKeys("1050");
        rentalHomePage.dropOffDate.sendKeys("21052023");
        rentalHomePage.dropOffTime.sendKeys("1200");

//        And click continue reservation
        rentalHomePage.continueButton.click();
//        Then user see the warning message: Please first login
    }
}
