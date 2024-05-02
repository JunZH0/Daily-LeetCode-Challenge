import LinkedList.LinkedList;
import Stack.Stack;
import Stack.StringReverser;

public class Main {
    public static void main(String[] args) {
       String str = "";

       StringReverser reverser =  new StringReverser();
       var result = reverser.reverse(null);

       System.out.println(result);
    }
}