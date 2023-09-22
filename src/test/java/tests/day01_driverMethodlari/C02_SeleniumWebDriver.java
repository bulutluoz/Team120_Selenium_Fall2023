package tests.day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_SeleniumWebDriver {

    public static void main(String[] args) {

        // ilk adimi atlayip direk WebDriver objesi olusturalim
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        /*
            Selenium son versiyonlarindan birinde
            kendi WebDriver class'ini ekledi
            boylece oncesinde driver.exe dosyasini tanitmasak da
            istedigimiz browser'i calistirir

            Sadece oncelikle bizden bir driver bekledigi icin
            birazcik gec calisiyor

            Sirketler acik kaynakli driver kullanmayi tercih etmez
            genellikle satin aldiklari bir driver'i kullanmanizi isterler
            bu durumda size verdikleri driver ile ilk satiri yazmalisiniz
         */
    }
}
