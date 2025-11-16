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
    // isNumeric = true для чисел (целые или вещественные), false для строк
    public static List<String> inputOrderedList(Scanner scanner, String message, boolean isNumeric) {
        while (true) {
            System.out.println(message);
            String[] input = scanner.nextLine().split(" ");
            List<String> list = new ArrayList<>();
            for (String s : input) list.add(s.trim());

            boolean ordered = true;

            if (isNumeric) {
                // Проверка числового порядка (целые и вещественные)
                try {
                    for (int i = 1; i < list.size(); i++) {
                        double prev = Double.parseDouble(list.get(i - 1));
                        double curr = Double.parseDouble(list.get(i));
                        if (curr < prev) {
                            ordered = false;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! Введите только числа.");
                    continue;
                }
            } else {
                // Проверка порядка по длине строк
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i).length() < list.get(i - 1).length()) {
                        ordered = false;
                        break;
                    }
                }
            }

            if (!ordered) {
                System.out.println("Ошибка! Элементы не упорядочены по условию.");
            } else {
                return list;
            }
        }
    }
}
