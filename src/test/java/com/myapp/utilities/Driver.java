package com.myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
//    Driver object
    private static WebDriver driver;

//    1. getDriver : setup and instantiate the driver object
    public static WebDriver getDriver(){
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
//    2. closeDriver : quits the driver
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
