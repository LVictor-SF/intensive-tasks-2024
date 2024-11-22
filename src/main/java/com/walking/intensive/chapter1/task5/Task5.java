package com.walking.intensive.chapter1.task5;

import java.util.Arrays;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {

    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return -1;
        }

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return new double[0];
        }

        double [] triangleHeights = new double[3];

        triangleHeights [0] = 2 * getAreaByHeron(a, b, c) / a;
        triangleHeights [1] = 2 * getAreaByHeron(a, b, c) / b;
        triangleHeights [2] = 2 * getAreaByHeron(a, b, c) / c;

        Arrays.sort(triangleHeights);

        return triangleHeights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return new double[0];
        }

        double [] triangleMedians = new double[3];

        triangleMedians [0] = Math.sqrt(2 * Math.pow(a, 2) + 2 * Math.pow(b, 2) - Math.pow(c, 2)) / 2;
        triangleMedians [1] = Math.sqrt(2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) / 2;
        triangleMedians [2] = Math.sqrt(2 * Math.pow(c, 2) + 2 * Math.pow(a, 2) - Math.pow(b, 2)) / 2;

        Arrays.sort(triangleMedians);

        return triangleMedians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return new double[0];
        }

        double [] triangleBisectors = new double[3];

        triangleBisectors [0] = Math.sqrt(a * b * (a + b + c) * (a + b - c)) / (a + b);
        triangleBisectors [1] = Math.sqrt(a * c * (a + b + c) * (a + c - b)) / (a + c);
        triangleBisectors [2] = Math.sqrt(c * b * (a + b + c) * (c + b - a)) / (c + b);

        Arrays.sort(triangleBisectors);

        return triangleBisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return new double[0];
        }

        double [] triangleAngles = new double[3];

        triangleAngles [0] = getAngle(a, b, c);
        triangleAngles [1] = getAngle(b, c, a);
        triangleAngles [2] = getAngle(c, a, b);

        Arrays.sort(triangleAngles);

        return triangleAngles;

    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return -1;
        }

        return getAreaByHeron(a, b, c) / ((a + b + c) / 2);
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return -1;
        }

        return a * b * c / (getAreaByHeron(a, b, c) * 4);
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {

        if (!isRealTriangle(a, b, c)) {
            return -1;
        }

        double cosA = ((b * b) + (c * c) - (a * a)) / (2 * b * c);

        double sinA = Math.sqrt(1 - cosA * cosA);

        return (c * b * sinA) / 2;
    }

    static boolean isRealTriangle(double a, double b, double c) {

        if (a < 1 || b < 1 || c < 1) {
            return false;
        }

        return ((a + b > c) && (a + c > b) && (c + b > a));
    }

    static double getAngle (double a, double b, double c) {

        double cosA = ((b * b) + (c * c) - (a * a)) / (2 * b * c);

        return (Math.acos(cosA) * 180) / Math.PI;

    }

}
