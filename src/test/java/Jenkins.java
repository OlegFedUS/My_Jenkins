import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.TestBase;
import runner.TestUtils;

public class Jenkins extends TestUtils {

    @Test
    public void testJenkins(){

        getDriver().get("http://localhost:8080/");

        //login + homepage
        getDriver().findElement(By.xpath("//input[contains(@placeholder,'Username')]")).sendKeys("admin");
        getDriver().findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys("f39d4d1a368543b087377aa31c9ead2e");
        getDriver().findElement(By.xpath("//button[contains(@class,'jenkins-button jenkins-button--primary')]")).click();

        //Assert homepage текста
        Assert.assertEquals(getDriver().findElement(By.xpath("//h1[text()='Welcome to Jenkins!']")).getText(), "Welcome to Jenkins!");

        //admin/config
        WebElement buttonAdmin = getDriver().findElement(By.xpath("//a[@href='/user/admin']//button[@class='jenkins-menu-dropdown-chevron']"));
        //Метод интерфейса JavascriptExecutor для метода .click(); Желательно использовать в самом крайнем случае (метод медленный и тд)
        //jsClick(getDriver(), getDriver().findElement(By.xpath("//a[@href='/user/admin']//button[@class='jenkins-menu-dropdown-chevron']")));
        buttonAdmin.sendKeys(Keys.RETURN); //Тут я использовал метод .sendKeys(Keys.RETURN) вместо .click(), тк второй не работал.
        getDriver().findElement(By.xpath("//span[text()='Configure']")).click();

        //Assert URL
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8080/user/admin/configure"); // Тест #

        //Assert текста в поле для заполнения используя .getAttribute("value");
        String userName = getDriver().findElement(By.xpath("//input[@name='_.fullName']")).getAttribute("value");
        Assert.assertEquals(userName, "admin");

        //Assert выпадающего окна timeZones тега select
        WebElement timeZone = getDriver().findElement(By.xpath("//select[@checkdependson='timeZoneName']"));

        //Метод интерфейс JavascriptExecutor
        //jsClick(getDriver(), timeZone);
        //WebElement usEast = getDriver().findElement(By.xpath("//option[@value='US/Eastern']"));
        //scrollClick(getDriver(), usEast);

        //Через интерфейс Select
        Select time = new Select(timeZone);
        time.selectByVisibleText("Europe/Moscow");

        Assert.assertEquals(timeZone.getAttribute("value"), "Europe/Moscow");



    }
}
