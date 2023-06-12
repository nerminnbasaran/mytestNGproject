package com.myapp.tests.dataprovider;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.DataProviderUtils;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class Day22_DataProvider3 {
//    GETTING THE DATA FROM THE JAVA CLASS IN DATA PROVIDER UTILS
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;

//    TEST LOGIN FUNCTIONALITY USING CUSTOMER SERVICE CREDENTIALS
//    We need 2 methods: ****DataProvider ****@Test method

    @Test(dataProvider = "customerDataProvider",dataProviderClass = DataProviderUtils.class)
    public void customerLoginTest(String username,String password){
        System.out.println(username+password);
        Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
        rentalHomePage = new RentalHomePage();
        rentalLoginPage = new RentalLoginPage();
//            --LOGIN--
//            click on login
        rentalHomePage.loginLink.click();
//            enter username
        rentalLoginPage.userEmail.sendKeys(username);//GET DATA FROM DATA PROVIDER
//            enter password
        rentalLoginPage.userPassword.sendKeys(password);//GET DATA FROM DATA PROVIDER
//            click on login button
        rentalLoginPage.loginButton.click();
//            verify login is successful
        ReusableMethods.verifyElementDisplayed(rentalHomePage.userID);
//            click on id
        rentalHomePage.userID.click();
//            click on logout
        rentalHomePage.logOut.click();
//            click on ok
        rentalHomePage.OK.click();
        Driver.closeDriver();
    }


}
