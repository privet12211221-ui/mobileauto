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
                                .setCapability("autoGrantPermissions", true);

                driver = new AndroidDriver(URI.create(appiumServerUrl).toURL(), options);
        }

        @Test
        public void test() {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // 1. click o'zbekcha
                System.out.println("1. Клик — выбор Узбекского языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

                // 2. click русский
                System.out.println("2. Клик — выбор Русского языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

                // 3. проверим что кнопка "продолжить" кнопка есть
                System.out.println("3. Проверка — появление кнопки «Продолжить».");
                WebElement btnRussian = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Продолжить')]")));
                Assert.assertTrue(btnRussian.isDisplayed(), "Кнопка 'Продолжить' не найдена");
                System.out.println("✅ Кнопка 'Продолжить' найдена");

                // 4. click русский
                System.out.println("4. Клик — выбор Русского языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

                // 5. click english
                System.out.println("5. Клик — выбор Английского языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();

                // 6. проверим что кнопка "continue" кнопка есть
                System.out.println("6. Проверка — появление кнопки «Continue».");
                WebElement btnEnglish = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Continue')]")));
                Assert.assertTrue(btnEnglish.isDisplayed(), "Кнопка 'Continue' не найдена");
                System.out.println("✅ Кнопка 'Continue' найдена");

                // 7. click english
                System.out.println("7. Клик — выбор Английского языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();

                // 8. click o'zbekcha
                System.out.println("8. Клик — выбор Узбекского языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

                // 9. проверим что кнопка "davom etish" кнопка есть
                System.out.println("9. Проверка — появление кнопки «Davom etish».");
                WebElement btnUzbek = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Davom etish')]")));
                Assert.assertTrue(btnUzbek.isDisplayed(), "Кнопка 'Davom etish' не найдена");
                System.out.println("✅ Кнопка 'Davom etish' найдена");

                // 10. click davom etish
                System.out.println("10. Клик — нажатие «Davom etish».");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Davom etish')]"))).click();

                // 11. Разрешить доступ (Permission Allow) - НЕОБЯЗАТЕЛЬНО
                System.out.println("11. Клик — системное разрешение Android (Allow) - Проверка наличия.");
                try {
                        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        shortWait.until(ExpectedConditions.elementToBeClickable(
                                        AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")))
                                        .click();
                        System.out.println("✅ Разрешение предоставлено");
                } catch (Exception e) {
                        System.out.println("⚠️ Системное разрешение не появилось или уже предоставлено, продолжаем...");
                }

                // 12. click "Men oddiy foydalanuvchiman" - НЕОБЯЗАТЕЛЬНО
                System.out.println("12. Клик — выбор роли «Обычный пользователь» - Проверка наличия.");
                try {
                        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                        shortWait.until(ExpectedConditions.elementToBeClickable(
                                        AppiumBy.xpath("//android.view.View[@content-desc=\"Men oddiy foydalanuvchiman\\nMen oddiy foydalanuvchiman\"]")))
                                        .click();
                        System.out.println("✅ Роль выбрана");
                } catch (Exception e) {
                        System.out.println("⚠️ Выбор роли не появился, продолжаем...");
                }

                // 13. Продолжение (Next Action)
                System.out.println("13. Клик — кнопка «Далее» (переход).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")))
                                .click();

                // 14. проверка слов. должен быть "kirish"
                System.out.println("14. Проверка — появилась кнопка «Kirish».");
                WebElement btnKirish = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Kirish\\nKirish\"]")));
                Assert.assertTrue(btnKirish.isDisplayed(), "Кнопка 'Kirish' не найдена");
                System.out.println("✅ Кнопка 'Kirish' найдена");

                // 15. click "Til O'zbekcha"
                System.out.println("15. Клик — открытие меню языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Til\\nO'zbekcha\"]"))).click();

                System.out.println("16. Клик — выбираем Русский.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();

                // Проверка — кнопка изменилась на «Войти».
                System.out.println("17. Проверка — кнопка изменилась на «Войти».");
                WebElement btnVojti = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Войти\\nВойти\"]")));
                Assert.assertTrue(btnVojti.isDisplayed(), "Кнопка 'Войти' не найдена");
                System.out.println("✅ Кнопка 'Войти' найдена");

                // Клик — открытие меню языка.
                System.out.println("18. Клик — открытие меню языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Язык\\nРусский\"]"))).click();

                // Клик — выбираем Узбекский.
                System.out.println("19. Клик — выбираем Узбекский.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O’zbekcha\"]"))).click();

                // Проверка — кнопка вернулась на «Kirish».
                System.out.println("20. Проверка — кнопка вернулась на «Kirish».");
                WebElement btnKirish2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Kirish\\nKirish\"]")));
                Assert.assertTrue(btnKirish2.isDisplayed(), "Кнопка 'Kirish' не найдена");
                System.out.println("✅ Кнопка 'Kirish' снова найдена");

                // --- Блок 3: Информационные разделы (FAQ и О приложении) ---
                // Клик — раздел «Savol-javoblar» (Вопросы и ответы).
                System.out.println("21. Клик — раздел «Savol-javoblar» (Вопросы и ответы).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Savol-javoblar\"]"))).click();

                // Ввод текста — пишем слово "paroli".
                System.out.println("22. Ввод текста — пишем слово \"paroli\".");
                WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.EditText")));
                searchField.click();
                searchField.sendKeys("paroli");

                // Проверка — появился ли вопрос в поиске.
                System.out.println("23. Проверка — появился ли вопрос в поиске.");
                WebElement faqQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Shaxsiy kabinet parolini qanday bilishim mumkin?\"]")));
                Assert.assertTrue(faqQuestion.isDisplayed());

                // Клик — по найденному вопросу.
                System.out.println("24. Клик — по найденному вопросу.");
                faqQuestion.click();

                // Проверка — текст ответа про пароль.
                System.out.println("25. Проверка — текст ответа про пароль.");
                WebElement faqAnswer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Shaxsiy kabinet parolini qanday bilishim mumkin?\\nAgar siz shaxsiy kabinet parolini unutgan bo'lsangiz, 1132 raqamiga qo'ng'iroq qiling...\"]")));
                Assert.assertTrue(faqAnswer.isDisplayed());

                // Клик — кнопка «Orqaga» (Назад).
                System.out.println("26. Клик — кнопка «Orqaga» (Назад).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.Button[@content-desc=\"Orqaga\"]"))).click();

                // Клик — раздел «Ilova haqida» (О приложении).
                System.out.println("27. Клик — раздел «Ilova haqida» (О приложении).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Ilova haqida\"]"))).click();

                // Проверка — версия приложения.
                System.out.println("28. Проверка — версия приложения.");
                WebElement appVersion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Ilova versiyasi\\n3.65.0(124)\"]")));
                Assert.assertTrue(appVersion.isDisplayed());

                // Клик (Системный) — физическая кнопка Назад (Back).
                System.out.println("29. Клик (Системный) — физическая кнопка Назад (Back).");
                driver.navigate().back();

                // Клик (Системный) — физическая кнопка Назад (Back).
                System.out.println("30. Клик (Системный) — физическая кнопка Назад (Back).");
                driver.navigate().back();

                // --- Блок 4: Чат, Маркет и Формы ---
                // Клик — открытие чата/меню.
                System.out.println("31. Клик — открытие чата/меню.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[1]")))
                                .click();

                // Клик — раздел «Turon Market».
                System.out.println("32. Клик — раздел «Turon Market».");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Turon Market\"]"))).click();

                // Ввод текста — пишем "test" в первое поле.
                System.out.println("33. Ввод текста — пишем \"test\" в первое поле.");
                WebElement fieldTest = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
                fieldTest.sendKeys("test");

                // Ввод текста — пишем "00123456" в поле телефона.
                System.out.println("34. Ввод текста — пишем \"00123456\" в поле телефона.");
                WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.EditText[@text=\"+998\"]")));
                phoneField.sendKeys("00123456");

                // Проверка — кнопка «Yuborish» заблокирована (clickable=false).
                System.out.println("35. Проверка — кнопка «Yuborish» заблокирована (clickable=false).");
                WebElement btnSend = driver.findElement(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Yuborish\\nYuborish\"]"));
                Assert.assertEquals(btnSend.getAttribute("clickable"), "false");

                // Ввод текста — пишем правильный номер.
                System.out.println("36. Ввод текста — пишем правильный номер.");
                phoneField.clear();
                phoneField.sendKeys(" 00 123 45 67"); // Results in +998 00 123 45 67

                // Клик — кнопка «Yuborish» (Отправить).
                System.out.println("37. Клик — кнопка «Yuborish» (Отправить).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Yuborish\\nYuborish\"]"))).click();

                // Клик — раздел «Operator bilan aloqa» (Связь с оператором).
                System.out.println("38. Клик — раздел «Operator bilan aloqa» (Связь с оператором).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Operator bilan aloqa\"]"))).click();

                // Ввод текста — пишем "test123!@#йцуйц".
                System.out.println("39. Ввод текста — пишем \"test123!@#йцуйц\".");
                WebElement chatInput = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.EditText")));
                chatInput.sendKeys("test123!@#йцуйц");

                // Клик — отправить сообщение (иконка стрелочки).
                System.out.println("40. Клик — отправить сообщение (иконка стрелочки).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView[2]")))
                                .click();

                // Проверка — сообщение появилось в истории.
                System.out.println("41. Проверка — сообщение появилось в истории.");
                WebElement chatMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//android.view.View[contains(@content-desc, 'test123!@#йцуйц')]")));
                Assert.assertTrue(chatMessage.isDisplayed());

                // Клик — дополнительная кнопка в чате (скрепка/назад).
                System.out.println("42. Клик — дополнительная кнопка в чате (скрепка/назад).");
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
