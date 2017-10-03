package Module_One.TasksFrom2To5;

public class Task4 {

    private double[] mass;

    public Task4(double... mass) {
        this.mass = mass;
    }

    public double solve() {

        //double max = -1/0; :/
        double max = Double.NEGATIVE_INFINITY;
        int n2 = mass.length - 1;

        for (int i = 0; i<mass.length/2; i++) {
            if (mass[i] + mass[n2 - i] > max) {
                max = mass[i] + mass[n2 - i];
            }
        }

        return max;
    }
}
