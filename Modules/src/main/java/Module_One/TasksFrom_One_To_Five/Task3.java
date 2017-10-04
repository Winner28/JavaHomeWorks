package Module_One.TasksFrom_One_To_Five;

public class Task3 {

    /**
     * Получить матрицу вида:
     *
     * (1 0 1)
     * (0 1 0)
     * (1 0 1)
     */

    private int size;
    private int matrix[][];

    public Task3(int size) {

        matrix = new int[size][size];
        this.size = size;

    }

    public void show() {

        for (int i =0, d = size-1; i<size || d ==0; i++, d--) {
            System.out.println(" ");
            for (int j = 0; j<size; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
                if (d == j) {
                    matrix[i][j] = 1;
                }
                System.out.print(" " + matrix[i][j]);
            }
        }
    }
}
