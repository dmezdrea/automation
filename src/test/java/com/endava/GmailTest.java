package com.endava;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmezdrea on 8/3/2015.
 */
public class GmailTest {

    static WebDriver driver;

    @BeforeClass
    public static void before(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after(){
        driver.close();
    }

    @Before
    public void goToPage(){
        driver.get("http://mail.google.com");
    }

    @Test
    public void testGmail(){

        WebElement userNameField = driver.findElement(By.id("Email"));
        userNameField.sendKeys("cristi.dumitr91@gmail.com");

        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();

        WebElement passwordField = driver.findElement(By.id("Passwd"));
        passwordField.sendKeys("masina321");

        WebElement connectButton = driver.findElement(By.id("signIn"));
        connectButton.click();

        WebElement composeButton = driver.findElement(By.xpath("//div[text() = 'COMPOSE']"));
        composeButton.click();

        WebElement toLabel = driver.findElement(By.className("vO"));
        toLabel.sendKeys("cristi.dumitr91@gmail.com");

        WebElement subjectLabel = driver.findElement(By.className("aoT"));
        subjectLabel.sendKeys("test");

        WebElement bodyLabel = driver.findElement(By.className("LW-avf"));
        bodyLabel.sendKeys("test");

        WebElement sendButton = driver.findElement(By.xpath("//div[text() = 'Send']"));
        sendButton.click();
    }

}
