package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {

        System.out.println(getFlatLocation(20, 7, 340));
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {

        int flatAmountOnFloor = 4;
        int flatAmountInEntrance = floorAmount * flatAmountOnFloor;
        int flatNumberInEntrance;
        int flatNumberOnFloor;
        int entranceNumber;
        int floorNumber;
        String locationOnFloor = "";

        if (flatNumber < 1 || entranceAmount < 1 || floorAmount < 1) {
            return "Некорректные входные данные";
        }

        if (flatNumber > flatAmountOnFloor * floorAmount * entranceAmount) {
            return "Такой квартиры не существует";
        }

        entranceNumber = flatNumber / flatAmountInEntrance;

        if (flatNumber % flatAmountInEntrance != 0) {
            entranceNumber += 1;
        }

        flatNumberInEntrance = flatNumber - (flatAmountInEntrance * (entranceNumber - 1));
        floorNumber = flatNumberInEntrance / flatAmountOnFloor;

        if (flatNumberInEntrance % flatAmountOnFloor != 0) {
            floorNumber += 1;
        }

        flatNumberOnFloor = flatNumberInEntrance - (flatAmountOnFloor * (floorNumber - 1));

        locationOnFloor = switch (flatNumberOnFloor) {
            case 1 -> "слева от лифта, влево";
            case 2 -> "слева от лифта, вправо";
            case 3 -> "справа от лифта, влево";
            case 4 -> "справа от лифта, вправо";
            default -> locationOnFloor;
        };

        return flatNumber + " кв - " + entranceNumber + " подъезд, " + floorNumber + " этаж, " + locationOnFloor;
    }
}
