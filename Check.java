import java.util.Scanner;

public class Check {

    // Безопасный ввод положительного числа
    public static int checkingPositiveInt(Scanner scanner, String message) {
        int n;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
            n = scanner.nextInt();
            scanner.nextLine(); // съедаем остаток строки
            if (n <= 0) System.out.println("Ошибка! Число должно быть положительным.");
        } while (n <= 0);
        return n;
    }

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

    // Ввод дроби с проверкой знаменателя на 0
    public static Fraction inputFraction(Scanner scanner) {
        int numerator = checkingInt(scanner, "Введите числитель: ");
        int denominator;

        while (true) {
            denominator = checkingInt(scanner, "Введите знаменатель (не может быть 0): ");
            if (denominator != 0) break;
            System.out.println("Ошибка! Знаменатель не может быть равен 0.");
        }

        return new Fraction(numerator, denominator);
    }
}
