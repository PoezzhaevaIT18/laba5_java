import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class ListQueue {
    private final java.util.List<Integer> sourceList;
    private final Queue<Integer> resultQueue;

    public ListQueue(java.util.List<Integer> sourceList) {
        // Создаем копию исходного списка через ArrayList
        this.sourceList = new ArrayList<>(sourceList);
        this.resultQueue = new LinkedList<>();
        buildQueue();
    }

    private void buildQueue() {
        //Добавляем элементы в порядке исходного списка
        for (int num : sourceList) {
            resultQueue.add(num);
        }

        // Создаем итератор, начинающийся с конца списка
        ListIterator<Integer> iterator = sourceList.listIterator(sourceList.size());
        // Добавляем элементы в обратном порядке
        while (iterator.hasPrevious()) {
            resultQueue.add(iterator.previous());
        }
    }
    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }
    public java.util.List<Integer> getSourceList() {
        return sourceList;
    }
    @Override
    public String toString() {
        return "ListQueue {" + "sourceList=" + sourceList + ", resultQueue=" + resultQueue + '}';
    }
}
