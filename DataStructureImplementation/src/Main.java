import LinkedList.LinkedList;
import Queue.PriorityQueue;
import Queue.QueueWithTwoStack;
import Stack.Stack;
import Stack.StringReverser;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(5);
        queue.add(3);
        queue.add(6);
        queue.add(4);
        queue.add(1);

        System.out.println(queue);
    }
}