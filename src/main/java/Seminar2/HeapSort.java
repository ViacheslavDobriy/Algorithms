package Seminar2;

/**
 * Здесь реализована пирамидальная сортировка
 */
public class HeapSort {
    /**
     * Method which will remodel inserted array
     * @param array - sourse array
     * @param n - number of elements
     * @param i - root node
     */
    static private void heapify(int[] array, int n, int i){

        int largest = i;
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;

        if(leftChild < n) {
            if(array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }

        if(rightChild < n) {
            if(array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }

        if(largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }

    }
    static public void sort(int[] array) {

        int n = array.length;

        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n-1; i >= 0 ; i--) {
             int temp = array[0];
             array[0] = array[i];
             array[i] = temp;

             heapify(array, i, 0);
        }
    }
}
