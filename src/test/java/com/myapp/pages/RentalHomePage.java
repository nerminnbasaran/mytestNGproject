package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RentalHomePage {

    public RentalHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;

    @FindBy(id = "dropdown-basic-button")
    public WebElement userID;

    @FindBy(name = "car")
    public WebElement carDropDown;

    @FindBy(name = "pickUpLocation")
    public WebElement pickUpLocation;

    @FindBy(name = "dropOfLocation")
    public WebElement dropOfLocation;

    @FindBy(name = "pickUpDate")
    public WebElement pickUpDate;

    @FindBy(name = "pickUpTime")
    public WebElement pickUpTime;

    @FindBy(name = "dropOffDate")
    public WebElement dropOffDate;

    @FindBy(name = "dropOffTime")
    public WebElement dropOffTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy(linkText ="Logout")
    public WebElement logOut;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;

}
