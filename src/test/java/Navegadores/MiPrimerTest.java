package Navegadores; // Prueba de los navegadores

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

public class MiPrimerTest
{
    private WebDriver driver; //Controla a los navegadores

    @BeforeTest //Fistures
    public void Setup()
    {
        // Se coloca la dirección del driver, segun corresponda (Chrome, mozila, edge, safari, opera, etc)

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");


       // Se crea la instancia y objeto del navegador
        driver = new ChromeDriver();


        driver.manage().window().maximize();// maximiza la ventana del navegador

       // Enviamos las URL al navegador
        driver.get("https://www.amazon.com.mx/"); // Interacturar con la pagina de amazon.


    }
    @Test
    public void MiPrimerTest() throws InterruptedException //<< throws InterruptedException es de java
    {
        WebElement inputSearch = driver.findElement(By.id("twotabsearchtextbox"));// Método de Selenium para buscar en el navegador
        Thread.sleep(3000); // Tiempo de espera para el renderizado, no abusar del uso de los Thread.sleep. esta espera de  selenium
        HTMLInputElement singOn;
        //singOn.click(); // Hacer un click
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
            driver.quit();  //Sirve para que el navegaor no se quede colgado  y afecte el performance del script


        }
}
