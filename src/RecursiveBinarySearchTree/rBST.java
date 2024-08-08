package RecursiveBinarySearchTree;

import Trees.Node;

public class rBST {
    public Node root;


    public void insert (int value){
        if (root == null) root = new Node(value);
        insert(root, value);
    }

    private Node insert (Node currentNode, int value){
        if (currentNode == null) return new Node (value);

        if( value > currentNode.value){
            currentNode.right = insert(currentNode.right, value);
        } 
        else if (value < currentNode.value){
            currentNode.left = insert(currentNode.left, value);
        }
        return currentNode;
    }

    public boolean contains(int value){
        if (root == null) return false;
        return contains(value, root);
    }

    private boolean contains(int value, Node currentNode){
        if (currentNode == null) return false;
        
        if (currentNode.value == value) return true;

        if (value > currentNode.value){
            return contains(value, currentNode.right);
        } else {
            return contains(value, currentNode.left);
        }
    }
}
