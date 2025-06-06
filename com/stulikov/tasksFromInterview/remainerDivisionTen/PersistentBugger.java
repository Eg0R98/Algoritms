package com.stulikov.tasksFromInterview.remainerDivisionTen;

public class PersistentBugger {

    public static int persistenceRec(long n) {
        if (n < 10) {  // Базовый случай: число уже однозначное
            return 0;
        }

        long multiply = 1;
        while (n > 0) {
            multiply *= n % 10;  // берем последнюю цифру и умножаем
            n /= 10;             // удаляем последнюю цифру
        }

        // вызываем функцию снова с результатом умножения цифр и увеличиваем счётчик на 1
        return 1 + persistenceRec(multiply);
    }

//Итеративный вариант

    public static int persistenceIter(long n) {
        int count = 0;
        while (n >= 10) {
            long multiply = 1;
            while (n > 0) {
                multiply *= n % 10;
                n /= 10;
            }
            n = multiply;
            count++;
        }
        return count;
    }
}
