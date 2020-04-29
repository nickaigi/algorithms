import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();

        stack.push(12L);
        System.out.println("Pushed 12L");    // push long value 12L
        printStack(stack);
        stack.push(34567);                   // push int value 34567
        System.out.println("Pushed 34567");
        printStack(stack);
        stack.push(1.0F);                    // push float value 1.0F
        System.out.println("Pushed 1.0F");
        printStack(stack);
        stack.push(1234.5678);               // push double value 1234.5678
        System.out.println("Pushed 1234.5678");
        printStack(stack);

        // remove items from stack
        try {
            Number removedObject = null;

            // pop from stack
            while (true) {
                removedObject = stack.pop();
                System.out.printf("Popped %s%n", removedObject);
                printStack(stack);
            }
        } catch (EmptyStackException exception) {
            exception.printStackTrace();
        }
    }

    private static void printStack(Stack<Number> stack) {
        if (stack.isEmpty())
            System.out.printf("stack is empty%n%n");
        else
            System.out.printf("stack contains: %s (top) %n", stack);
    }
}
