package Seminar1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * O(f(n)) - О большое
 * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N
 */
public class Sample01 {

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

        f(4);
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
}
