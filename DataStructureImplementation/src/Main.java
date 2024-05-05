import LinkedList.LinkedList;
import Queue.QueueWithTwoStack;
import Stack.Stack;
import Stack.StringReverser;

public class Main {
    public static void main(String[] args) {
        QueueWithTwoStack queue = new QueueWithTwoStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        var first = queue.dequeue();

        System.out.println(first);
    }
}