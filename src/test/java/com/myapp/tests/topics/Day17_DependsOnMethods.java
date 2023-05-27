package com.myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day17_DependsOnMethods {

//    Make searchPage test dependent on the homePage test using dependsOnMethods
//    If homePage PASS only then searchPage executes
//    If homePage FAILS then searchPage will be SKIPPED

    @Test
    public void homePage(){
        System.out.println("I am on the home page");
        Assert.assertFalse(true);//FAILS ON PURPOSE
    }

    @Test(dependsOnMethods = "homePage")
    public void searchPage(){
        System.out.println("On the search page");
    }

    @Test
    public void checkOutPage(){
        System.out.println("On the checkout page");
    }
}
