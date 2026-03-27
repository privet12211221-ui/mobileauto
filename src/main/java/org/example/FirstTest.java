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
                                .setApp(System.getProperty("user.dir") + "/app/t36.apk");

                driver = new AndroidDriver(URI.create(appiumServerUrl).toURL(), options);
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
                WebElement btnRussian = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Продолжить')]")));
                Assert.assertTrue(btnRussian.isDisplayed(), "Кнопка 'Продолжить' не найдена");
                System.out.println("✅ Кнопка 'Продолжить' найдена");

                // 4. click русский
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

                // 5. click english
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();

                // 6. проверим что кнопка "continue" кнопка есть
                WebElement btnEnglish = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Continue')]")));
                Assert.assertTrue(btnEnglish.isDisplayed(), "Кнопка 'Continue' не найдена");
                System.out.println("✅ Кнопка 'Continue' найдена");

                // 7. click english
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();

                // 8. click o'zbekcha
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

                // 9. проверим что кнопка "davom etish" кнопка есть
                WebElement btnUzbek = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Davom etish')]")));
                Assert.assertTrue(btnUzbek.isDisplayed(), "Кнопка 'Davom etish' не найдена");
                System.out.println("✅ Кнопка 'Davom etish' найдена");

                // 10. click davom etish
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Davom etish')]"))).click();

                // 11. Разрешить доступ (Permission Allow)
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")))
                                .click();

                // 12. click "Men oddiy foydalanuvchiman"
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Men oddiy foydalanuvchiman\\nMen oddiy foydalanuvchiman\"]")))
                                .click();

                // 13. Продолжение (Next Action)
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")))
                                .click();

                // 14. проверка слов. должен быть "kirish"
                WebElement btnKirish = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Kirish\\nKirish\"]")));
                Assert.assertTrue(btnKirish.isDisplayed(), "Кнопка 'Kirish' не найдена");
                System.out.println("✅ Кнопка 'Kirish' найдена");

                // 15. click "Til O'zbekcha"
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Til\\nO'zbekcha\"]"))).click();

                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

                // Проверка — кнопка изменилась на «Войти».
                WebElement btnVojti = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Войти\\nВойти\"]")));
                Assert.assertTrue(btnVojti.isDisplayed(), "Кнопка 'Войти' не найдена");
                System.out.println("✅ Кнопка 'Войти' найдена");

                // Клик — открытие меню языка.
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Язык\\nРусский\"]"))).click();

                // Клик — выбираем Узбекский.
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

                // Проверка — кнопка вернулась на «Kirish».
                WebElement btnKirish2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Kirish\\nKirish\"]")));
                Assert.assertTrue(btnKirish2.isDisplayed(), "Кнопка 'Kirish' не найдена");
                System.out.println("✅ Кнопка 'Kirish' снова найдена");

                // --- Блок 3: Информационные разделы (FAQ и О приложении) ---
                // Клик — раздел «Savol-javoblar» (Вопросы и ответы).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Savol-javoblar\"]"))).click();

                // Ввод текста — пишем слово "paroli".
                WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.EditText")));
                searchField.click();
                searchField.sendKeys("paroli");

                // Проверка — появился ли вопрос в поиске.
                WebElement faqQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Shaxsiy kabinet parolini qanday bilishim mumkin?\"]")));
                Assert.assertTrue(faqQuestion.isDisplayed());

                // Клик — по найденному вопросу.
                faqQuestion.click();

                // Проверка — текст ответа про пароль.
                WebElement faqAnswer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Shaxsiy kabinet parolini qanday bilishim mumkin?\\nAgar siz shaxsiy kabinet parolini unutgan bo'lsangiz, 1132 raqamiga qo'ng'iroq qiling...\"]")));
                Assert.assertTrue(faqAnswer.isDisplayed());

                // Клик — кнопка «Orqaga» (Назад).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.Button[@content-desc=\"Orqaga\"]"))).click();

                // Клик — раздел «Ilova haqida» (О приложении).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Ilova haqida\"]"))).click();

                // Проверка — версия приложения.
                WebElement appVersion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Ilova versiyasi\\n3.65.0(124)\"]")));
                Assert.assertTrue(appVersion.isDisplayed());

                // Клик (Системный) — физическая кнопка Назад (Back).
                driver.navigate().back();

                // Клик (Системный) — физическая кнопка Назад (Back).
                driver.navigate().back();

                // --- Блок 4: Чат, Маркет и Формы ---
                // Клик — открытие чата/меню.
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")))
                                .click();

                // Клик — раздел «Turon Market».
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Turon Market\"]"))).click();

                // Ввод текста — пишем "test" в первое поле.
                WebElement fieldTest = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
                fieldTest.sendKeys("test");

                // Ввод текста — пишем "00123456" в поле телефона.
                WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.EditText[@text=\"+998\"]")));
                phoneField.sendKeys("00123456");

                // Проверка — кнопка «Yuborish» заблокирована (clickable=false).
                WebElement btnSend = driver.findElement(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Yuborish\\nYuborish\"]"));
                Assert.assertEquals(btnSend.getAttribute("clickable"), "false");

                // Ввод текста — пишем правильный номер.
                phoneField.clear();
                phoneField.sendKeys(" 00 123 45 67"); // Results in +998 00 123 45 67

                // Клик — кнопка «Yuborish» (Отправить).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Yuborish\\nYuborish\"]"))).click();

                // Клик — раздел «Operator bilan aloqa» (Связь с оператором).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Operator bilan aloqa\"]"))).click();

                // Ввод текста — пишем "test123!@#йцуйц".
                WebElement chatInput = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.EditText")));
                chatInput.sendKeys("test123!@#йцуйц");

                // Клик — отправить сообщение (иконка стрелочки).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]")))
                                .click();

                // Проверка — сообщение появилось в истории.
                WebElement chatMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'test123!@#йцуйц')]")));
                Assert.assertTrue(chatMessage.isDisplayed());

                // Клик — дополнительная кнопка в чате (скрепка/назад).
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")))
                                .click();
        }

        @AfterTest
        public void close() {
                if (driver != null) {
                        driver.quit();
                }
        }
}
