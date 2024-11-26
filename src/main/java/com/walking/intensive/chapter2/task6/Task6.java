package com.walking.intensive.chapter2.task6;

/**
 * Реализуйте представленные ниже методы для расчета
 * НОК (наименьшее общее кратное) и НОД (наибольший общий делитель).
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task6 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Реализуйте метод, который будет возвращать НОК для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getLcm(int m, int n) {
        if (!isValid(m, n)) {
            return -1;
        }

        return m * n / getGcd(m, n);
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcd(int m, int n) {
        if (!isValid(m, n)) {
            return -1;
        }
        if (m == n) {
            return m;
        }

        int maxValue = Math.max(m, n);
        int minValue = Math.min(m, n);

        while (minValue != 0) {
            int remainder = maxValue % minValue;
            maxValue = minValue;
            minValue = remainder;
        }

        return maxValue;
    }

    /**
     * Реализуйте метод, который будет возвращать НОД для чисел, переданных параметрами.
     * Расчет должен производиться с помощью рекурсивной версии алгоритма Евклида.
     *
     * <p>Входные параметры - положительные целые числа.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static int getGcdByEuclideanAlgorithm(int m, int n) {
        if (!isValid(m, n)) {
            return -1;
        }

        return getGcbByRecursionEuclideanAlgorithm(n, m % n);
    }

    static boolean isValid(int a, int b) {
        return a > 0 && b > 0;
    }

    static int getGcbByRecursionEuclideanAlgorithm (int m, int n) {
        if (n == 0) {
            return m;
        }

        return getGcbByRecursionEuclideanAlgorithm(n, m % n);
    }
}
