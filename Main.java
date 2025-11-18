import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задания (1, 2, 3, 6): ");
        int num = scanner.nextInt();
        scanner.nextLine();

        switch (num) {
            case 1: {
                System.out.println("Работа с дробями: ");
                System.out.println("Введите первую дробь:");
                Fraction f1 = Check.inputFraction(scanner);
                System.out.println("Первая дробь: " + f1);
                System.out.println("Вещественное значение: " + f1.getDecimalValue());
                System.out.println("Введите вторую дробь:");
                Fraction f2 = Check.inputFraction(scanner);
                System.out.println("Вторая дробь: " + f2);
                System.out.println("Дроби равны? " + f1.equals(f2));
                FractionCached cached = new FractionCached(f1);
                System.out.println("Кэш 1: " + cached.getDecimalValue());
                System.out.println("Кэш 2 (повторный вызов, без пересчета): " + cached.getDecimalValue());
                // Изменяем дробь через кэш
                cached.setFraction(6, -10);
                System.out.println("Новая дробь (через кэш): " + cached);
                System.out.println("Кэш пересчитан: " + cached.getDecimalValue());
                break;
            }
            case 2: {
                Cat tosha = new Cat("Тоша");
                Cat brusnichka = new Cat("Брусничка");
                Human owner = new Human();
                owner.makeMeow(tosha);
                owner.makeMeow(brusnichka);
                owner.makeMeow(tosha);
                System.out.println("Общее количество мяуканий: " + owner.getTotalMeowCount());
                break;
            }
            case 3: {
                System.out.println("Работа с числами:");
                List<String> L1 = Check.inputOrderedList(scanner, "Введите элементы первого списка L1 (по возрастанию):", true);
                List<String> L2 = Check.inputOrderedList(scanner, "Введите элементы второго списка L2 (по возрастанию):", true);
                Comparator<String> numberComparator = (a, b) -> Integer.parseInt(a) - Integer.parseInt(b);
                List<String> mergedNumbers = OrderedList.mergeLists(L1, L2, numberComparator);
                System.out.println("Объединённый список чисел:");
                for (String s : mergedNumbers) System.out.print(s + " ");
                System.out.println();
                System.out.println("Работа со строками:");
                List<String> S1 = Check.inputOrderedList(scanner, "Введите элементы первого списка S1 (по возрастанию длины):", false);
                List<String> S2 = Check.inputOrderedList(scanner, "Введите элементы второго списка S2 (по возрастанию длины):", false);
                Comparator<String> stringComparator = (a, b) -> a.length() - b.length();
                List<String> mergedStrings = OrderedList.mergeLists(S1, S2, stringComparator);
                System.out.println("Объединённый список строк:");
                for (String s : mergedStrings) System.out.print(s + " ");
                System.out.println();
                break;
            }
            case 6: {
                System.out.println("Пример с числами:");
                List<String> numbers = Check.inputOrderedList(scanner, "Введите числа по возрастанию через пробел:", true);
                ListQueue<String> numQueue = new ListQueue<>(numbers);
                System.out.println("Исходный список: " + numQueue.getSourceList());
                System.out.println("Построенная очередь: " + numQueue.getResultQueue());
                System.out.println("\nПример со строками:");
                List<String> strings = Check.inputOrderedList(scanner, "Введите строки по возрастанию длины через пробел:", false);
                ListQueue<String> strQueue = new ListQueue<>(strings);
                System.out.println("Исходный список: " + strQueue.getSourceList());
                System.out.println("Построенная очередь: " + strQueue.getResultQueue());
                break;
            }

        }
    }
}
