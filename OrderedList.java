import java.util.LinkedList;

public class OrderedList {

    // Метод для заполнения списка и проверки упорядоченности
    public static boolean fillListWithCheck(LinkedList<Integer> list, String[] input) {
        if (input.length == 0) return true;

        int prev = Integer.parseInt(input[0]);
        list.add(prev);

        for (int i = 1; i < input.length; i++) {
            int current = Integer.parseInt(input[i]);
            if (current < prev) {  //Если текущий меньше предыдущего
                return false; // Список неупорядочен
            }
            list.add(current);
            prev = current;
        }
        return true;
    }
}
