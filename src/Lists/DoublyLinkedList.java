package Lists;
class DoublyLinkedList{

    private Node head;
    private Node tail;
    int size;

    class Node{
        public int value;
        public Node next;
        public Node prev;

        public Node(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList(int value){
        Node nn = new Node(value);
        head = nn;
        tail = nn;
        size = 1;
    }


    // List operation methods.

    public void append (int value){
        Node new_node = new Node(value);

        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            new_node.prev = tail;
            tail.next = new_node;
            tail = new_node;
        }
        size++;
    }

    public Node removeLast(){
        if (head == null) return null;

        Node temp = tail;
        if (size == 1){
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }

    public void prepend(int value){
        Node temp = new Node (value);

        if (head == null){
            head = temp;
            tail = temp;
        } else {
            temp.prev = null;
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    public Node removeFirst(){
        if (head == null) return null;

        Node temp = head;

        if (head == tail) {
            head = null;
            tail = null;

        } else {
            head = temp.next;
            head.prev = null;
            temp.next = null;
        }
        size--;
        return temp;
    }

    public Node get(int index){
        // check for edge cases first;
        if (index < 0 || index >= size) return null;

        Node temp = head;

        /* Selecting where to start moving from. 
         * If the index is within the first half of the list, start from head
         * If the index is within the second half, start from tail
        */

        if(index < size/2){
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index ; i--){
                temp = temp.prev;
            }
        }

        return temp;
    }

    public boolean set(int index, int value) {
        //Updates the value on a given node;
        Node temp = get(index);


        if (temp != null){
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert (int index, int value){
        if (index < 0 || index >= size) {
            return false;
        } else if (head == null || index == 0) {
            prepend(value);
            return true;
        } else if (index == size-1){
            append(value);
            return true;
        }

        Node previous = get(index-1); // Get the previous node to where I want to insert a new one
        if (previous != null){
            Node temp = new Node(value);
            Node next = previous.next;
    
            temp.prev = previous;
            temp.next = previous.next;
            previous.next = temp;
            next.prev = temp;
    
            size++;
            return true;
        }
        return false;
    }

    public Node remove (int index){
        if (index < 0 || index > size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        
        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;

        before.next = temp.next;
        after.prev = temp.prev;

        temp.next = null;
        temp.prev = null;
        
        size--;

        return temp;
    }

    // Access methods

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

    public void printList(){
        if (head == null) {
            System.out.println("Empty list");
            return;
        };

        int index = 0;
        Node temp = head;

        while(temp != null){
            System.out.println("["+ index + "]: " + temp.value);
            temp = temp.next;
            index++;
        }
    }

    public void getLength(){
        System.out.println("The list length is:" + size);
    }

}