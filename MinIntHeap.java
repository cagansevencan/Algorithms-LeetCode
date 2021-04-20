import java.util.Arrays;

public class MinIntHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;

    }

    private void ensureExtraCapacity(){
        if(size ==  capacity){
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek(){
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    //Extract the min element and remove it from the array
    public int poll(){
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        //Take the last element and move it into first array
        items[0] = items[size - 1];
        //Shrink size of the array
        size--;
        //Re Heapify
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        //Swap each element with parent as necessary
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;
        //Walk up as long as theres a parent item
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            //Walk upwards
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        //As long as theres children keep walking down and fix up my heap
        //If theres no left child theres certainly no right child
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            //If theres a right child and it is smaller than left,
            // small child index should equal right child
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            //If im smaller than smaller of my two children, everything's good
            if(items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(index, smallerChildIndex);
                //And move down to my smaller child
            }
            index = smallerChildIndex;
        }
    }


}
