package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public void insert (int value){
        heap.add(value);
        int currentIndex = heap.size()-1;
        boolean stopCondition = true;

        while (stopCondition){

            int parentIndex = parentIndex(currentIndex);

            if( heap.get(currentIndex) > heap.get(parentIndex) ){
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                stopCondition = false;
            }
        }
    }

    public Integer remove(){
        /***
         * The standard behaviour of this funtion is to remove the root of the heap, or the element on the top of the tree and then rebalance it.
         * 
         * This function will remove the root of the tree, replace it with the minimum value and then rebalance it.
         * 
         * @params this function does not accept any parameters.
         * @return returns the value of the element removed from the list.
         */

        if (heap.size() == 0){ 
            //If it's empty, return NULL
            return null;
        }
        else if (heap.size() == 1){
            // If there's only one element, return that element and make the list null
            Integer tmp = heap.remove(0);
            heap = null;
            return tmp;
        }
        else{
            // For a complete heap tree, remove the main node and put the last element in its place. 
            // After that, rebalance the heap.

            //Start with returning the value of the top element and then remove it from the tree, swapping with the last one;
            int maxValue = heap.get(0);
            
            heap.set(0, heap.remove( heap.size() - 1));

            //After that is done, calls the SinkDown function.
            sinkDown(0);

            return maxValue;
        }
    }

    // Helper methods

    private void sinkDown(int index){
        
        int maxValue = index;
        int heapSize = heap.size();

        while (true){
            int leftChild = leftChildIndex(index);
            int rightChild = rightChildIndex(index);

            if (leftChild < heapSize && heap.get(leftChild) > heap.get(maxValue)){
                maxValue = leftChild;
            }
            if (rightChild < heapSize && heap.get(rightChild) > heap.get(maxValue)){
                maxValue = rightChild;
            }
            if (heap.get(maxValue) > heap.get(index)){
                swap(index, maxValue);
                index = maxValue;
                
            } else {return;}
        }
    }

    public List<Integer> getHeap(){
        /** Returns a copy of the heap to avoid changes in the main structure */
        return new ArrayList<>(heap);
    }

    private int leftChildIndex (int index){
        return (index * 2 + 1);
    }

    private int rightChildIndex (int index){
        return (index * 2 + 2);
    }

    private int parentIndex(int index){
        return ((index - 1)/2);
    }

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
        
    }
}
