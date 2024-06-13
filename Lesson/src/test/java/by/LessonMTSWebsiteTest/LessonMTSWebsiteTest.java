package by.LessonMTSWebsiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LessonMTSWebsiteTest {

    private static final Logger logger = LoggerFactory.getLogger(LessonMTSWebsiteTest.class);

    @Test
    public void testSomething() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        acceptCookies();
    }

    @Test
    public void testOnlinePaymentBlock() {
        // 1. Проверить название указанного блока
        WebElement onlinePaymentBlock = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        Assert.assertEquals(onlinePaymentBlock.getText(), "Онлайн пополнение\nбез комиссии");
        // 2. Проверить наличие логотипов платёжных систем
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='pay__partners']")).isDisplayed());
    }

    @Test
    public void moreAboutTheService() {
        // 3. Проверить работу ссылки "Подробнее о сервисе"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/a")));
        WebElement moreInfoLink = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        moreInfoLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void testCheckingTheContinueButton() {
        // 4. Заполнить поля и проверить работу кнопки "Продолжить"
        WebElement serviceTypeLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='select__now']")));
        Assert.assertTrue(serviceTypeLink.isDisplayed(), "Услуги связи");
        serviceTypeLink.click();

        WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='phone'and@id='connection-phone']")));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='connection-sum']")));
        sumInput.sendKeys("5");
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Продолжить']")));
        continueButton.click();
        WebElement totalSumElement = null;
        Assert.assertTrue(totalSumElement.isDisplayed());
    }

    private void acceptCookies() {
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

    @AfterTest
    public void teardown() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Error closing the browser: " + e.getMessage());
        }
    }
}


