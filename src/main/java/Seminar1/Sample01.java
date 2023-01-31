package Seminar1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * O(f(n)) - О большое
 * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N
 */
public class Sample01 {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        int lastNumber = 10;
        System.out.printf("Sum of all numbers from 1 till %d is equal to %d, numbers of operations is %d\n",
                lastNumber, sum1(lastNumber, counter), counter.get());
    }

    public static int sum1(int lastNumber, AtomicInteger counter) {
        int sum = 0;
        for (int i = 1; i <= lastNumber ; i++) {
            sum = sum + i;
            counter.getAndIncrement();
        }
        return sum;
    }
}
