import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> list = new LinkedList<E>();

    // Method to enqueue an item to the queue
    public void enqueue(E item) {
        list.addFirst(item);
    }

    // Method to dequeue and remove the first item from the queue
    public E dequeue() {
        if (!isEmpty()) {
            return list.removeLast();
        } else {
            throw new IllegalStateException("Queue is empty.");
        }
    }

    // Method to get the size of the queue
    public int size() {
        return list.size();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
