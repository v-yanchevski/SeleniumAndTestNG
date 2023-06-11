package com.testautomationpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckDropdownIfSorted {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void testDropdownSorting() {
        WebElement dropDownAnimals = driver.findElement(By.id("animals"));
        Select select = new Select(dropDownAnimals);

        List<String> originalList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();

        List<WebElement> options = select.getOptions();
        for (WebElement e : options) {
            originalList.add(e.getText());
            tempList.add(e.getText());
        }


        Collections.sort(tempList);

        Assert.assertTrue(originalList.equals(tempList), "Dropdown is not sorted");
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

}
