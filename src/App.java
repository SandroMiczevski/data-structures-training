

import Lists.Stack;
import Queue.Queue;
import Trees.BinarySearchTree;

public class App {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(25);
        myBST.insert(10);
        myBST.insert(66);

        myBST.printTree();

        System.out.println(myBST.root);

    }
    
    
}
