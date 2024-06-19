package Lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class MTSWebsiteTest {

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
    public void testUnfilledPaymentFieldsCommunicationServices() {
        // Проверка надписей в незаполненных полях сервиса "Услуги связи"
        WebElement serviceLink = driver.findElement(By.xpath("//span[@class='select__now']"));
        serviceLink.click();
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        WebElement sumInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));

        Assert.assertTrue(phoneInput.isDisplayed(), "Номер телефона");
        Assert.assertTrue(sumInput.isDisplayed(), "Сумма");
        Assert.assertTrue(emailInput.isDisplayed(), "E-mail для отправки чека");
    }

    @Test
    public void testUnfilledPaymentFieldsHomeInternet() {
        // Проверка надписей в незаполненных полях сервиса "Домашний интернет"
        WebElement serviceLink = driver.findElement(By.xpath("//span[@class='select__now']"));
        serviceLink.click();
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер абонента']"));
        WebElement sumInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));

        Assert.assertTrue(phoneInput.isDisplayed(), "Номер абонента");
        Assert.assertTrue(sumInput.isDisplayed(), "Сумма");
        Assert.assertTrue(emailInput.isDisplayed(), "E-mail для отправки чека");
    }

    @Test
    public void testUnfilledPaymentFieldsInstallment() {
        // Проверка надписей в незаполненных полях сервиса "Рассрочка"
        WebElement serviceLink = driver.findElement(By.xpath("//span[@class='select__now']"));
        serviceLink.click();
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 44']"));
        WebElement sumInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));

        Assert.assertTrue(phoneInput.isDisplayed(), "Номер счета на 44");
        Assert.assertTrue(sumInput.isDisplayed(), "Сумма");
        Assert.assertTrue(emailInput.isDisplayed(), "E-mail для отправки чека");
    }

    @Test
    public void testUnfilledPaymentFieldsDebt() {
        // Проверка надписей в незаполненных полях сервиса "Задолженность"
        WebElement dropDown = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='select__header']"))));
        dropDown.click();
        WebElement serviceLink = driver.findElement(By.xpath("//span[@class='select__now']"));
        serviceLink.click();
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 2073']"));
        WebElement sumInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        WebElement emailInput = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));

        Assert.assertTrue(phoneInput.isDisplayed(), "Номер счета на 2073");
        Assert.assertTrue(sumInput.isDisplayed(), "Сумма");
        Assert.assertTrue(emailInput.isDisplayed(), "E-mail для отправки чека");
    }

    @Test
    public void testMobileServicePayment() {
        // Заполнение полей и проверка корректности отображения информации для "Услуги связи"
        WebElement serviceLink = driver.findElement(By.xpath("//span[@class='select__now']"));
        serviceLink.click();
        Assert.assertTrue(serviceLink.isDisplayed(), "Услуги связи");
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        phoneInput.sendKeys("297777777");
        WebElement sumInput = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        sumInput.sendKeys("5");
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.switchTo().frame(iframe);

        // Проверка на отображение информации для оплаты
        WebElement totalSumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='5.00 BYN']")));
        WebElement payDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Оплата:')]")));
        WebElement payButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Оплатить  5.00 BYN ']")));

        Assert.assertTrue(payButton.isDisplayed(), "5.00 BYN");
        Assert.assertTrue(payDescription.isDisplayed(), "Оплата: Услуги связи Номер:375297777777");
        Assert.assertTrue(payButton.isDisplayed(), " Оплатить  5.00 BYN ");

        // Проверка надписей в незаполненных полях сервиса "Оплата"
        WebElement cardNumber = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']"));
        WebElement validity = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted']"));
        WebElement cvc = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted']"));
        WebElement holderName = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted']"));

        Assert.assertEquals(cardNumber.getText(), "Номер карты");
        Assert.assertEquals(validity.getText(), "Срок действия");
        Assert.assertEquals(cvc.getText(), "CVC");
        Assert.assertEquals(holderName.getText(), "Имя держателя (как на карте)");
        // Проверка иконк платежных систем
        WebElement mastercard = driver.findElement(By.xpath("//img[ @src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        WebElement visa = driver.findElement(By.xpath("//img[ @src='assets/images/payment-icons/card-types/visa-system.svg']"));
        WebElement belkart = driver.findElement(By.xpath("//img[ @src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        WebElement mir = driver.findElement(By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));

        Assert.assertTrue(mastercard.isDisplayed(), "mastercard");
        Assert.assertTrue(visa.isDisplayed(), "visa");
        Assert.assertTrue(belkart.isDisplayed(), "belkart");
        Assert.assertTrue(mir.isDisplayed(), "mir");

        //Проверка иконк платежных систем на кнопках оплаты
        WebElement GooglePayButton = driver.findElement(By.xpath("//button[@aria-label='Google Pay']"));
        WebElement YandexPayButton = driver.findElement(By.xpath("//button[@aria-label='Yandex Pay']"));

        Assert.assertTrue(GooglePayButton.isDisplayed(), "Google Pay");
        Assert.assertTrue(YandexPayButton.isDisplayed(), "Yandex Pay");
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

    @AfterMethod
    public void teardown() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Error closing the browser: " + e.getMessage());
        }
    }

}
