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

public class abonDostavka {

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

        System.out.println("1. Клик — Turon Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Turon Market"))).click();
        Thread.sleep(1000);

        System.out.println("2. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("3. Клик — кнопка добавления в корзину.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().className(\"android.view.View\").instance(18)")))
                .click();

        // 4. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("4. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();

        Thread.sleep(5000);

        System.out.println("5. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")")))
                .click();
        Thread.sleep(5000);

        System.out.println("6. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("7. Ввод текста в поле 0.");
        WebElement addressField0 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(0)")));
        addressField0.click();
        Thread.sleep(1000);
        addressField0.sendKeys("testйцуе123");
        Thread.sleep(1000);

        // 8. Ввод текста в поле 1 — «testйцуе123»
        System.out.println("8. Ввод текста в поле 1.");
        WebElement addressField1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(1)")));
        addressField1.click();
        Thread.sleep(1000);
        addressField1.sendKeys("testйцуе123");
        Thread.sleep(1000);

        // 9. Ввод текста в поле 2 — «testйцуе123»
        System.out.println("9. Ввод текста в поле 2.");
        WebElement addressField2 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.widget.EditText\").instance(2)")));
        addressField2.click();
        Thread.sleep(1000);
        addressField2.sendKeys("testйцуе123");
        Thread.sleep(1000);

        System.out.println("10. Проверка — Turon Team location.");
        WebElement turonLocationLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Turon Team location")));
        Assert.assertTrue(turonLocationLabel.isDisplayed(), "Turon Team location не найден");
        System.out.println("✅ Turon Team location найден");

        System.out.println("11. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("12. Проверка — адрес доставки.");
        WebElement deliveryAddressLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId(
                        "Yetkazib berish manzili\nTuron Team location testйцуе123 testйцуе123 testйцуе123\nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddressLabel.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        Thread.sleep(5000);

        System.out.println("13. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                                "To'lash\")")))
                .click();
        Thread.sleep(1000);

        System.out.println("14. Клик — To'lash 3 000 UZS.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\n3 000 UZS"))).click();
        Thread.sleep(1000);

        System.out.println("15. Проверка — Ilovani baholang.");
        WebElement rateAppDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateAppDialog.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        System.out.println("16. Клик — Asosiy sahifaga.");
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