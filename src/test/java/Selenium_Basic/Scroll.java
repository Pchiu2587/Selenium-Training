package Selenium_Basic;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scroll
{
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/drag-and-drop-demo.html");
        Thread.sleep(3000);
    }

    @Test
    public void Scroll () throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)","");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(120,120)","");
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0, -120)","");
        Thread.sleep(3000);

    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();

    }

}
