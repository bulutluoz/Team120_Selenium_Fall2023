package tests.day04_xPath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2-  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        //3-  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4-  Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5-  Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedIcerik = "Spend less";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }
        //6-  Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();
        Thread.sleep(2000);
        //7-  Specialty Gift Cards butonuna basin
        driver.findElement(By.linkText("Specialty Gift Cards")).click();
        Thread.sleep(2000);
        //8-   ilk urunu tiklayin
        driver.findElement(By.xpath("(//li[@class='a-carousel-card acswidget-carousel__card'])[1]"))
                .click();
        //9-  Gift card details’den 25 $’i  secin
        driver.findElement(By.id("gc-mini-picker-amount-2")).click();
        Thread.sleep(2000);
        //10- Urun ucretinin 25$ oldugunu test edin
        WebElement urunFiyatElementi = driver.findElement(By.xpath("//div[@id='gc-live-preview-amount-container']"));

        String expectedUrunUcreti = "25$";
        String actualUrunUcreti = urunFiyatElementi.getText();

        if (expectedUrunUcreti.equals(actualUrunUcreti)){
            System.out.println("Urun ucret testi PASSED");
        }else{
            System.out.println("Urun ucret testi FAILED");
            System.out.println("Actual urun ucreti : " + actualUrunUcreti);
        }

        //11- Sayfayi kapatin
        driver.close();
    }
}
