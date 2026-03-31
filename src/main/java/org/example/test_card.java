package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
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

public class test_card {

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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ─── АВТОРИЗАЦИЯ ────────────────────────────────────────────────────────────

        // 1. Клик — «Ro'yxatdan o'tish»
        System.out.println("1. Клик — Ro'yxatdan o'tish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ro'yxatdan o'tish\nRo'yxatdan o'tish"))).click();
        Thread.sleep(1000);

        // 2. Клик — экран ввода телефона
        System.out.println("2. Клик — Telefon raqamingiz.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Telefon raqamingiz\n2 varaqdan 1"))).click();
        Thread.sleep(1000);

        // 3. Ввод номера телефона.
        System.out.println("3. Ввод номера телефона.");
        By phoneLocator = AppiumBy.xpath("//android.widget.EditText[contains(@text, '+998')]");
        wait.until(ExpectedConditions.elementToBeClickable(phoneLocator)).click();
        Thread.sleep(1000);
        WebElement activePhoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneLocator));
        activePhoneInput.clear();
        activePhoneInput.sendKeys("004188048");

        // 4. Клик — кнопка подтверждения номера
        System.out.println("4. Клик — кнопка подтверждения номера.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(11)"))).click();
        Thread.sleep(1000);

        // 5. Клик — «Kod yuborish»
        System.out.println("5. Клик — Kod yuborish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Kod yuborish\nKod yuborish"))).click();
        Thread.sleep(1000);

        // 6. Ввод кода «111111»
        System.out.println("6. Ввод кода 111111.");
        By codeLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
        wait.until(ExpectedConditions.elementToBeClickable(codeLocator)).click();
        Thread.sleep(500);
        WebElement activeCodeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(codeLocator));
        activeCodeInput.clear();
        activeCodeInput.sendKeys("111111");

        // ─── БЛОК 1: ПОКУПКА С ДОСТАВКОЙ ────────────────────────────────────────────

        // Пауза 5 сек перед шагом 7 (ожидание загрузки после входа)
        Thread.sleep(5000);

        // 7. Клик — Turon Market
        System.out.println("7. Клик — Turon Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Turon Market"))).click();
        Thread.sleep(1000);

        // 8. Клик — товар «planshet12345678»
        System.out.println("8. Клик — planshet12345678.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("planshet12345678"))).click();
        Thread.sleep(1000);

        // 9. Клик — кнопка добавления в корзину (instance 16)
        System.out.println("9. Клик — кнопка добавления в корзину.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();


        // 10. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("10. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();


        // 11. Клик — кнопка выбора адреса
        System.out.println("11. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).click();
        Thread.sleep(5000);

        // 12. Клик — «Tasdiqlash»
        System.out.println("12. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        // 13. Ввод текста в поле 0 — «testйцуе123»
        System.out.println("13. Ввод текста в поле 0.");
        WebElement field0 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")));
        field0.click();
        Thread.sleep(1000);
        field0.sendKeys("testйцуе123");

        // 14. Ввод текста в поле 1 — «testйцуе123»
        System.out.println("14. Ввод текста в поле 1.");
        WebElement field1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")));
        field1.click();
        Thread.sleep(1000);
        field1.sendKeys("testйцуе123");

        // 15. Ввод текста в поле 2 — «testйцуе123»
        System.out.println("15. Ввод текста в поле 2.");
        WebElement field2 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)")));
        field2.click();
        Thread.sleep(1000);
        field2.sendKeys("testйцуе123");

        // 16. Проверка — надпись «Turon Team location»
        System.out.println("16. Проверка — Turon Team location.");
        WebElement locationLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Turon Team location")));
        Assert.assertTrue(locationLabel.isDisplayed(), "Turon Team location не найден");
        System.out.println("✅ Turon Team location найден");

        // 17. Клик — «Tasdiqlash»
        System.out.println("17. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        // 18. Проверка — адрес доставки установлен
        System.out.println("18. Проверка — адрес доставки.");
        WebElement deliveryAddr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Yetkazib berish manzili\nTuron Team location   \nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddr.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        // 19. Клик — «To'lash»
        System.out.println("19. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                        "To'lash\")"))).click();
        Thread.sleep(1000);

        // 20. Клик — кнопка оплаты 3 000 UZS
        System.out.println("20. Клик — To'lash 3 000 UZS.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\n3 000 UZS"))).click();
        Thread.sleep(1000);

        // 21. Проверка — диалог оценки приложения
        System.out.println("21. Проверка — Ilovani baholang.");
        WebElement rateDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        // 22. Клик — «Asosiy sahifaga» (на главную)
        System.out.println("22. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(1000);

        // 23. Обновление (свайп-рефреш)
        System.out.println("23. Обновление страницы.");
        driver.navigate().back();
        driver.navigate().back();

        // 24. Проверка — карточка кешбека отображается
        System.out.println("24. Проверка — карточка кешбека.");
        WebElement cashbackCard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]")
        ));
        Assert.assertTrue(cashbackCard.isDisplayed(), "Карточка кешбека не найдена");
        System.out.println("✅ Карточка кешбека найдена");

        // 25. Проверка — запись о покупке (+ 30 bal)
        System.out.println("25. Проверка — запись о покупке +30 bal.");
        WebElement purchaseRecord20 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Sotib olish') and contains(@content-desc, '+ 30 bal')]")
        ));
        Assert.assertTrue(purchaseRecord20.isDisplayed(), "Запись +30 bal не найдена");
        System.out.println("✅ Запись +30 bal найдена");

        // ─── БЛОК 2: ПОКУПКА С САМОВЫВОЗОМ ──────────────────────────────────────────

        // 26. Клик — профиль / иконка (instance 0)
        System.out.println("26. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
        Thread.sleep(1000);

        // 27. Клик — T Market
        System.out.println("27. Клик — T Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("T Market"))).click();
        Thread.sleep(1000);

        // 28. Ввод поиска «planshet12345678»
        System.out.println("28. Ввод поиска planshet12345678.");
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")));
        searchInput.click();
        Thread.sleep(1000);
        searchInput.sendKeys("planshet12345678");

        // 29. Проверка — вкладка самовывоза
        System.out.println("29. Проверка — вкладка Olib ketish.");
        WebElement pickupTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Olib ketish\nBepul\n2 varaqdan 2")));
        Assert.assertTrue(pickupTab.isDisplayed(), "Вкладка самовывоза не найдена");
        System.out.println("✅ Вкладка самовывоза найдена");

        // 30. Клик — «Yetkazib berish punktini tanlash»
        System.out.println("30. Клик — Yetkazib berish punktini tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Yetkazib berish punkti tanlanmagan\nYetkazib berish punktini tanlash\nYetkazib berish punktini tanlash"))).click();
        Thread.sleep(1000);

        // 31. Клик — маркер на карте (instance 1)
        System.out.println("31. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Map Marker\").instance(1)"))).click();
        Thread.sleep(1000);

        // 32. Проверка — адрес пункта самовывоза
        System.out.println("32. Проверка — адрес пункта самовывоза.");
        WebElement pickupAddr = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Mo'ljal: Toshkent sh., Uchtepa tumani, 15-kvartal, 14-uy")));
        Assert.assertTrue(pickupAddr.isDisplayed(), "Адрес пункта не найден");
        System.out.println("✅ Адрес пункта самовывоза найден");

        // 33. Клик — «Ushbu punktni tanlash»
        System.out.println("33. Клик — Ushbu punktni tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ushbu punktni tanlash\nUshbu punktni tanlash"))).click();
        Thread.sleep(1000);

        // 34. Проверка — пункт самовывоза установлен
        System.out.println("34. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Olib ketish punkti\nToshkent sh., Uchtepa tumani, 15-kvartal, 14-uy\nOlib ketish punktini o'zgartirish\"\nOlib ketish punktini o'zgartirish\"")));
        Assert.assertTrue(pickupSet.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        // 35. Клик — кнопка (instance 16)
        System.out.println("35. Клик — instance 16.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();
        Thread.sleep(1000);

        // 36. Клик — «To'lash»
        System.out.println("36. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        // 37. Проверка — сумма к оплате 2 000 UZS
        System.out.println("37. Проверка — сумма 2 000 UZS.");
        WebElement payAmount2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("To'lash\n2 000 UZS")));
        Assert.assertTrue(payAmount2.isDisplayed(), "Сумма 2 000 UZS не найдена");
        System.out.println("✅ Сумма 2 000 UZS отображается");

        // 38. Проверка — оплата прошла
        System.out.println("38. Проверка — Toʻlov amalga oshirildi.");
        WebElement paySuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Toʻlov amalga oshirildi")));
        Assert.assertTrue(paySuccess.isDisplayed(), "Подтверждение оплаты не найдено");
        System.out.println("✅ Оплата подтверждена");

        // 39. Клик — «Asosiy sahifaga»
        System.out.println("39. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(1000);

        // 40. Обновление
        System.out.println("40. Обновление страницы.");
        driver.navigate().back();
        driver.navigate().back();

        // 41. Проверка — карточка кешбека
        System.out.println("41. Проверка — карточка кешбека.");
        WebElement cashbackCard2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]")
        ));
        Assert.assertTrue(cashbackCard2.isDisplayed(), "Карточка кешбека не найдена");
        System.out.println("✅ Карточка кешбека найдена");

        // 42. Проверка — запись о покупке (+ 10 bal)
        System.out.println("42. Проверка — запись о покупке +10 bal.");
        WebElement purchaseRecord10 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Sotib olish') and contains(@content-desc, '+ 10 bal')]")
        ));
        Assert.assertTrue(purchaseRecord10.isDisplayed(), "Запись +10 bal не найдена");
        System.out.println("✅ Запись +10 bal найдена");

        // ─── БЛОК 3: ПОКУПКА С ОПЛАТОЙ КЕШБЕКОМ ────────────────────────────────────

        // 43. Клик — иконка (instance 0)
        System.out.println("43. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
        Thread.sleep(1000);

        // 44. Клик — Turon Market
        System.out.println("44. Клик — Turon Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Turon Market"))).click();
        Thread.sleep(1000);

        // 45. Клик — товар «ONU GPON»
        System.out.println("45. Клик — ONU GPON.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("ONU GPON"))).click();
        Thread.sleep(1000);

        // 46. Клик — кнопка добавления (instance 22)
        System.out.println("46. Клик — кнопка добавления в корзину.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(22)"))).click();
        Thread.sleep(1000);

        // 47. Клик — «Ko'rsatish»
        System.out.println("47. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Yetkazib berish manzili ko'rsatilmagan\nKo'rsatish\nKo'rsatish"))).click();
        Thread.sleep(1000);

        // 48. Клик — кнопка адреса
        System.out.println("48. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).click();
        Thread.sleep(1000);

        // 49. Клик — «Tasdiqlash»
        System.out.println("49. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        // 50. Клик — «To'lash»
        System.out.println("50. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        // 51. Клик — переключатель кешбека
        System.out.println("51. Клик — переключатель кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")"))).click();
        Thread.sleep(1000);

        // 52. Проверка — надпись «Keshbekdan»
        System.out.println("52. Проверка — Keshbekdan.");
        WebElement keshbekLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Keshbekdan")));
        Assert.assertTrue(keshbekLabel.isDisplayed(), "Надпись Keshbekdan не найдена");
        System.out.println("✅ Надпись Keshbekdan найдена");

        // 53. Клик — оплатить (кнопка с суммой UZS)
        System.out.println("53. Клик — оплатить с кешбеком.");
        WebElement payButton53 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
        payButton53.click();
        Thread.sleep(1000);

        // 54. Проверка — диалог оценки
        System.out.println("54. Проверка — Ilovani baholang.");
        WebElement rateDialog2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog2.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        // 55. Клик — «Asosiy sahifaga»
        System.out.println("55. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(1000);

        // ─── БЛОК 4: САМОВЫВОЗ С КЕШБЕКОМ ───────────────────────────────────────────

        // 56. Клик — T Market
        System.out.println("56. Клик — T Market.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("T Market"))).click();
        Thread.sleep(1000);

        // 57. Ввод поиска «planshet12345678»
        System.out.println("57. Ввод поиска planshet12345678.");
        WebElement searchInput2 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")));
        searchInput2.click();
        Thread.sleep(1000);
        searchInput2.sendKeys("planshet12345678");

        // 58. Проверка — вкладка самовывоза
        System.out.println("58. Проверка — вкладка Olib ketish.");
        WebElement pickupTab2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Olib ketish\nBepul\n2 varaqdan 2")));
        Assert.assertTrue(pickupTab2.isDisplayed(), "Вкладка самовывоза не найдена");
        System.out.println("✅ Вкладка самовывоза найдена");

        // 59. Клик — маркер на карте (instance 1)
        System.out.println("59. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Map Marker\").instance(1)"))).click();
        Thread.sleep(1000);

        // 60. Проверка — адрес пункта самовывоза
        System.out.println("60. Проверка — адрес пункта самовывоза.");
        WebElement pickupAddr2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Mo'ljal: Toshkent sh., Uchtepa tumani, 15-kvartal, 14-uy")));
        Assert.assertTrue(pickupAddr2.isDisplayed(), "Адрес пункта не найден");
        System.out.println("✅ Адрес пункта самовывоза найден");

        // 61. Проверка — пункт самовывоза установлен
        System.out.println("61. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Olib ketish punkti\nToshkent sh., Uchtepa tumani, 15-kvartal, 14-uy\nOlib ketish punktini o'zgartirish\"\nOlib ketish punktini o'zgartirish\"")));
        Assert.assertTrue(pickupSet2.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        // 62. Клик — «To'lash»
        System.out.println("62. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("To'lash\nTo'lash"))).click();
        Thread.sleep(1000);

        // 63. Клик — переключатель кешбека
        System.out.println("63. Клик — переключатель кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")"))).click();
        Thread.sleep(1000);

        // 64. Клик — оплатить (кнопка с суммой UZS)
        System.out.println("64. Клик — оплатить с кешбеком.");
        WebElement payButton64 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
        payButton64.click();
        Thread.sleep(1000);

        // 65. Проверка — надпись «Keshbekdan»
        System.out.println("65. Проверка — Keshbekdan.");
        WebElement keshbekLabel2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Keshbekdan")));
        Assert.assertTrue(keshbekLabel2.isDisplayed(), "Надпись Keshbekdan не найдена");
        System.out.println("✅ Надпись Keshbekdan найдена");

        // 66. Финальная оплата (кнопка с суммой UZS)
        System.out.println("66. Финальная оплата.");
        WebElement payButton66 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
        payButton66.click();
        Thread.sleep(1000);

        // 67. Проверка — диалог оценки
        System.out.println("67. Проверка — Ilovani baholang.");
        WebElement rateDialog3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.accessibilityId("Ilovani baholang\nIlovani baholang")));
        Assert.assertTrue(rateDialog3.isDisplayed(), "Диалог оценки не появился");
        System.out.println("✅ Диалог оценки появился");

        // 68. Клик — «Asosiy sahifaga»
        System.out.println("68. Клик — Asosiy sahifaga.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Asosiy sahifaga\nAsosiy sahifaga"))).click();
        Thread.sleep(1000);

        System.out.println("✅ Тест завершён успешно!");
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
