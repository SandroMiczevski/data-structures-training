package Queue;
public class Queue {

    private Node first;
    private Node last;
    private int size;

    public class Node {
        public int value;
        public Node next;

        Node(int value){
            this.value = value;
        }
    }

    public Queue(int value) {
        Node new_node = new Node(value);
        this.first = new_node;
        this.last = new_node;
        this.size = 1;
    }

    public void enqueue (int value){
        Node new_node = new Node(value);

        // If this is an empty queue
        if (first == null){
            first = new_node;
            last = new_node;
        } else {
            last.next = new_node;
            last = new_node;   
        }
        size++;
    }

    public Node dequeue(){
        if (first == null) return null;

        Node temp = first;

        if (first == last){
            first = null;
            last = null;
            return temp;
        }

        first = first.next;
        temp.next = null;
        size--;

        return temp;
    }

    // Methods for information

    public void getSize(){
        System.out.println("The Stack has a height of: " + this.size);
    }
    
    public void getFirst(){
        if (first==null) {
            System.out.println("Top is null");
            return;
        }

        System.out.println("Top has a value of: " + this.first.value);
    }

    public void printQueue(){
        Node temp = first;
        int i = 0;
        if (temp == null) {
            System.out.println("Queue is empty");
            return;
        }

        while (temp != null){
            System.out.println("["+ i + "]: " + temp.value);
            temp = temp.next;
            i++;
        }
    }
}
