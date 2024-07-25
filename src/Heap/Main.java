package Heap;

public class Main {
    
    public static void main(String[] args) {
        Heap H = new Heap();

        H.insert(99);
        H.insert(72);
        H.insert(61);
        H.insert(58);

        System.out.println(H.getHeap());

        H.insert(100);

        System.out.println(H.getHeap());

        H.insert(200);
        H.insert(60);
        H.insert(59);

        System.out.println(H.getHeap());
    }
}
