package Lists;
public class LinkedList {
    
    // Class' attributes
    private Node head;
    private Node tail;
    private int size;

    // Embbeded class Node
    class Node{
        int value;
        Node next;
        
        // Class' constructor
        Node(int value){
            this.value = value;
        }

    }

    // Linked List constructor
    LinkedList(int value){
        setSize(0);

        Node new_node = new Node(value);
        head = new_node;
        tail = new_node;

        size++;
        
    }

    // Main functions of the class
    public void append (int value){

        Node new_node = new Node(value);

        if (head == null){
            head = new_node;
            tail = new_node;
        }
        else{
            // Updates the next element of the actual tail to receive the element being added to the list
            // and sets new element as the new tail.
            tail.next = new_node;
            tail = new_node;
        }
        size++;
    }

    public void prepend(int value){
        // Creates a new node and adds to the front of the list.
        Node node = new Node(value);
        
        // Checks if the list wasn't empty before, if it was points the tail to the new node.
        if (head == null){
            head = node;
            tail = node;
        } else {
            // If the list was not empty before, creates the new head and adds it to the list.
            node.next = head;
            head = node;
        }
        size++;
    }

    public boolean insert (int index, int value){
        if (index < 0 || index > size){
            return false;
        }
        else if (index == 0){
            System.out.println("Inside the prepend");
            prepend(value);
            return true;
        }
        else if (index == size){
            System.out.println("Inside the append");
            append(value);
            return true;
        }

        Node temp = get(index-1);
        Node newNode = new Node(value);

        newNode.next = temp.next;
        temp.next = newNode;

        size++;

        return true;
    }

    public Node removeLast(){
    Node temp = head;
        Node pre = head;
        
        if (head == null) return null;

        // Go through the list until the second to last element
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;

        size--;

        if (head == tail) {
            head = null;
            tail = null;
            setSize(0);
        }

        return temp;
    }
    
    public Node removeFirst(){
        if (isEmpty()) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;

        if (head == null) tail = null;

        return temp;
    }

    public Node remove(int index){
        if (index < 0 || index > size) return null;
        else if (index == 0){
            return removeFirst();
        }
        else if (index == size-1){
            return removeLast();
        }
        Node previous = get(index-1);
        Node temp = previous.next;

        previous.next = temp.next;
        temp.next = null;
        
        size--;
        return temp;
    }

    public Node get (int index){
        if (index < 0 && index > size){
            System.out.println("Index is out of range");
            return null;
        }

        Node temp = head;
        int i = 0;

        while (i < index){
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public boolean set (int index, int value){
        // Updates the value in a given index
        Node temp = get(index);
        if (temp == null) return false;

        temp.value = value;
        return true;
    }

    public void printList() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            System.out.println("["+ count + "]: " + temp.value);
            temp = temp.next;
            count++;
        }
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = temp.next;

        while(temp != null){
            after = temp.next;
            temp.next = before;
            
            before = temp;
            temp = after;
        }

        tail.next = null;

    }

    // Getters
    private boolean isEmpty(){
        if (head == null || tail == null) return true;
        return false;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength(){
        System.out.println("The list length is:" + size);
    }


    // Setters
    public void setSize(int value){
        this.size = value;
    }
}
