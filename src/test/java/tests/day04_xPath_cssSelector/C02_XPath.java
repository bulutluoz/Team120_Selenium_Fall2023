package tests.day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@*='addElement()']")).click();
        Thread.sleep(2000);
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//button[@*='deleteElement()']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("Delete butonu testi PASSED");
        }else{
            System.out.println("Delete butonu testi FAILED");
        }
        //4- Delete tusuna basin
        deleteButonu.click();
        Thread.sleep(2000);
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        // WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h3"));
        WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h3"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add remove yazi testi PASSED");
        }else{
            System.out.println("Add remove yazi testi FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
