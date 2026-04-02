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

public class abonDostavkaCashback {

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

        System.out.println("35. Клик — Turon Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Turon Market"))).click();
        Thread.sleep(1000);

        System.out.println("36. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("37. Клик — кнопка добавления в корзину.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.view.View\").instance(18)")))
                .click();

        // 38. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("38. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();

        Thread.sleep(5000);

        System.out.println("39. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")")))
                .click();
        Thread.sleep(5000);

        System.out.println("40. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("41. Проверка — Turon Team location.");
        WebElement locationLabel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Turon Team location")));
        Assert.assertTrue(locationLabel1.isDisplayed(), "Turon Team location не найден");
        System.out.println("✅ Turon Team location найден");

        System.out.println("42. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("43. Проверка — адрес доставки.");
        WebElement deliveryAddr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId(
                        "Yetkazib berish manzili\nTuron Team location   \nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddr1.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        Thread.sleep(5000);

        System.out.println("44. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                                "To'lash\")")))
                .click();
        Thread.sleep(1000);

        System.out.println("45. Клик — кешбек (Switch).");

        WebElement switchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")")));
        switchBtn.click();

        System.out.println("46. Проверка — отображается Keshbekdan.");
        WebElement keshbekdanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Kartadan yechib olish')]")));
        System.out.println("✅ Элемент 'Keshbekdan' успешно найден на экране!");

        System.out.println("47. Клик — кнопка оплаты (To'lash).");
        WebElement payBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")));
        payBtn.click();

        System.out.println("48. Проверка — Ilovani baholang.");
        WebElement rateDialog3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog3.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        System.out.println("49. Клик — Asosiy sahifaga.");
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