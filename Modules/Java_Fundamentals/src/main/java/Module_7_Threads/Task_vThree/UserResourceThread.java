package Module_7_Threads.Task_vThree;

public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        IntegerSetterGetter t1 = new IntegerSetterGetter("&quot;1&quot;", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("name2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("name3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("name4", res);
        IntegerSetterGetter t5 = new IntegerSetterGetter("name5", res);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        Thread.sleep(100);
        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        System.out.println("main");
    }
}
