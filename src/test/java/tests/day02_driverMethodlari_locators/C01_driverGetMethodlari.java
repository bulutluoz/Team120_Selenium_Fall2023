package tests.day02_driverMethodlari_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        System.out.println("Title "+ driver.getTitle());
        System.out.println("Url : "+driver.getCurrentUrl());
        System.out.println("===========");
        System.out.println(driver.getPageSource());

        System.out.println("Window handle degeri : "+driver.getWindowHandle());
        // C327CC40D0205EFDEC32FF1955ABD764
        System.out.println("Window handle degerleri seti : "+ driver.getWindowHandles());

        /*
            Webdriver her pencereye unique bir window handle degeri atamasi yapar

            Bir test class'i calismaya basladiktan sonra
            birden fazla pencere de acabilir

            bu durumda tek bir window handle degeri degil
            acilan sayfa adedince window handle degerlerimiz olur
            Birden fazla element olunca Selenium onlari set'e koymayi uygun gormus
         */

        Thread.sleep(3000);
        driver.close();
    }
}
