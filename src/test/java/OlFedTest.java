import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.TestBase;

import java.text.SimpleDateFormat;

public class OlFedTest extends TestBase {

    @Ignore
    @Test
    public void airlineXpathTest() throws Exception {
        
        getDriver().get("https://www.tajikair.tj/en/index.php");

        getDriver().findElement(By.xpath("//input[@placeholder=\"From\"]")).click();

        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//ul[@id='From']//li[contains(text(),'surgut')]")).click();
        getDriver().findElement(By.xpath("//input[@placeholder=\"To\"]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//ul[@id='To']//li[contains(text(),'st. Petersburg')]")).click();

        getDriver().findElement(By.id("dateOfDeparture")).click();
        getDriver().findElement(By.xpath("//div[@id='dateOfDepartureBox']//div[@aria-label='Thursday, April 20, 2023']")).click();
    }

    @Test
    public void bankTest() throws Exception{

        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        getDriver().findElement(By.xpath("//button[text()='Customer Login']")).click();

        WebElement nameDropDown = getDriver().findElement(By.id("userSelect"));
        Select optionsName = new Select(nameDropDown);
        optionsName.selectByVisibleText("Albus Dumbledore");

        getDriver().findElement(By.xpath("//button[text()='Login']")).click();

        String successfulLogin = getDriver().findElement(By.xpath("//strong[text()=' Welcome ']")).getText();
        Assert.assertEquals(successfulLogin, "Welcome Albus Dumbledore !!");

        getDriver().findElement(By.xpath("//select[contains(@name,'accountSelect')]")).click();
        getDriver().findElement(By.xpath("//option[contains(@value,'number:1012')]")).click();

        Boolean valueOption = getDriver().findElement(By.xpath("//option[contains(@value,'number:1012')]")).isSelected();
        Assert.assertEquals(valueOption, true);

        getDriver().findElement(By.xpath("//button[@ng-class='btnClass2']")).click();
        getDriver().findElement(By.xpath("//input[@type='number']")).sendKeys("25000\n");
        Thread.sleep(1000);
        String depositMessage = getDriver().findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        Assert.assertEquals(depositMessage, "Deposit Successful");

        getDriver().findElement(By.xpath("//button[@ng-class='btnClass1']")).click();

        String transactionTime = getDriver().findElement(By.id("anchor0")).getText();
        Assert.assertTrue(transactionTime.contains(new SimpleDateFormat("h:mm").format(new java.util.Date())));

    }
}

// Второй тест, поле где выбираешь валюту:
//        try {
//            WebElement valueDropDown = getDriver().findElement(By.xpath("//select[contains(@name,'accountSelect')]"));
//            Select optionsValue = new Select(valueDropDown);
//            optionsName.selectByValue("1012");
//            String valueText = optionsValue.getFirstSelectedOption().getText();
//            Assert.assertEquals(valueText, "1012");
//        }
//        catch (org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            WebElement valueDropDown = getDriver().findElement(By.xpath("//select[contains(@name,'accountSelect')]"));
//            Select optionsValue = new Select(valueDropDown);
//            optionsName.selectByValue("1012");
//            String valueText = optionsValue.getFirstSelectedOption().getText();
//            Assert.assertEquals(valueText, "1012");
//        }
//
//;;;;;;;;;
