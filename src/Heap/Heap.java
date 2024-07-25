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



    // Helper methods

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
