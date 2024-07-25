// import Lists.Stack;
// import Queue.Queue;
//import BinarySearchTree;
package Trees;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(25);
        myBST.insert(10);
        myBST.insert(66);

        myBST.printTree();

        System.out.println(myBST.root);

    }
    
    
}
