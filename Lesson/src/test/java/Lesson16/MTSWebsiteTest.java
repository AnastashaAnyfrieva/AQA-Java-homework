package Lesson16;

import io.qameta.allure.*;
import jdk.jfr.Description;
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
    @Description("Настройка менеджера WebDriverManager")
    public void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Description("Настройка браузера и перехода на сайт МТС")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        acceptCookies();
    }

    @Test
    @Description("Проверка надписей в незаполненных полях сервиса \"Услуги связи\"")
    @Feature("Услуги связи")
    @Story("Проверка незаполненных полей")
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
    @Description("Проверка надписей в незаполненных полях сервиса \"Домашний интернет\"")
    @Feature("Домашний интернет")
    @Story("Проверка незаполненных полей")
    @Severity(SeverityLevel.CRITICAL)
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
    @Feature("Рассрочка")
    @Story("Проверка незаполненных полей")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка надписей в незаполненных полях сервиса \"Рассрочка\"")
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
    @Feature("Задолженность")
    @Story("Проверка незаполненных полей")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка надписей в незаполненных полях сервиса \"Задолженность\"")
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
    @Feature("Услуги связи")
    @Story("Заполнение полей и проверка корректности отображения информации")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Заполнение полей и проверка корректности отображения информации для \"Услуги связи\".\n" +
            "Этот код выполняет следующие действия:\n" +
            "1. Кликает на ссылку \"Услуги связи\" и проверяет, что она отображается.\n" +
            "2. Вводит номер телефона \"297777777\" и сумму \"5\" в соответствующие поля.\n" +
            "3. Кликает на кнопку \"Продолжить\".\n" +
            "4. Переключается на iframe для отображения информации об оплате.\n" +
            "5. Проверяет, что отображается сумма \"5.00 BYN\", описание \"Оплата: Услуги связи Номер:375297777777\" и кнопка \"Оплатить 5.00 BYN\".\n" +
            "6. Проверяет, что в незаполненных полях отображаются правильные подсказки: \"Номер карты\", \"Срок действия\", \"CVC\", \"Имя держателя (как на карте)\".\n" +
            "7. Проверяет, что отображаются иконки платежных систем: Mastercard, Visa, Belkart, Mir.\n" +
            "8. Проверяет, что отображаются кнопки Google Pay и Yandex Pay.")
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

        Assert.assertTrue(totalSumElement.isDisplayed(), "5.00 BYN");
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

    @Step("Принять cookie")
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
