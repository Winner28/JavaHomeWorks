package Module_7_Threads.Task_vThree;

import java.util.Collection;
import java.util.Map;
import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private SharedResource resource;
    private boolean run;
    private Random rand = new Random();
    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }
    public void stopThread() {
        run = false;
    }
    public void run() {
        int action;
        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void getIntegersFromResource() throws InterruptedException {
        Integer number;
        synchronized (resource) {
            System.out.println("&quot;Поток &quot;" + getName()
                    + "&quot; хочет извлечь число.&quot;");
            number = resource.getELement();
            while (number == null) {
                System.out.println("&quot;Поток &quot;" + getName()

                        + "&quot; ждет пока очередь заполнится.&quot;");

                resource.wait();
                System.out

                        .println("&quot;Поток &quot; + getName() + &quot; возобновил работу.&quot;");

                number = resource.getELement();
            }
            System.out

                    .println("&quot;Поток &quot; + getName() + &quot; извлек число &quot; "+

                    number);
        }

    }
    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("&quot;Поток &quot; + getName() + &quot; записал число &quot;"

            + number);
            resource.notify();
        }
    }
}
