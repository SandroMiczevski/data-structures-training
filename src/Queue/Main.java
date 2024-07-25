package Queue;

public class Main{

    public static void main(String[] args){

        Queue q = new Queue(0);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println("Full queue:");
        q.printQueue();

        q.dequeue();

        System.out.println("Full queue now:");
        q.printQueue();

    }

}