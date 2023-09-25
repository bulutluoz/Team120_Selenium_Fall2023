package tests.day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            Cok ozel durumlar icin Selenium4 ile Relative Locators tanitilmistir.

            EGER bir webelementi gordugumuz ve HTML kodlari ile locate ettigimiz halde
            locator calismiyorsa

            calismayan locator'a sahip webelement
            etrafindaki calisan locator'a sahip webelementler ile locate edilebilir
         */

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //2 ) Berlin’i  3 farkli relative locator ile locate edin
        // <img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">

        // A- NYC'nin altinda diye locate edelim
        WebElement nycElementi = driver.findElement(By.id("pid3_thumb"));

        WebElement berlin1 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(nycElementi));

        // B - Boston'in sagindaki diye locate edelim
        WebElement bostonElementi = driver.findElement(By.id("pid6_thumb"));
        WebElement berlin2 = driver.findElement(RelativeLocator.with(By.id("pid7_thumb")).toRightOf(bostonElementi));

        // C - Sailor'in ustu diye tarif edelim
        WebElement sailorElementi = driver.findElement(By.id("pid11_thumb"));
        WebElement berlin3 = driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).above(sailorElementi));


        //3 ) Relative locator’larin dogru calistigini test edin

        if (berlin1.getAttribute("id").equals("pid7_thumb")){
            System.out.println("Berlin1 testi PASSED");
        }else{
            System.out.println("Berlin1 testi FAILED");
        }

        if (berlin2.getAttribute("id").equals("pid7_thumb")){
            System.out.println("Berlin2 testi PASSED");
        }else{
            System.out.println("Berlin2 testi FAILED");
        }

        if (berlin3.getAttribute("id").equals("pid7_thumb")){
            System.out.println("Berlin3 testi PASSED");
        }else{
            System.out.println("Berlin3 testi FAILED");
        }

        driver.close();
    }
}
