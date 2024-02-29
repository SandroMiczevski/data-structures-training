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
            temp.prev = null;
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
        if (index < 0 || index > size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size) return removeLast();

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

        // Make changes on previous and next nodes of index;
        Node previous_node = temp.prev;
        Node next_node = temp.next;

        previous_node.next = next_node;
        next_node.prev = previous_node;

        // Adjusts the accesses on index;
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