package TasksFrom2To5;

public class Task3 {

    /**
     * Присвоить матрице заданного размера значения диагональной и побочной матрицы равные единице
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
