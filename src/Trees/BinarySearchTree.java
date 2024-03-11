package Trees;

public class BinarySearchTree {
    public Node root;

    /* 
        The goal here is to create an empty tree, with root = null;
        So, that's why there's no contructor on this class.

        But if there was a constructor, it would be like this

        public BinarySearchTree(int value){
            Node new_node = new Node(value);
            new_node.value = value;
            root = new_node;
        }
    */

    public void insert (int value){
        Node temp = root;
        Node new_node = new Node(value);

        if (root == null){
            root = new_node;
        } else {

            while (temp != null){
                if (temp.value == value) {
                    System.out.println("Node aleady in the tree.");
                    return;
                }

                if(value > temp.value){
                    if (temp.right == null) {
                        temp.right = new_node;
                        return;
                    }
                    else {
                        temp = temp.right;
                    }
                } 
                else if (value < temp.value) {
                    if (temp.left == null){
                        temp.left = new_node; 
                        return;
                    }
                    else{
                        temp = temp.left;
                    }
                } 
            }

        }
        
    }
    
    public void printTree(){
        System.out.println("Root value: " + root.value + "| left: " + root.left.value + " and right: " + root.right.value);
    }
}
