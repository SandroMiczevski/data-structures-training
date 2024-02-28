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
        }
    }


    public void getLength(){
        System.out.println("The list length is:" + size);
    }

}