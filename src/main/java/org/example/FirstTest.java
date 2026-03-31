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
                                .setNoReset(true)    // Не очищать кэш и данные приложения
                                .setFullReset(false); // Не удалять приложение перед тестом

                driver = new AndroidDriver(URI.create(appiumServerUrl).toURL(), options);
        }

        @Test
        public void test() {
                System.out.println("⏳ Тест запущен!");

                // Жестко закрываем и открываем приложение, чтобы оно оказалось на главной странице
                driver.terminateApp("com.turontelecom.app.demo"); // Закрываем
                driver.activateApp("com.turontelecom.app.demo");  // Открываем заново

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//                // 1. Клик — выбор Узбекского языка.
//                System.out.println("1. Клик — выбор Узбекского языка.");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O'zbekcha\"]"))).click();
//
//                // 2. Клик — выбор Русского языка.
//                System.out.println("2. Клик — выбор Русского языка.");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();
//
//                // 3. Проверка — появление кнопки «Продолжить».
//                System.out.println("3. Проверка — появление кнопки «Продолжить».");
//                WebElement btnRussian = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                                AppiumBy.accessibilityId("Продолжить\nПродолжить")));
//                Assert.assertTrue(btnRussian.isDisplayed(), "Кнопка 'Продолжить' не найдена");
//                System.out.println("✅ Кнопка 'Продолжить' найдена");
//
//                // 4. Клик — выбор Русского языка.
//                System.out.println("4. Клик — выбор Русского языка.");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Русский\"]"))).click();
//
//                // 5. Клик — выбор Английского языка.
//                System.out.println("5. Клик — выбор Английского языка.");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();
//
//                // 6. Проверка — появление кнопки «Continue».
//                System.out.println("6. Проверка — появление кнопки «Continue».");
//                WebElement btnEnglish = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                                AppiumBy.accessibilityId("Continue\nContinue")));
//                Assert.assertTrue(btnEnglish.isDisplayed(), "Кнопка 'Continue' не найдена");
//                System.out.println("✅ Кнопка 'Continue' найдена");
//
//                // 7. Клик — выбор Английского языка.
//                System.out.println("7. Клик — выбор Английского языка.");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"English\"]"))).click();
//
//                // 8. Клик — выбор Узбекского языка.
//                System.out.println("8. Клик — выбор Узбекского языка.");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"O'zbekcha\"]"))).click();
//
//                // 9. Проверка — появление кнопки «Davom etish».
//                System.out.println("9. Проверка — появление кнопки «Davom etish».");
//                WebElement btnUzbek = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                                AppiumBy.accessibilityId("Davom etish\nDavom etish")));
//                Assert.assertTrue(btnUzbek.isDisplayed(), "Кнопка 'Davom etish' не найдена");
//                System.out.println("✅ Кнопка 'Davom etish' найдена");

//                // 10. Клик — нажатие «Davom etish».
//                System.out.println("10. Клик — нажатие «Davom etish».");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.xpath("//android.view.View[@content-desc=\"Davom etish\n" +
//                                        "Davom etish\"]"))).click();
//
//
//
//                // 12. Клик — выбор роли «Обычный пользователь».
//                System.out.println("12. Клик — выбор роли «Обычный пользователь».");
//                wait.until(ExpectedConditions.elementToBeClickable(
//                                AppiumBy.accessibilityId("Men oddiy foydalanuvchiman\nMen oddiy foydalanuvchiman")))
//                                .click();

                // 13. Клик — кнопка «профиль» (переход).
                System.out.println("13. Клик — кнопка «профиль» (переход).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().className(\"android.widget.ImageView\").instance(0)")))
                                .click();

                // 14. Клик — раздел «Ilova haqida» (О приложении).
                System.out.println("14. Клик — раздел «Ilova haqida» (О приложении).");
                wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[contains(@content-desc, 'Ilova haqida')]"))).click();

                // 15. Проверка — версия приложения.
                System.out.println("15. Проверка — версия приложения.");
                WebElement appVersion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.accessibilityId("Ilova versiyasi\n3.64.0(124)")));
                Assert.assertTrue(appVersion.isDisplayed(), "Версия приложения не совпадает");
                System.out.println("✅ Версия приложения найдена");

                // 16. Клик (Системный) — физическая кнопка Назад (Back).
                System.out.println("16. Клик (Системный) — физическая кнопка Назад (Back).");
                driver.navigate().back();

                // 17. Клик — открытие меню языка.
                System.out.println("17. Клик — открытие меню языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Til\nO'zbekcha"))).click();

                // 18. Клик — выбираем Русский.
                System.out.println("18. Клик — выбираем Русский.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Русский"))).click();

                // 19. Проверка — кнопка изменилась на «Войти».
                System.out.println("19. Проверка — кнопка изменилась на «Войти».");
                WebElement btnVojti = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.accessibilityId("Войти\nВойти")));
                Assert.assertTrue(btnVojti.isDisplayed(), "Кнопка 'Войти' не найдена");
                System.out.println("✅ Кнопка 'Войти' найдена");

                // 20. Клик — открытие меню языка.
                System.out.println("20. Клик — открытие меню языка.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Язык\nРусский"))).click();

                // 21. Клик — выбираем Узбекский.
                System.out.println("21. Клик — выбираем Узбекский.");
                wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[contains(@content-desc, 'zbekcha')]")
                )).click();

                // 22. Проверка — кнопка вернулась на «Kirish».
                System.out.println("22. Проверка — кнопка вернулась на «Kirish».");
                WebElement btnKirish = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.accessibilityId("Kirish\nKirish")));
                Assert.assertTrue(btnKirish.isDisplayed(), "Кнопка 'Kirish' не найдена");
                System.out.println("✅ Кнопка 'Kirish' найдена");

                // 23. Клик — раздел «Savol-javoblar» (Вопросы и ответы).
                System.out.println("23. Клик — раздел «Savol-javoblar» (Вопросы и ответы).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Savol-javoblar"))).click();

                // 24. Ввод текста — пишем слово "paroli".
                System.out.println("24. Ввод текста — пишем слово \"paroli\".");
                WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().className(\"android.widget.EditText\")")));
                searchField.click();
                searchField.sendKeys("paroli");

                // 25. Клик — по найденному вопросу.
                System.out.println("25. Клик — по найденному вопросу.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Shaxsiy kabinet parolini qanday bilishim mumkin?"))).click();

                // 26. Проверка — текст ответа про пароль.
                System.out.println("26. Проверка — текст ответа про пароль.");
                WebElement faqAnswer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.accessibilityId(
                                                "Shaxsiy kabinet parolini qanday bilishim mumkin?\nAgar siz shaxsiy kabinet parolini unutgan bo'lsangiz, 1132 raqamiga qo'ng'iroq qiling. F.I.O., login va shartnoma egasining pasport seriyasini aniqlang, va biz parolni standart holatga qaytarib beramiz.")));
                Assert.assertTrue(faqAnswer.isDisplayed(), "Ответ на вопрос про пароль не найден");
                System.out.println("✅ Ответ на вопрос про пароль найден");

                // 27. Клик — кнопка «Orqaga» (Назад).
                System.out.println("27. Клик — кнопка «Orqaga» (Назад).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Orqaga"))).click();

                // 28. Клик (Системный) — физическая кнопка Назад (Back).
                System.out.println("28. Клик (Системный) — физическая кнопка Назад (Back).");
                driver.navigate().back();

                // 29. Клик — открытие чата/меню.
                System.out.println("29. Клик — открытие чата/меню.");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().className(\"android.widget.ImageView\").instance(10)")))
                                .click();

                // 30. Клик — раздел «Turon Market».
                System.out.println("30. Клик — раздел «Turon Market».");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.accessibilityId("Turon Market"))).click();

                // 31. Ввод текста — пишем "test" в первое поле.
                System.out.println("31. Ввод текста — пишем \"test\" в первое поле.");
                WebElement fieldTest = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().className(\"android.widget.EditText\").instance(0)")));
                searchField.click();
                fieldTest.sendKeys("test");

                // 🛑 УБЕРИТЕ блок try-catch с hideKeyboard() полностью!

// 32. Ввод текста — пишем "00123456" в поле телефона.
                WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//android.widget.EditText[contains(@text, '+998')]")
                ));
// Просто отправляем текст, без лишних кликов, чтобы фокус не прыгал
                phoneInput.sendKeys("00123456");

// 33. Проверка — кнопка «Yuborish» заблокирована
// ВАЖНО: Мы используем visibilityOfElementLocated, чтобы Appium просто посмотрел на нее, но не пытался с ней взаимодействовать!
                WebElement yuborishBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.xpath("//*[contains(@content-desc, 'Yuborish')]")
                ));

// Читаем статус кнопки
                String isClickable = yuborishBtn.getAttribute("clickable");
                System.out.println("Статус кнопки Yuborish (должен быть false): " + isClickable);

// 34. Ввод текста — пишем ПРАВИЛЬНЫЙ номер.
// Снова обращаемся к тому же элементу phoneInput
                phoneInput.click(); // Фокусируемся
                phoneInput.clear(); // Стираем "00123456"
                phoneInput.sendKeys("90123456"); // Вставьте здесь ваш валидный номер

// 35. Клик — кнопка «Yuborish» (Отправить)
                wait.until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.xpath("//*[contains(@content-desc, 'Yuborish')]")
                )).click();

                // 36. Клик — раздел «Operator bilan aloqa» (Связь с оператором).
                System.out.println("36. Клик — раздел «Operator bilan aloqa» (Связь с оператором).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.xpath("//android.view.View[@content-desc=\"Operator bilan aloqa\"]"))).click();

                // 37. Ввод текста — пишем "test123!@#йцуйц".
                System.out.println("37. Ввод текста — пишем \"test123!@#йцуйц\".");
                WebElement chatInput = wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().className(\"android.widget.EditText\")")));
                chatInput.sendKeys("test123!@#йцуйц");

                // 38. Клик — отправить сообщение (иконка стрелочки).
                System.out.println("38. Клик — отправить сообщение (иконка стрелочки).");
                wait.until(ExpectedConditions.elementToBeClickable(
                                AppiumBy.androidUIAutomator(
                                                "new UiSelector().className(\"android.widget.ImageView\").instance(2)")))
                                .click();

                // 39. Проверка — сообщение появилось в истории.
                System.out.println("39. Проверка — сообщение появилось в истории.");
                WebElement chatMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.accessibilityId("test123!@#йцуйц\n07:57")));
                Assert.assertTrue(chatMessage.isDisplayed(), "Сообщение не найдено в истории чата");
                System.out.println("✅ Сообщение найдено в истории чата");
        }

        @AfterTest
        public void close() {
                if (driver != null) {
                        driver.quit();
                }
        }
}
