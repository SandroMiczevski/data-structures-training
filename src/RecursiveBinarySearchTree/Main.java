package RecursiveBinarySearchTree;

public class Main {
    public static void main(String[] args) {
        rBST myBST = new rBST ();

        myBST.insert(2);
        myBST.insert(3);
        myBST.insert(1);

        System.out.println(myBST.root.value);
        System.out.println(myBST.root.left.value);
        System.out.println(myBST.root.right.value);

        System.out.println(myBST.contains(1));
    }
}
