package org.example;

import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("  Выберите тестовый сценарий для запуска:");
        System.out.println("  1. (ClientDostavka)");
        System.out.println("  2. (ClientPvz)");
        System.out.println("  3. (ClientDostavkaCashback)");
        System.out.println("  4. (ClientPvzCashback)");
        System.out.println("  5. (abonDostavka)");
        System.out.println("  6. (abonPvz)");
        System.out.println("  7. (abonDostavkaCashback)");
        System.out.println("  8. (abonPvzCashback)");
        System.out.println("  9. Запустить все 8 тестов по очереди");
        System.out.println("  0. Выход");
        System.out.println("==========================================");
        System.out.print("Введите номера через пробел (например: 1 3 4): ");

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Вы ничего не ввели. Выход.");
            return;
        }

        List<Class<?>> classesToRun = new ArrayList<>();
        String[] parts = input.split("[,\\s]+");

        for (String part : parts) {
            try {
                int choice = Integer.parseInt(part);
                switch (choice) {
                    case 1:
                        if (!classesToRun.contains(ClientDostavka.class)) classesToRun.add(ClientDostavka.class);
                        break;
                    case 2:
                        if (!classesToRun.contains(ClientPvz.class)) classesToRun.add(ClientPvz.class);
                        break;
                    case 3:
                        if (!classesToRun.contains(ClientDostavkaCashback.class)) classesToRun.add(ClientDostavkaCashback.class);
                        break;
                    case 4:
                        if (!classesToRun.contains(ClientPvzCashback.class)) classesToRun.add(ClientPvzCashback.class);
                        break;
                    case 5:
                        if (!classesToRun.contains(abonDostavka.class)) classesToRun.add(abonDostavka.class);
                        break;
                    case 6:
                        if (!classesToRun.contains(abonPvz.class)) classesToRun.add(abonPvz.class);
                        break;
                    case 7:
                        if (!classesToRun.contains(abonDostavkaCashback.class)) classesToRun.add(abonDostavkaCashback.class);
                        break;
                    case 8:
                        if (!classesToRun.contains(abonPvzCashback.class)) classesToRun.add(abonPvzCashback.class);
                        break;
                    case 9:
                        classesToRun.clear();
                        classesToRun.add(ClientDostavka.class);
                        classesToRun.add(ClientPvz.class);
                        classesToRun.add(ClientDostavkaCashback.class);
                        classesToRun.add(ClientPvzCashback.class);
                        classesToRun.add(abonDostavka.class);
                        classesToRun.add(abonPvz.class);
                        classesToRun.add(abonDostavkaCashback.class);
                        classesToRun.add(abonPvzCashback.class);
                        break;
                    case 0:
                        System.out.println("Отмена по выбору 0. Выход.");
                        return;
                    default:
                        System.out.println("Неизвестный номер: " + choice + ". Пропуск.");
                        break;
                }

                if (choice == 9) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат: " + part + ". Пропуск.");
            }
        }

        if (classesToRun.isEmpty()) {
            System.out.println("Не было выбрано ни одного валидного теста. Выход.");
            return;
        }

        System.out.println("==========================================");
        System.out.println("Выбрано классов для запуска: " + classesToRun.size());
        for (Class<?> c : classesToRun) {
            System.out.println("- " + c.getSimpleName());
        }
        System.out.println("==========================================");

        // Запускаем каждый тест полностью независимо.
        // Если тест 1 падает, он корректно закроет свою сессию (driver.quit()),
        // и цикл продолжит запуск теста 3 без сбоев Appium.
        for (int i = 0; i < classesToRun.size(); i++) {
            Class<?> testClass = classesToRun.get(i);
            System.out.println("\n>>> ЗАПУСК ТЕСТА " + (i + 1) + " ИЗ " + classesToRun.size() + ": " + testClass.getSimpleName());

            TestNG testng = new TestNG();
            testng.setTestClasses(new Class[] { testClass });

            try {
                testng.run();
                if (testng.hasFailure()) {
                    System.out.println(">>> Внимание: Тест " + testClass.getSimpleName() + " завершился с ошибкой (failed). Переходим к следующему...");
                }
            } catch (Exception e) {
                System.out.println(">>> Ошибка во время выполнения " + testClass.getSimpleName() + ": " + e.getMessage());
            }

            System.out.println(">>> ЗАВЕРШЕН ТЕСТ " + (i + 1) + " ИЗ " + classesToRun.size() + ": " + testClass.getSimpleName());
        }

        System.out.println("\n==========================================");
        System.out.println("Выполнение всех выбранных тестов полностью завершено!");
    }
}
