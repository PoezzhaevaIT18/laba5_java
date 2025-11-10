import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задания (1, 2, 3, 6): ");
        int num = scanner.nextInt();
        scanner.nextLine();

        switch (num) {
            case 1: {
                System.out.println("Создадим первую дробь:");
                Fraction fraction1 = Check.inputFraction(scanner);
                System.out.println("Введенная дробь: " + fraction1);
                System.out.println("Вещественное значение: " + fraction1.getDecimalValue());
                System.out.println("Создадим вторую дробь:");
                Fraction fraction2 = Check.inputFraction(scanner);
                System.out.println("Введенная дробь: " + fraction2);
                System.out.println("Вещественное значение: " + fraction2.getDecimalValue());
                System.out.println("Сравнение дробей:");
                System.out.println(fraction1 + " = " + fraction2 + "? " + fraction1.equals(fraction2));
                System.out.println("Изменим первую дробь:");
                Fraction newFraction = Check.inputFraction(scanner);
                fraction1.setFraction(newFraction.getNumerator(), newFraction.getDenominator());
                System.out.println("Измененная дробь: " + fraction1);
                System.out.println("Вещественное значение: " + fraction1.getDecimalValue());
                break;
            }
            case 2: {
                Cat cat = new Cat("Тоша");
                System.out.println(cat);
                Meowable[] meowables = {cat};
                MeowCounter.makeAllMeow(meowables);
                MeowCounter.makeAllMeow(meowables);
                MeowCounter.makeAllMeow(meowables);
                MeowCounter.makeAllMeow(meowables);
                System.out.println("Количество мяуканий кота " + cat + ": " + cat.getMeowCount());
                break;
            }
            case 3: {
                System.out.println("Вставить элементы списка L2 в список L1, не нарушая его упорядоченности: ");
                LinkedList<Integer> L1 = new LinkedList<>();
                System.out.println("Введите элементы первого списка L1 (по возрастанию):");
                String[] input1 = scanner.nextLine().split(" ");
                if (!OrderedList.fillListWithCheck(L1, input1)) {
                    System.out.println("Ошибка: элементы списка L1 не упорядочены!");
                    return;
                }
                LinkedList<Integer> L2 = new LinkedList<>();
                System.out.println("Введите элементы второго списка L2 (по возрастанию):");
                String[] input2 = scanner.nextLine().split(" ");
                if (!OrderedList.fillListWithCheck(L2, input2)) {
                    System.out.println("Ошибка: элементы списка L2 не упорядочены!");
                    return;
                }
                LinkedList<Integer> merged = List.mergeSortedLists(L1, L2);
                System.out.println("Объединённый список:");
                for (int number : merged) {
                    System.out.print(number + " ");
                }
                break;
            }
            case 6: {
                System.out.println("Построение очереди по списку L (текущийй + обратный) ");
                int n = Check.checkingPositiveInt(scanner, "Введите количество элементов списка L: ");
                java.util.List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int value = Check.checkingInt(scanner, "Введите элемент " + (i + 1) + ": ");
                    list.add(value);
                }
                ListQueue queue = new ListQueue(list);
                System.out.println("Исходный список: " + queue.getSourceList());
                System.out.println("Построенная очередь: " + queue.getResultQueue());
                break;

            }

        }
    }
}