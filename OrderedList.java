import java.util.ArrayList;
import java.util.List;

public class OrderedList {

    // Объединение двух упорядоченных списков
    public static List<String> mergeLists(List<String> L1, List<String> L2, boolean isNumeric) {
        List<String> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < L1.size() && j < L2.size()) {
            boolean takeFromL1;

            if (isNumeric) {
                double val1 = Double.parseDouble(L1.get(i));
                double val2 = Double.parseDouble(L2.get(j));
                takeFromL1 = val1 <= val2;
            } else {
                // Сравнение строк по длине
                takeFromL1 = L1.get(i).length() <= L2.get(j).length();
            }

            if (takeFromL1) {
                merged.add(L1.get(i++));
            } else {
                merged.add(L2.get(j++));
            }
        }

        while (i < L1.size()) merged.add(L1.get(i++));
        while (j < L2.size()) merged.add(L2.get(j++));
        return merged;
    }
}
