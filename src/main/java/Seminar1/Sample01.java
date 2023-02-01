package Seminar1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * O(f(n)) - О большое
 * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N
 */
public class Sample01 {

    /**
     * Домашняя работа
     * разработать рекурсивный алгоритм решения задачи Ханойской башни
     * @param args
     */
    public static void main(String[] args) {
//        AtomicInteger counter = new AtomicInteger();
//        int lastNumber = 12;
//        System.out.printf("Sum of all numbers from 1 till %d is equal to %d, numbers of operations is %d\n",
//                lastNumber, sum1(lastNumber, counter), counter.get());
//
//        counter.set(1);
//        System.out.printf("Sum of all numbers from 1 till %d is equal to %d, numbers of operations is %d\n",
//                lastNumber, sum2(lastNumber), counter.get());
//
//        counter.set(0);
//
//        List<Integer> simpleNumberList = findSimpleNumbers(lastNumber, counter);
//        for(int number : simpleNumberList) {
//            System.out.println(number);
//        }
//        System.out.printf("Counter: %d\n", counter.get());

        long startTime = System.currentTimeMillis();
        System.out.printf("Fibonachi for number %d is equal %d (recursion)\n", 45, fib1(45));
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime;
        System.out.printf("Operation was completed during %d ms\n", processingTime);

        startTime = System.currentTimeMillis();
        System.out.printf("Fibonachi for number %d is equal %d (non recursion)\n", 45, fib2(45));
        endTime = System.currentTimeMillis();
        processingTime = endTime - startTime;
        System.out.printf("Operation was completed during %d ms\n", processingTime);

    }

    public static int sum1(int lastNumber, AtomicInteger counter) {
        int sum = 0;
        for (int i = 1; i <= lastNumber ; i++) {
            sum = sum + i;
            counter.getAndIncrement();
        }
        return sum;
    }

    public static int sum2(int lastNumber) {
        return ((1 + lastNumber) * lastNumber) / 2;
    }

    /**
     * [2] Написать алгоритм поиска простых чисел (деляться только на себя и на 1) в диапазоне от 1 до N
     */

    public static List<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter) {
        List<Integer> result = new ArrayList<>();
        boolean simple;
        for (int i = 1; i <= lastNumber ; i++) {
            simple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if(i%j==0) {
                    simple = false;
                    break;
                }
            }
            if (simple)
                result.add(i);
        }
        return result;
    }

    public static void f(int n) {
        System.out.println(n);
        if(n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }
    
    public static int fib1(int number) {
        if(number == 0 || number == 1) return number;
        return fib1(number-1) + fib1(number - 2); // 2^(n - 1)
    }

    public static int fib2(int number) {
        if(number == 0 || number == 1) return number;  // O(n)
        int[] numbers = new int[number+1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i <= number; i++) {
            numbers[i] = numbers[i-1] + numbers[i-2];
        }
        return numbers[number];
    }
}
