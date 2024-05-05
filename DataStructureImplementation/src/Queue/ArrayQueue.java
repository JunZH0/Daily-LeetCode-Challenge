package Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;
    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        // circular array
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
       var item = items[front];
       items[front] = 0;
       // circular array
       front = (front + 1) % items.length;
       count--;
       return item;
    }

    public int size() {
        return count;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
