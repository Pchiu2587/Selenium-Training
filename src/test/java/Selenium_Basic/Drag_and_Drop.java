package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Drag_and_Drop
{
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // * URL DRAG AND DROP sin IFRAME
        //driver.get("http://demo.seleniumeasy.com/drag-and-drop-demo.html");

        // * URL DRAG AND DROP con IFRAME
        driver.get("https://jqueryui.com/droppable/");

        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
    }


    @Test@Ignore
    public void DragAndDropActions() throws InterruptedException
    {
        Actions actions = new Actions (driver);
        WebElement drag = driver.findElement(By.xpath("//*[contains(text(),'Draggable 1')]"));
        WebElement drop = driver.findElement(By.id("mydropzone"));
        //Primer funcion para realizar el drag and drop
        /*actions.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(3000);*/
        //Segunda funcion para realizar el drag and drop
        actions.clickAndHold(drag)
                .moveToElement(drop)
                .release()
                .build()
                .perform();

        Thread.sleep(3000);


    }

    @Test
    public void DragAndDropIFrame() throws InterruptedException
    {
        Actions actions = new Actions(driver);
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(drag, drop)
                .build()
                .perform();
        Thread.sleep(3000);

    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();

    }

}