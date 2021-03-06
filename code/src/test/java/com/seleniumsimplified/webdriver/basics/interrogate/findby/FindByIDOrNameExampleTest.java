package com.seleniumsimplified.webdriver.basics.interrogate.findby;

import com.seleniumsimplified.webdriver.manager.Driver;
import com.seleniumsimplified.webdriver.manager.TestEnvironment;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FindByIDOrNameExampleTest {

    static WebDriver driver;

    @BeforeClass
    public static void createDriverAndVisitTestPage(){
        driver = Driver.get(TestEnvironment.getUrl("find_by_playground.php"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
    }

    // ByIdOrName does not seem to work in FireFox 17 with Selenium 2.26

    @Test
    public void findByIdOrNameMatchOnName(){

        WebElement element;
        element = driver.findElement(
                             new ByIdOrName("pName2"));

        assertEquals("expected a match on name",
                "p2",
                element.getAttribute("id"));
    }

    @Test
    public void findByIdOrNameMatchOnId(){

        WebElement element;
        element = driver.findElement(
                new ByIdOrName("p3"));

        assertEquals("expected a match on id",
                "pName3",
                element.getAttribute("name"));
    }
}
