package Queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverse(Queue<Integer> queue) {
        // Using a stack, add the elements and then pop.
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
