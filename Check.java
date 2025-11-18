import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {

    // Безопасный ввод целого числа
    public static int checkingInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    // Безопасный ввод положительного числа (>0)
    public static int checkingPositiveInt(Scanner scanner, String message) {
        int n;
        do {
            n = checkingInt(scanner, message);
            if (n <= 0) System.out.println("Ошибка! Число должно быть положительным.");
        } while (n <= 0);
        return n;
    }

    // Ввод дроби с проверкой знаменателя на 0 и переносом знака
    public static Fraction inputFraction(Scanner scanner) {
        int numerator = checkingInt(scanner, "Введите числитель: ");
        int denominator;

        while (true) {
            denominator = checkingInt(scanner, "Введите знаменатель (не может быть 0): ");
            if (denominator == 0) {
                System.out.println("Ошибка! Знаменатель не может быть равен 0.");
            } else {
                break;
            }
        }

        // Перенос отрицательного знака из знаменателя в числитель
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return new Fraction(numerator, denominator);
    }

    // Ввод упорядоченного списка
    public static List<String> inputOrderedList(Scanner scanner, String message, boolean isNumbers) {
        while (true) {
            System.out.println(message);
            System.out.println("Введите элементы через пробел:");

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Ошибка! Список не может быть пустым.");
                continue;
            }

            String[] parts = line.split("\\s+");
            List<String> list = new ArrayList<>();
            boolean ok = true;

            if (isNumbers) {
                // Проверка, что все элементы — числа
                try {
                    for (String p : parts) {
                        Integer.parseInt(p);
                        list.add(p);
                    }
                    // Проверка на возрастание
                    for (int i = 1; i < list.size(); i++) {
                        if (Integer.parseInt(list.get(i)) < Integer.parseInt(list.get(i - 1))) {
                            System.out.println("Ошибка! Числа должны быть по возрастанию.");
                            ok = false;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Введите только числа.");
                    ok = false;
                }
            } else {
                // Проверка строк по длине
                for (String p : parts) list.add(p);
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i).length() < list.get(i - 1).length()) {
                        System.out.println("Ошибка! Строки должны быть упорядочены по длине.");
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) return list; // возвращаем корректный список
        }
    }
}
