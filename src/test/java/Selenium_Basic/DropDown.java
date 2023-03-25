package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DropDown
{
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
    }

    @Test@Ignore
    public void DropDownList() throws InterruptedException
    {
        //No es recomendable utilizar clicks en listas desplegables

        WebElement selectDay = driver.findElement(By.className("form-control"));
        selectDay.click();
        Thread.sleep(3000);
        String day = "Sunday";
        String opcionBuscar = String.format("//option[text()='%s']", day);
        WebElement option = driver.findElement(By.xpath(opcionBuscar));
        option.click();
        Thread.sleep(3000);

    }

    @Test@Ignore
    public void DropDownWithSendKeys() throws InterruptedException {
        //Esta opcion es aceptable y puede tambien utilizarse
        WebElement selectDay = driver.findElement(By.className("form-control"));
        String day = "Thursday";
        selectDay.sendKeys(day);
        Thread.sleep(3000);
    }

    @Test
    public void DropDownWithClassSelect() throws InterruptedException {
        String day = "Monday";
        WebElement selectDay = driver.findElement(By.className("form-control"));
        Select selectList = new Select(selectDay);
        //selectList.selectByVisibleText(day);
        //selectList.selectByValue("Saturday");
        selectList.selectByIndex(5);
        Thread.sleep(3000);

    }


    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();

    }

}
