package Seminar2;

import java.util.Random;

/**
 * Массивы - структуры. Алгоритмы
 */
public class Sample {

    public static void main(String[] args) {

//        int[] arr1 = ArrayUtils.prepareArray();
//        ArrayUtils.printArray(arr1);
//        SortUtils.directSort(arr1);
//        ArrayUtils.printArray(arr1);
//
//        System.out.println();
//
//        int[] arr2 = ArrayUtils.prepareArray();
//        ArrayUtils.printArray(arr2);
//        SortUtils.insertionSort(arr2);
//        ArrayUtils.printArray(arr2);
//
//        System.out.println();
//
//        int[] arr3 = ArrayUtils.prepareArray();
//        ArrayUtils.printArray(arr3);
//        SortUtils.quickSort(arr3);
//        ArrayUtils.printArray(arr3);
//
//        //-------
//
//        int[] testArray = ArrayUtils.prepareArray(10000);
//
//        long startTime = System.currentTimeMillis();
//        SortUtils.directSort(testArray.clone());
//        long endTime = System.currentTimeMillis();
//        long processingTime = endTime - startTime;
//        System.out.printf("Processing time of direct sort is %d ms\n", processingTime);
//
//        startTime = System.currentTimeMillis();
//        SortUtils.insertionSort(testArray.clone());
//        endTime = System.currentTimeMillis();
//        processingTime = endTime - startTime;
//        System.out.printf("Processing time of insertion sort is %d ms\n", processingTime);
//
//        startTime = System.currentTimeMillis();
//        SortUtils.quickSort(testArray.clone());
//        endTime = System.currentTimeMillis();
//        processingTime = endTime - startTime;
//        System.out.printf("Processing time of quick sort is %d ms", processingTime);

        int[] testArray2 = new int[] {-4, -10, 99, -20, 22, 0, 1, 99, 100, 30};
        ArrayUtils.printArray(testArray2);
        SortUtils.quickSort(testArray2);
        ArrayUtils.printArray(testArray2);
        int res = SearchUtils.binarySearch(testArray2, -5);
        System.out.printf("Elem %d %s", -5,
                res >= 0 ? String.format("was found in array in by index %d", res) : "was not found in array");
    }

    static class SearchUtils{

        public static int binarySearch(int[] array, int value){
            return binarySearch(array, value, 0, array.length - 1);
        }
        public static int binarySearch(int[] array, int value, int min, int max) {
            int middle;
            if (max < min){
                return -1;
            }
            middle = (max - min) / 2 + min;

            if (array[middle] < value) {
                return binarySearch(array, value, middle + 1, max);
            } else{
                if (array[middle] > value) {
                    return binarySearch(array, value, min, middle - 1);
                } else {
                    return middle;
                }
            }
        }
    }
    static class SortUtils{

        public static void directSort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                int min = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[min]) {
                        min = j;
                    }
                }
                    if (i != min) {
                        array[i] = array[i] + array[min];
                        array[min] = array[i] - array[min];
                        array[i] = array[i] - array[min];
                    }
                }
            }

        public static void insertionSort(int[] array) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if(array[j] < array[i]) {
                        int buf = array[i];
                        array[i] = array[j];
                        array[j] = buf;
                    }
                }
            }
        }

        public static void quickSort(int[] array) {
            quickSort(array, 0, array.length - 1);
        }
        public static void quickSort(int[] array, int startPosition, int endPosition) {
            int leftPosition = startPosition;
            int rightPosition = endPosition;
            int pivot = array[(startPosition + endPosition) / 2];

            do {
                while (array[leftPosition] < pivot)
                    leftPosition++;
                while (array[rightPosition] > pivot)
                    rightPosition--;
                if (leftPosition <= rightPosition) {
                    if (leftPosition < rightPosition) {
                        int buf = array[leftPosition];
                        array[leftPosition] = array[rightPosition];
                        array[rightPosition] = buf;
                    }
                    leftPosition++;
                    rightPosition--;
                }
            }
            while (leftPosition <= rightPosition);
            if (leftPosition < endPosition)
                quickSort(array, leftPosition, endPosition);
            if(startPosition < rightPosition)
                quickSort(array, startPosition, rightPosition);
        }
    }

    static class ArrayUtils{

        private static Random random = new Random();

        private static int[] prepareArray() {
            int[] arr = new int[random.nextInt(16) + 5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100);
            }
            return arr;
        }

        private static int[] prepareArray(int length) {
            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100);
            }
            return arr;
        }

        private static void printArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("%d ", arr[i]);
            }
            System.out.println();
        }
    }
}
