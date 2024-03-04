public class App {

    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(0);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);

        System.out.println( myDLL.get(1).value );
        System.out.println( myDLL.get(2).value );

        myDLL.printList();

        System.out.println( myDLL.set(2, 22) );

        System.out.println( myDLL.insert(2, 10) );
        System.out.println( myDLL.insert(0, -1) );
        System.out.println( myDLL.insert(5, 222) );

        myDLL.printList();

        System.out.println( myDLL.remove(6).value );
        System.out.println( myDLL.remove(0).value );
        System.out.println( myDLL.remove(2).value );

        myDLL.printList();

        
    	/*
        	EXPECTED OUTPUT:
        	----------------
        	2
        	1
        	null

     	*/
    }
    
    
}
