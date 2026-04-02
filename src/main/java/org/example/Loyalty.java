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
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();

        // 4. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("4. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();

        Thread.sleep(5000);

        System.out.println("5. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).click();
        Thread.sleep(5000);

        System.out.println("6. Клик — Tasdiqlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Tasdiqlash\nTasdiqlash"))).click();
        Thread.sleep(1000);

        System.out.println("7. Ввод текста в поле 0.");
        WebElement addressField0 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")));
        addressField0.click();
        Thread.sleep(1000);
        addressField0.sendKeys("testйцуе123");
        Thread.sleep(1000);

        // 8. Ввод текста в поле 1 — «testйцуе123»
        System.out.println("8. Ввод текста в поле 1.");
        WebElement addressField1 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")));
        addressField1.click();
        Thread.sleep(1000);
        addressField1.sendKeys("testйцуе123");
        Thread.sleep(1000);


        // 9. Ввод текста в поле 2 — «testйцуе123»
        System.out.println("9. Ввод текста в поле 2.");
        WebElement addressField2 = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)")));
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
                AppiumBy.accessibilityId("Yetkazib berish manzili\nTuron Team location testйцуе123 testйцуе123 testйцуе123\nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddressLabel.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        Thread.sleep(5000);

        System.out.println("13. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                        "To'lash\")"))).click();
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

        System.out.println("17. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);



        System.out.println("18. Проверка — ищем самую первую транзакцию + 30 bal под 2026 годом.");

        WebElement targetRecord = wait.until(ExpectedConditions.visibilityOfElementLocated(
                // Ищем 2026 -> спускаемся к соседям с '+ 30' -> берем строго первого [1]
                AppiumBy.xpath("(//*[contains(@content-desc, '04.2026')]/following-sibling::*[contains(@content-desc, '+ 30')])[1]")
        ));

        System.out.println("✅ Самая первая запись + 30 bal под 2026 годом успешно найдена!");

        Thread.sleep(2000);

        System.out.println("19. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
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
                AppiumBy.accessibilityId("Olib ketish\nBepul\n2 varaqdan 2"))).click();
        Thread.sleep(1000);

        System.out.println("23. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Yetkazib berish punktini tanlash')]")
        )).click();

        Thread.sleep(5000);

        System.out.println("24. Клик — маркер на карте.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Map Marker\").instance(0)"))).click();

        Thread.sleep(5000);

        System.out.println("25. Клик — Ushbu punktni tanlash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Ushbu punktni tanlash\nUshbu punktni tanlash"))).click();
        Thread.sleep(1000);

        System.out.println("26. Проверка — пункт самовывоза установлен.");
        WebElement pickupSet = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Toshkent shahri, Sergeli tumani, 6-massiv, 47')]")
        ));
        Assert.assertTrue(pickupSet.isDisplayed(), "Пункт самовывоза не установлен");
        System.out.println("✅ Пункт самовывоза установлен");

        System.out.println("27. Клик — instance 16.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();
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

        System.out.println("32. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

        System.out.println("33. Проверка — ищем самую первую транзакцию + 30 bal под 2026 годом.");

        WebElement targetRecord1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                // Ищем 2026 -> спускаемся к соседям с '+ 30' -> берем строго первого [1]
                AppiumBy.xpath("(//*[contains(@content-desc, '04.2026')]/following-sibling::*[contains(@content-desc, '+ 30')])[1]")
        ));

        System.out.println("✅ Самая первая запись + 30 bal под 2026 годом успешно найдена!");

        System.out.println("34. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
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
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(16)"))).click();

        // 38. Клик — «Ko'rsatish» (указать адрес доставки)
        System.out.println("38. Клик — Ko'rsatish.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'rsatish')]"))).click();

        Thread.sleep(5000);

        System.out.println("39. Клик — кнопка выбора адреса.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"))).click();
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
                AppiumBy.accessibilityId("Yetkazib berish manzili\nTuron Team location   \nBoshqasini tanlash\nBoshqasini tanlash")));
        Assert.assertTrue(deliveryAddr1.isDisplayed(), "Адрес доставки не отображается");
        System.out.println("✅ Адрес доставки подтверждён");

        Thread.sleep(5000);

        System.out.println("44. Клик — To'lash.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"To'lash\n" +
                        "To'lash\")"))).click();
        Thread.sleep(1000);

        System.out.println("45. Клик — кешбек (Switch).");

        WebElement switchBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")")
        ));
        switchBtn.click();

        System.out.println("46. Проверка — отображается Keshbekdan.");
        WebElement keshbekdanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[contains(@content-desc, 'Kartadan yechib olish')]")
        ));
        System.out.println("✅ Элемент 'Keshbekdan' успешно найден на экране!");

        System.out.println("--- ЧИТАЕМ СУММЫ ПЕРЕД ОПЛАТОЙ ---");

// 1. Находим элемент ПЕРЕД словом "UZS" (достанет "2 751")
        System.out.println("--- ЧИТАЕМ СУММЫ ПЕРЕД ОПЛАТОЙ ---");

// 1. Обязательная пауза: ждем, пока Flutter пересчитает суммы после включения кешбэка
        Thread.sleep(1000);

// 2. Ищем элемент ПЕРЕД словом "UZS", строго игнорируя пустые блоки Flutter (!= '')
        WebElement uzsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.view.View[@content-desc='UZS']/preceding-sibling::*[@content-desc != ''][1]")
        ));
        String rawUzs = uzsElement.getAttribute("content-desc");
// Выводим в консоль то, что нашли, чтобы если что, сразу видеть проблему
        System.out.println("DEBUG: Найденный текст для UZS: [" + rawUzs + "]");

        int totalUzs = Integer.parseInt(rawUzs.replaceAll("[^0-9]", ""));
        int X = totalUzs / 100; // Отрезаем лишнее, оставляем только нужный процент
        System.out.println("Сумма покупки: " + totalUzs + ", ожидаем кешбэк (X): " + X);

// 3. То же самое для потраченного кешбэка (tt)
        WebElement ttElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("(//android.view.View[@content-desc='tt'])[2]/preceding-sibling::*[@content-desc != ''][1]")
        ));
        String rawTt = ttElement.getAttribute("content-desc");
        System.out.println("DEBUG: Найденный текст для tt: [" + rawTt + "]");

        int Y = Integer.parseInt(rawTt.replaceAll("[^0-9]", ""));
        System.out.println("Потраченный кешбэк (Y): " + Y);


        System.out.println("47. Клик — кнопка оплаты (To'lash).");
        WebElement payBtn = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, \"To'lash\") and contains(@content-desc, 'UZS')]")
        ));
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

        System.out.println("50. Проверка — кешбека.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//*[contains(@content-desc, 'Butun vaqt davomida') and contains(@content-desc, 'Keshbek balansi')]"))).click();
        Thread.sleep(2000);

        System.out.println("--- ПРОВЕРКА ИСТОРИИ (ПО ДАТЕ 04.2026) ---");

// 51. Проверяем начисление (X) во вкладке по умолчанию (Daromadlar)
        System.out.println("51. Проверка — ищем начисление: " + X);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                // Ищем любой день в 04.2026 -> спускаемся к первой записи -> ищем там наш X
                AppiumBy.xpath("(//*[contains(@content-desc, '04.2026')]/following-sibling::*[contains(@content-desc, '" + X + "')])[1]")
        ));
        System.out.println("✅ Начисление " + X + " успешно найдено в Daromadlar!");


// 52. Кликаем на вкладку Xarajatlar (Расходы)
        System.out.println("52. Клик — вкладка Xarajatlar.");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("Xarajatlar\n2 varaqdan 2")
        )).click();

// Обязательная пауза, чтобы Flutter успел перерисовать список (иначе найдет старые записи)
        Thread.sleep(1000);


// 53. Проверяем списание (Y) во вкладке Xarajatlar
        System.out.println("53. Проверка — ищем списание: " + Y);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                // Снова опираемся на 04.2026 и ищем первую запись с Y
                AppiumBy.xpath("(//*[contains(@content-desc, '04.2026')]/following-sibling::*[contains(@content-desc, '" + Y + "')])[1]")
        ));
        System.out.println("✅ Списание " + Y + " успешно найдено в Xarajatlar!");

        Thread.sleep(2000);

        System.out.println("54. Клик — иконка (instance 0).");
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"))).click();
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
