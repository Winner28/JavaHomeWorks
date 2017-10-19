package Module_1_Intro.TasksFrom_One_To_Five;




/**
 * Найти наименьший номер элемента последовательности,
 * для которого выполняется условие exit_condition. Вывести на экран этот номер и все элементы ai  где i = 1, 2, ..., п.
 */

public class Task1 {


    private int exit_condition;
    private int number_sequency;



    public Task1(int number_sequency ,int exit_condition) {

        this.number_sequency = number_sequency;
        this.exit_condition = exit_condition;

    }


    public int solve() {

        double min_number = 100;

        int min_element = 1;

        for (int i =0; i<number_sequency; i++) {

            double result = Math.pow(Math.pow((i+1),2), -1);

             if (result < min_number) {
                 min_number = result;
                 min_element = i;
             }

             if (result >= exit_condition) {
                 return min_element;
            }

            print(i,result);

        }

        System.out.println("The minimal element is: " + min_element);

        return min_element;
    }





    public void print(int i, double result) {
        System.out.printf("Index:%d Value: %f\n",i,result);
    }



}
