package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstTest {

    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/app/t36.apk");

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. click o'zbekcha
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

        // 2. click русский
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

        // 3. проверим что кнопка "продолжить" кнопка есть
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Продолжить')]")));
        System.out.println("✅ Кнопка 'Продолжить' найдена");

        // 4. click русский
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

        // 5. click english
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();

        // 6. проверим что кнопка "continue" кнопка есть
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Continue')]")));
        System.out.println("✅ Кнопка 'Continue' найдена");

        // 7. click english
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();

        // 8. click o'zbekcha
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

        // 9. проверим что кнопка "davom etish" кнопка есть
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Davom etish')]")));
        System.out.println("✅ Кнопка 'Davom etish' найдена");

        // 10. click davom etish
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Davom etish')]"))).click();
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
