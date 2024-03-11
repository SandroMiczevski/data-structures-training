package Lists;


public class Stack {

    class Node{
        Node next;
        int value;
        
        public Node(int value){
            //Node node = new Node(value);
            this.next = null;
            this.value = value;
        }
    }

    private Node top;
    private int size;

    public Stack(int value){
        Node new_node = new Node(value);
        this.top = new_node;
        this.size = 1;
    }

    public void Push (int value){
        Node new_node = new Node(value);
        new_node.next = top;
        top = new_node;
        size++;
    }

    public Node Pop(){
        if (top == null) return null;
        
        Node temp = top;

        if (top.next == null){
            top = null;
        } else {
            top = top.next;
            temp.next = null;
        }
        size--;
        return temp;
    }

    // Methods for information

    public void getHeight(){
        System.out.println("The Stack has a height of: " + this.size);
    }
    
    public void getTop(){
        if (top==null) {
            System.out.println("Top is null");
            return;
        }

        System.out.println("Top has a value of: " + this.top.value);
    }

    public void printStack(){
        Node temp = top;
        int i = 0;
        System.out.println("Printing starting from the top...");
        while (temp != null){
            System.out.println("["+ i + "]: " + temp.value);
            temp = temp.next;
            i++;
        }
    }
}
