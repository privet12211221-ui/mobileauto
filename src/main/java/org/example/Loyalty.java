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

public class Loyalty {

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



        System.out.println("7. Клик — Turon Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Turon Market"))).click();
        Thread.sleep(1000);

        System.out.println("8. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("9. Клик — кнопка добавления в корзину.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();

        // 10. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("10. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();

        Thread.sleep(5000);

        System.out.println("11. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).click();
        Thread.sleep(5000);

        System.out.println("12. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("13. Ввод текста в поле 0.");
        WebElement addressField0 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")));
        addressField0.click();
        Thread.sleep(1000);
        addressField0.sendKeys("testйцуе123");

        // 14. Ввод текста в поле 1 — «testйцуе123»
        System.out.println("14. Ввод текста в поле 1.");
        WebElement addressField1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")));
        addressField1.click();
        Thread.sleep(1000);
        addressField1.sendKeys("testйцуе123");

        // 15. Ввод текста в поле 2 — «testйцуе123»
        System.out.println("15. Ввод текста в поле 2.");
        WebElement addressField2 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)")));
        addressField2.click();
        Thread.sleep(1000);
        addressField2.sendKeys("testйцуе123");

        System.out.println("16. Проверка — Turon Team location.");
        WebElement turonLocationLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Turon Team location")));
        Assert.assertTrue(turonLocationLabel.isDisplayed(), "Turon Team location не найден");
        System.out.println("✅ Turon Team location найден");

        System.out.println("17. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("18. Проверка — адрес доставки.");
        WebElement deliveryAddressLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Yetkazib berish manzili\nTuron Team location testйцуе123 testйцуе123 testйцуе123\nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddressLabel.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        Thread.sleep(5000);

        System.out.println("19. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                        "To'lash\")"))).click();
        Thread.sleep(1000);

        System.out.println("20. Клик — To'lash 3 000 UZS.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\n3 000 UZS"))).click();
        Thread.sleep(1000);


        System.out.println("21. Проверка — Ilovani baholang.");
        WebElement rateAppDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateAppDialog.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        System.out.println("22. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(2000);

        System.out.println("23. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

            System.out.println("Проверка — ищем + 30 bal под датой 31.03.2026.");

            WebElement targetRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//*[contains(@content-desc, '32.03.2026')]/following-sibling::*[contains(@content-desc, '+ 30')]")
            ));

            System.out.println("✅ Запись + 30 bal за 31.03.2026 успешно найдена!");

        Thread.sleep(2000);

        System.out.println("26. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
        Thread.sleep(1000);






        System.out.println("27. Клик — T Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("T Market"))).click();
        Thread.sleep(1000);

        System.out.println("8. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("8. olib ketish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Olib ketish\nBepul\n2 varaqdan 2"))).click();
        Thread.sleep(1000);

        System.out.println("10. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Yetkazib berish punktini tanlash')]")
        )).click();

        Thread.sleep(5000);

        System.out.println("31. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Map Marker\").instance(0)"))).click();

        Thread.sleep(5000);

        System.out.println("33. Клик — Ushbu punktni tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ushbu punktni tanlash\nUshbu punktni tanlash"))).click();
        Thread.sleep(1000);

        System.out.println("34. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Toshkent shahri, Sergeli tumani, 6-massiv, 47')]")
        ));
        Assert.assertTrue(pickupSet.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        System.out.println("35. Клик — instance 16.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();
        Thread.sleep(1000);

        System.out.println("36. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        System.out.println("36. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\n2 000 UZS"))).click();
        Thread.sleep(5000);

        System.out.println("37. Проверка — Ilovani baholang.");
        WebElement rateDialog1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog1.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        System.out.println("22. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(2000);

        System.out.println("23. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

        System.out.println("Проверка — начислено ровно + 20 bal за покупку.");

        WebElement pointsRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Sotib olish') and contains(@content-desc, '+ 20 bal')]")
        ));

        System.out.println("✅ Запись о начислении + 20 bal успешно найдена!");

        System.out.println("26. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
        Thread.sleep(1000);








        System.out.println("7. Клик — Turon Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Turon Market"))).click();
        Thread.sleep(1000);

        System.out.println("8. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("9. Клик — кнопка добавления в корзину.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();

        // 10. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("10. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();

        Thread.sleep(5000);

        System.out.println("11. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).click();
        Thread.sleep(5000);

        System.out.println("12. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("13. Ввод текста в поле 0.");
        WebElement addressField0Cashback = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")));
        addressField0Cashback.click();
        Thread.sleep(1000);
        addressField0Cashback.sendKeys("testйцуе123");

        // 14. Ввод текста в поле 1 — «testйцуе123»
        System.out.println("14. Ввод текста в поле 1.");
        WebElement addressField1Cashback = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")));
        addressField1Cashback.click();
        Thread.sleep(1000);
        addressField1Cashback.sendKeys("testйцуе123");

        // 15. Ввод текста в поле 2 — «testйцуе123»
        System.out.println("15. Ввод текста в поле 2.");
        WebElement addressField2Cashback = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)")));
        addressField2Cashback.click();
        Thread.sleep(1000);
        addressField2Cashback.sendKeys("testйцуе123");

        System.out.println("16. Проверка — Turon Team location.");
        WebElement locationLabel1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Turon Team location")));
        Assert.assertTrue(locationLabel1.isDisplayed(), "Turon Team location не найден");
        System.out.println("✅ Turon Team location найден");

        System.out.println("17. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("18. Проверка — адрес доставки.");
        WebElement deliveryAddr1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Yetkazib berish manzili\nTuron Team location testйцуе123 testйцуе123 testйцуе123\nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddr1.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        Thread.sleep(5000);

        System.out.println("19. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                        "To'lash\")"))).click();
        Thread.sleep(1000);

        System.out.println("Клик — кешбек (Switch).");

        WebElement switchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")")
        ));
        switchBtn.click();

        System.out.println("Проверка — отображается Keshbekdan.");
        WebElement keshbekdanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Kartadan yechib olish')]")
        ));
        System.out.println("✅ Элемент 'Keshbekdan' успешно найден на экране!");


        System.out.println("Клик — кнопка оплаты (To'lash).");
        WebElement payBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
        payBtn.click();


        System.out.println("21. Проверка — Ilovani baholang.");
        WebElement rateDialog3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog3.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        System.out.println("22. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(2000);

        System.out.println("23. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

        System.out.println("25. Проверка — запись о покупке +30 bal.");
        WebElement purchaseRecord201 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Sotib olish') and contains(@content-desc, '+ 30 bal')]")
        ));
        Assert.assertTrue(purchaseRecord201.isDisplayed(), "Запись +30 bal не найдена");
        System.out.println("✅ Запись +30 bal найдена");

        Thread.sleep(2000);

        System.out.println("26. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
        Thread.sleep(1000);











        System.out.println("27. Клик — T Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("T Market"))).click();
        Thread.sleep(1000);

        System.out.println("8. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        System.out.println("8. olib ketish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Olib ketish\nBepul\n2 varaqdan 2"))).click();
        Thread.sleep(1000);

        System.out.println("10. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Yetkazib berish punktini tanlash')]")
        )).click();

        Thread.sleep(5000);

        System.out.println("31. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Map Marker\").instance(0)"))).click();

        Thread.sleep(5000);

        System.out.println("33. Клик — Ushbu punktni tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ushbu punktni tanlash\nUshbu punktni tanlash"))).click();
        Thread.sleep(1000);

        System.out.println("34. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Toshkent shahri, Sergeli tumani, 6-massiv, 47')]")
        ));
        Assert.assertTrue(pickupSet1.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        System.out.println("35. Клик — instance 16.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();
        Thread.sleep(1000);

        System.out.println("36. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        System.out.println("Клик — кешбек (Switch).");

        WebElement switchBtn1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")")
        ));
        switchBtn1.click();

        System.out.println("Проверка — отображается Kartadan yechib olish.");
        WebElement kartadanTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Kartadan yechib olish')]")
        ));
        System.out.println("✅ Элемент 'Kartadan yechib olish' успешно найден на экране!");



// 4. Кликаем кнопку оплаты
        System.out.println("Клик — кнопка оплаты (To'lash).");
        WebElement payWithCashbackPickupBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
        payWithCashbackPickupBtn.click();


        System.out.println("37. Проверка — Ilovani baholang.");
        WebElement rateAppDialogPickupCashback = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateAppDialogPickupCashback.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");
        Thread.sleep(2000);

        System.out.println("22. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(2000);

        System.out.println("23. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

        System.out.println("Проверка — начислено ровно + 20 bal за покупку.");

        WebElement pointsRecor3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Sotib olish') and contains(@content-desc, '+ 20 bal')]")
        ));

        System.out.println("✅ Запись о начислении + 20 bal успешно найдена!");

        System.out.println("26. Клик — иконка (instance 0).");
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