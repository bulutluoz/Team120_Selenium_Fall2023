package tests.day02_driverMethodlari_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C03_driverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver(); // Selenium'un kendi webdriver'ini kullanir
        driver.manage().window().maximize();

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");


        // sayfa basliginin "smile more" icerdigini test edin
        String expectedTitleIcerik = "smile more";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Amazon title testi PASSED");
        }else{
            System.out.println("Amazon title testi FAILED");
        }

        // youtube anasayfaya gidin
        driver.navigate().to("https://www.youtube.com");

        // url'in "youtube" icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube url testi PASSED");
        }else {
            System.out.println("Youtube url testi FAILED");
        }

        // tekrar amazon anasayfaya donun
        // ve url'in "ramazon" icermedigini test edin
        driver.navigate().back();

        String unExpectedUrlIcerik = "ramazon";
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(unExpectedUrlIcerik)){
            System.out.println("Amazon url testi FAILED");
        }else {
            System.out.println("Amazon url testi PASSED");
        }

        // tekrar youtube anasayfaya gidin
        // sayfa kaynak kodlarinda "music" gectigini test edin
        driver.navigate().forward();

        String expectedSayfaIcerik = "music";
        String actualSayfaKaynakKodlari = driver.getPageSource();

        if (actualSayfaKaynakKodlari.contains(expectedSayfaIcerik)){
            System.out.println("Youtube kaynak kodu testi PASSED");
        }else{
            System.out.println("Youtube kaynak kodu testi FAILED");
        }

        // sayfayi kapatin

        driver.close();
    }
}
