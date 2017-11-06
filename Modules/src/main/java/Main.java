import Module_7_Threads.Task_One.Account;
import Module_7_Threads.Task_One.BankInfo;
import Module_7_Threads.Task_Two.PropertyReader;
import Module_7_Threads.Task_Two.PropertyRunn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public interface Main {
    static void main(String[] args) throws InterruptedException {
           Thread thread = new Thread(new PropertyRunn("file1"));
           Thread thread1 = new Thread(new PropertyRunn("file2"));
           thread.start();
           thread1.start();





    }

}
