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

public class ClientPvzCashback {

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1000);

        System.out.println("55. Клик — T Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("T Market"))).click();
        Thread.sleep(1000);

        System.out.println("56. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("57. olib ketish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Olib ketish\nBepul\n2 varaqdan 2"))).click();
        Thread.sleep(1000);

        System.out.println("58. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Yetkazib berish punktini tanlash')]")
        )).click();

        Thread.sleep(5000);

        System.out.println("59. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Map Marker\").instance(0)"))).click();

        Thread.sleep(5000);

        System.out.println("60. Клик — Ushbu punktni tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ushbu punktni tanlash\nUshbu punktni tanlash"))).click();
        Thread.sleep(1000);

        System.out.println("61. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Toshkent shahri, Sergeli tumani, 6-massiv, 47')]")
        ));
        Assert.assertTrue(pickupSet1.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        System.out.println("62. Клик — instance 16.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();
        Thread.sleep(1000);

        System.out.println("63. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        System.out.println("64. Клик — кешбек (Switch).");

        WebElement switchBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")")
        ));
        switchBtn1.click();

        System.out.println("65. Проверка — отображается Kartadan yechib olish.");
        WebElement kartadanTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Kartadan yechib olish')]")
        ));
        System.out.println("✅ Элемент 'Kartadan yechib olish' успешно найден на экране!");

        // 66. Кликаем кнопку оплаты
        System.out.println("66. Клик — кнопка оплаты (To'lash).");
        WebElement payWithCashbackPickupBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
        payWithCashbackPickupBtn.click();

        System.out.println("67. Проверка — Ilovani baholang.");
        WebElement rateAppDialogPickupCashback = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateAppDialogPickupCashback.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");
        Thread.sleep(2000);

        System.out.println("68. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(2000);

        System.out.println("69. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

        System.out.println("70. Проверка — начислено ровно + 20 bal за покупку.");

        WebElement pointsRecor3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Sotib olish') and contains(@content-desc, '+ 20 bal')]")
        ));

        System.out.println("✅ Запись о начислении + 20 bal успешно найдена!");

        System.out.println("71. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
        Thread.sleep(1000);
    }
    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}