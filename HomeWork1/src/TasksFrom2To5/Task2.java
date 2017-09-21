package TasksFrom2To5;
import java.lang.Math;


/**
 * Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h.
 * Результат представить в виде таблицы, первый столбец которой – значения аргумента, второй - соответствующие значения функции:
 * f(x) = tg(2*x) - 3
 */

public class Task2 {
    private double a;
    private double b;
    private double h;


    public Task2(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public void solve() {
        for (double i = a; i<b; i+=h) {
            System.out.println("Index: " + i + " Value: " + Math.tan(2*i));
        }
    }
}
