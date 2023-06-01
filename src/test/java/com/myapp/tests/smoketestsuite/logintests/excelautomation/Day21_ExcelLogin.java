package com.myapp.tests.smoketestsuite.logintests.excelautomation;

import com.myapp.pages.RentalHomePage;
import com.myapp.pages.RentalLoginPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ExcelUtils;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day21_ExcelLogin {

    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;
//     to call the Excel Util constructor and methods
    ExcelUtils excelUtils;
//     will be used to store the data
    List<Map<String, String>> dataList;
    /*
    Apache poi library is used for working with Microsoft files
    Workbook>Sheet>Row>Cell
    We will use ExcelUtils
    **Where do we get our testing data?
    -BA,Test Lead, Tech Lead, Manual Tester, Developer
    **How do we use the data in test cases?
    -I always try to use data dynamically. Some of the data source:
    *External Files
    *Config.properties
    *Excel
    *Json
    *Xml
    *Database
    *API
    *Faker

        -I basically use excel automation WHEN I NEED ESPECIALLY MULTIPLE DATA IN MY AUTOMATION SCRIPT
    For example when I test login functionality with different user profiles, then I get the data from excel.
        -We can do Data Driven Testing with Excel. DDT is when we get multiple data to test the functionality.
    We sent multiple data and check if all test cases passed with the different data.
        -We use excel to protect the test data as well

     */

    @Test
    public void customerLoginTest(){
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        excelUtils = new ExcelUtils(path,sheetName);
        dataList = excelUtils.getDataList();
        System.out.println(dataList);//returns all of the data as list of map of string
        for (Map<String,String> eachData : dataList){
//            go to home page
            Driver.getDriver().get(ConfigReader.getProperty("rental_home_url"));
            rentalHomePage = new RentalHomePage();
            rentalLoginPage = new RentalLoginPage();
//            --LOGIN--
//            click on login

            rentalHomePage.loginLink.click();
//            enter username
            rentalLoginPage.userEmail.sendKeys(eachData.get("username"));//GET DATA FROM EXCEL
//            enter password
            rentalLoginPage.userPassword.sendKeys(eachData.get("password"));//GET DATA FROM EXCEL
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
        }
        Driver.closeDriver();

        /*
        TRY LOOPING THIS CONTENT
        go to home page
        click on login
        enter username
        enter password
        click on login button
        verify login is successful
        click on id
        click on logout
        click on ok
         */

        /*
        PSEUDO CODE:
        ************************
        --LOG IN--
        go to homepage
        click on home login link
        enter password
        click on login button
        verify login is successful
        --LOG OUT--
        click on id
        click on logout
        click on ok
        --LOG IN--
        click on home login link
        enter password
        click on login button
        verify login is successful
        --LOG OUT--
        click on id
        click on logout
        click on ok
        --LOG IN--
        click on home login link
        enter password
        click on login button
        verify login is successful
         --LOG OUT--
        click on logout
        click on ok
         */
    }


}
