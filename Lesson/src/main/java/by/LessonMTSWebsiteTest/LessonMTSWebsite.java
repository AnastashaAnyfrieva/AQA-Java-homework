package by.LessonMTSWebsiteTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LessonMTSWebsite {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:\\homework _aqa_aston\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://mts.by");
        driver.manage().deleteAllCookies();
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-accept-button"));
        if (cookieAcceptButton.isDisplayed()) {
            cookieAcceptButton.click();
        }

        // 1. Проверить название указанного блока
        WebElement onlinePaymentBlock = driver.findElement(By.id("online-payment"));
        System.out.println("Название блока: " + onlinePaymentBlock.getText());

        // 2. Проверить наличие логотипов платёжных систем
        WebElement paymentLogos = driver.findElement(By.className("payment-logos"));
        System.out.println("Логотипы платёжных систем: " + paymentLogos.isDisplayed());

        // 3. Проверить работу ссылки "Подробнее о сервисе"
        WebElement detailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        detailsLink.click();
        System.out.println("URL после клика на ссылку: " + driver.getCurrentUrl());

        // 4. Заполнить поля и проверить работу кнопки "Продолжить"
        WebElement serviceTypeSelect = driver.findElement(By.id("service-type"));
        serviceTypeSelect.sendKeys("Услуги связи");

        WebElement phoneInput = driver.findElement(By.id("phone-number"));
        phoneInput.sendKeys("297777777");

        WebElement continueButton = driver.findElement(By.id("continue-button"));
        continueButton.click();
        System.out.println("URL после клика на кнопку: " + driver.getCurrentUrl());

        driver.quit();
    }
}
