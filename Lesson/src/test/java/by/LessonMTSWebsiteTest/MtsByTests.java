package by.LessonMTSWebsiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class MtsByTests {
    WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //acceptCookies();

       // private void acceptCookies () {
            try {
                WebElement cookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath
                        ("//button[@class='btn btn_black cookie__ok']")));
                if (cookieButton.isDisplayed()) {
                    cookieButton.click();
                }
            } catch (Exception e) {
                System.out.println("Cookie popup not found or clickable");
            }
        }
   // }
    @Test
    public void testOnlinePaymentBlock() {
        // 1. Проверить название указанного блока
        WebElement onlinePaymentBlock = driver.findElement(By.id("online-payment"));
        Assert.assertEquals(onlinePaymentBlock.getText(), "Онлайн пополнение без комиссии");

        // 2. Проверить наличие логотипов платёжных систем
        Assert.assertTrue(driver.findElement(By.className("payment-logos")).isDisplayed());

        // 3. Проверить работу ссылки "Подробнее о сервисе"
        WebElement detailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        detailsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("mts.by/finance/mts-dengi"));

        // 4. Заполнить поля и проверить работу кнопки "Продолжить"
        WebElement serviceTypeSelect = driver.findElement(By.id("service-type"));
        serviceTypeSelect.sendKeys("Услуги связи");

        WebElement phoneInput = driver.findElement(By.id("phone-number"));
        phoneInput.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.id("continue-button"));
        continueButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("payment.mts.by"));
    }

   /* @AfterTest
    public void teardown() {
        driver.quit();
    }*/
}
