package Navegadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTest
{
    private WebDriver driver; //Controla a los navegadores

    @BeforeTest //Fistures
    public void Setup() throws InterruptedException
    {
        // Se coloca la dirección del driver, segun corresponda (Chrome, mozila, edge, safari, opera, etc)

        //System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
         System.setProperty("webdriver.gecko.driver", "src/main/resources/Drivers/geckodriver.exe");
        // System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");


        // Se crea la instancia y objeto del navegador
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        //driver = new EdgeDriver();

        driver.manage().window().maximize();// maximiza la ventana del navegador

        // Enviamos las URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/"); // Interacturar con la pagina.
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);



    }
    @Test
    public void MiPrimerTest() throws InterruptedException //<< throws InterruptedException es de java
    {
        WebElement inputSearch = driver.findElement(By.id("twotabsearchtextbox"));// Método de Selenium para buscar en el navegador
        Thread.sleep(3000); // Tiempo de espera para el renderizado, no abusar del uso de los Thread.sleep. esta espera de  selenium
        inputSearch.click(); // Hacer un click
        Thread.sleep(3000);
        inputSearch.sendKeys("Alexa"); // Relaizar la busqueda de Alexa
        Thread.sleep(2000);
        inputSearch.submit(); // utiliza para simular un enter
        Thread.sleep(6000);

    }
    @AfterTest
    public void TearDown()
    {
        driver.close(); //Cerramos el navegador
        driver.quit();

    }
}
