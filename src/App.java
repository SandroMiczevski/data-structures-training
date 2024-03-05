public class App {

    public static void main(String[] args) {
        Stack myStack = new Stack(1);
        myStack.Push(2);

        myStack.printStack();
        
        myStack.Pop();
        myStack.Pop();


        myStack.getTop();
        myStack.getHeight();

        myStack.Push(10);

        myStack.getTop();
        myStack.getHeight();

        System.out.println("\nStack:");
        myStack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Top: 4
            Height: 1
            
            Stack:
            4

        */
    }
    
    
}
