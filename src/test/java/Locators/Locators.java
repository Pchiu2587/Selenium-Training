package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/* Las estrataegias de localización son mediante:
id , name, class, tagname, linktext, partialLinktext, cssSelector, Xpath
 */
public class Locators
{
    private WebDriver driver; //Controla a los navegadores

    @BeforeTest //Fistures
    public void Setup() throws InterruptedException
    {
        // Se coloca la dirección del driver, segun corresponda (Chrome, mozila, edge, safari, opera, etc)

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");// Instruccion
        // para el controlador del navegador"", y la ruta donde la colocamos.
        //Version 111.0.5563.111 (Official Build) (64-bit Chrome.


        // Se crea la instancia y objeto del navegador
        driver = new ChromeDriver();


        driver.manage().window().maximize();// maximiza la ventana del navegador

        // Enviamos las URL al navegador
        driver.get("https://demo.guru99.com/test/newtours/"); // Interacturar con la pagina de amazon.
        driver.manage().deleteAllCookies();
        Thread.sleep(4000);

    }
    @Test
    public void Locators() throws InterruptedException //<< throws InterruptedException es de java
    {
        //****Localizador por id********
        WebElement demoSite = driver.findElement(By.id("site-name"));
        demoSite.click();
        Thread.sleep(3000);

        //*****Localizador por "name"*****
        /*WebElement userName = driver.findElement(By.name("userName"));
        userName.sendKeys("Automation23");
        Thread.sleep(3000);*/

        //*******Localizador por "ClassName"*******
        /*WebElement logo = driver.findElement(By.className("logo"));
        logo.click();
        Thread.sleep(3000);*/

        //*****Localizador por "Link Text"*******
        /*WebElement demoSite = driver.findElement(By.linkText("Demo Site"));
        demoSite.click();
        Thread.sleep(3000);*/

        //******Localizador por "Partial Link Text"********
        /*WebElement demoSite = driver.findElement(By.partialLinkText("Demo"));
        demoSite.click();
        Thread.sleep(3000);*/

        //********Localizador por "cssSelector"*********
        //WebElement userName = driver.findElement(By.cssSelector("input[name='userName']"));
        //WebElement demoSite = driver.findElement(By.cssSelector("div#site-name"));
        //WebElement demoSite = driver.findElement(By.cssSelector("#site-name"));
        //demoSite.click();
        //WebElement userName = driver.findElement(By.cssSelector("input[type='text'][name='userName']"));
        //userName.sendKeys("Automation");
        //Thread.sleep(3000);

        //********* X P H A T S ********
        //Existen dos tipos de xpaths; que son: absoluto y relativo
        //El xphat absoluto por buenas practicas NO se debe utilizar o bien no abusar de el
        //Diferencias
        //El xphat absoluto es toda la ruta del elemento, es decir la ubicacion del mismo y su sintaxis inicia con una diagonal

        //******* Xphat Absoluto
        /*WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input"));
        userName.sendKeys("Locura");
        */

        //*****Xpath Relativo ************
        //El uso de xpath relativo inician con doble // (diagonal)
        // El uso de xpath relativo se realiza por medio de los tags y atributos, entiendase que tags, son: span, img, button, input, etc...

        //1. Un atributo
        /*WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys("REGISTRO");*/

        //2. Dos atributos
        /*WebElement demoSite = driver.findElement(By.xpath("//a[@title='Home' and @style='font-size:32px;']"));
        demoSite.click();*/

        //3. Uso de xpath usando contains, con: "*" o "tag", cabe mencionar que se puede utilizar uno u otro
        /*WebElement demoSite = driver.findElement(By.xpath("//*[contains(text(), 'Demo Site')]"));
        demoSite.click();
        Thread.sleep(3000);*/

    }
    @AfterTest
    public void TearDown()
    {
        //driver.close(); //Cerramos el navegador, cerrar la instancia del chrome
        driver.quit();  //Sirve para que el navegaor no se quede colgado  y afecte el performance del script


    }
}
