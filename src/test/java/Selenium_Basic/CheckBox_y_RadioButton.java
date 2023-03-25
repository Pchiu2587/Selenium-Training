package Selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox_y_RadioButton
{
    private WebDriver driver;

    @BeforeTest
    public void Setup () throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
    }

    //1. Validar: verificar que se muestre el elemento con el cual vamos a interactuar antes de cualquier operacion
    //2. Verificar que los radiobuttons o checkboxes esten habilitados
    //3. Verificar la seleccion predeterminada del boton, ya sea radiobutton o checkbox

    @Test
    public void Checkbox_y_RadioButton () throws InterruptedException
    {
        WebElement radioButtonMale = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));

        //isDisplayed(): lo que nos regresa es un valor booleano, ya sea falso o verdadero,
        //lo que significa si dicho boton esta o no presente, si es falso = el boton no esta presente.

        //isEnabled(): lo que nos regresa es tambien un valor booleano, si es verdadero, entonces esta el boton esta...
        //pos habilitado! y si no... pos no!

        //isSelected(): igualmente valor booleano, si es verdadero, el boton esta... seleccionado! y si no... pos no!

        boolean statusDisplayed = radioButtonMale.isDisplayed();
        System.out.println("Status Displayed: " + statusDisplayed);
        Thread.sleep(3000);

        boolean statusEnabled = radioButtonMale.isEnabled();
        System.out.println("Status Enabled: " + statusEnabled);
        Thread.sleep(3000);

        radioButtonMale.click();

        boolean statusSelected = radioButtonMale.isSelected();
        System.out.println("Status Selected: " + statusSelected);
        Thread.sleep(3000);


    }

    @AfterTest
    public void TearDown()
    {
        driver.close();
        driver.quit();

    }
}