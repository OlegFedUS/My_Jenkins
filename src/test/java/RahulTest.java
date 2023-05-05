import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.TestBase;

import java.util.List;

public class RahulTest extends TestBase {
@Ignore
    @Test
    public void testPractice() throws InterruptedException{

        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement radioButton = getDriver().findElement(By.xpath("//input[@value='radio2']"));
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected());

        getDriver().findElement(By.id("autocomplete")).sendKeys("ru");
        Thread.sleep(1000);
        List<WebElement> countries = getDriver().findElements(By.id("ui-id-1"));
        for (WebElement country : countries){
            Assert.assertTrue(country.getText().contains("Russian Federation"));
        }

        WebElement dropbox = getDriver().findElement(By.xpath("//select[contains(@id,'dropdown-class-example')]"));
        Select dropboxOptions = new Select(dropbox);
        dropboxOptions.selectByVisibleText("Option3");
        Assert.assertTrue(dropboxOptions.getFirstSelectedOption().isSelected());

        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//label[@for='bmw']")).click();
        getDriver().findElement(By.xpath("//label[@for='benz']")).click();
        getDriver().findElement(By.xpath("//label[@for='honda']")).click();
        Thread.sleep(1000);
        WebElement checkbox = getDriver().findElement(By.xpath("//label[@for='benz']"));
        checkbox.click();
        boolean checkboxNot = !checkbox.isSelected();
        Assert.assertTrue(checkboxNot);

    }

}
