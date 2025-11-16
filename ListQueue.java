import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListQueue<T> {
    private final List<T> sourceList;
    private final Queue<T> resultQueue;

    public ListQueue(List<T> sourceList) {
        this.sourceList = new ArrayList<>(sourceList);
        this.resultQueue = new LinkedList<>();
        buildQueue();
    }

    // Построение очереди: сначала прямой порядок, потом обратный
    private void buildQueue() {
        for (T item : sourceList) {
            resultQueue.add(item);
        }
        for (int i = sourceList.size() - 1; i >= 0; i--) {
            resultQueue.add(sourceList.get(i));
        }
    }

    public List<T> getSourceList() {
        return sourceList;
    }

    public Queue<T> getResultQueue() {
        return resultQueue;
    }

    @Override
    public String toString() {
        return "ListQueue {sourceList=" + sourceList + ", resultQueue=" + resultQueue + "}";
    }
}
