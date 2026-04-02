package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class abonPvz {

    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("uiautomator2")
                .setApp(System.getProperty("user.dir") + "/app/t36.apk")
                .autoGrantPermissions()
                .setNoReset(true)
                .setFullReset(false);

        driver = new AndroidDriver(URI.create(appiumServerUrl).toURL(), options);
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("⏳ Тест запущен!");

        driver.terminateApp("com.turontelecom.app.demo");
        driver.activateApp("com.turontelecom.app.demo");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        Thread.sleep(1000);

        System.out.println("20. Клик — T Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("T Market"))).click();
        Thread.sleep(1000);

        System.out.println("21. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("22. olib ketish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Olib ketish\nBepul\n3 varaqdan 2"))).click();
        Thread.sleep(1000);

        System.out.println("23. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[contains(@content-desc, 'Yetkazib berish punktini tanlash')]")))
                .click();

        Thread.sleep(5000);

        System.out.println("24. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().description(\"Map Marker\").instance(0)")))
                .click();

        Thread.sleep(5000);

        System.out.println("25. Клик — Ushbu punktni tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ushbu punktni tanlash\nUshbu punktni tanlash"))).click();
        Thread.sleep(1000);

        System.out.println("26. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Toshkent shahri, Sergeli tumani, 6-massiv, 47')]")));
        Assert.assertTrue(pickupSet.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        System.out.println("27. Клик — instance 16.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.view.View\").instance(18)")))
                .click();
        Thread.sleep(1000);

        System.out.println("28. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        System.out.println("29. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\n2 000 UZS"))).click();
        Thread.sleep(5000);

        System.out.println("30. Проверка — Ilovani baholang.");
        WebElement rateDialog1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog1.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        System.out.println("31. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(2000);

    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}