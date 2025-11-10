import java.util.LinkedList;

public class List {

    // Метод объединения двух упорядоченных списков
    public static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> L1, LinkedList<Integer> L2) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0, j = 0;
        int n1 = L1.size(), n2 = L2.size();

        while (i < n1 && j < n2) {
            if (L1.get(i) <= L2.get(j)) {
                result.add(L1.get(i++));
            } else {
                result.add(L2.get(j++));
            }
        }

        // Добавляем оставшиеся элементы
        while (i < n1) result.add(L1.get(i++));
        while (j < n2) result.add(L2.get(j++));

        return result;
    }
}
