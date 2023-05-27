package com.myapp.tests.topics;

import org.testng.annotations.*;

public class Day17_Annotations {
    /*
    @Test : creates a test case. marks methods as a test case.In this class there are 5 test cases. Same as JUnit
    @Before and @After : there are 5 Before and 5 After annotations
    @..Suite -> runs before/after all test in this suite
    HIERARCHY : suite > test > group > class > method
    @Ignore : Skip/ignore test cases. Eg. ignore test3
    @Test(enable = false) : Disables the test case. By default, enable=true. Eg.: disable test4
    In TestNG it runs test cases in natural order(alphabetical order)
    @Test(priority = priority number) : we use priority to prioritize the test cases
    Best practice : when you use priority ALL test cases and give different numbers
     */

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("before group");
    }

    @AfterGroups
    public void afterGroups(){
        System.out.println("after group");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("after class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("before method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }

    @Test(priority=-3)
    public void test1(){
        System.out.println("Test1");
    }
    @Test(priority=1)
    public void test2(){
        System.out.println("Test2");
    }
    @Test @Ignore
    public void test3(){
        System.out.println("Test3");
    }
    @Test(enabled = false)
    public void test4(){
        System.out.println("Test4");
    }
    @Test(priority=2)
    public void test5(){
        System.out.println("Test5");
    }
    @Test
    public void test6(){
        System.out.println("Test6");
    }

}
