import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderedList {

    public static <T> List<T> mergeLists(List<T> list1, List<T> list2, Comparator<T> comp) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (comp.compare(list1.get(i), list2.get(j)) <= 0) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i++));
        }
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }

        return result;
    }
}
