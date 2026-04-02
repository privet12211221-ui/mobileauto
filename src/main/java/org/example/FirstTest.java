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

public class FirstTest {

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

















        }
        @AfterTest
        public void close() {
                if (driver != null) {
                        driver.quit();
                }
        }
}