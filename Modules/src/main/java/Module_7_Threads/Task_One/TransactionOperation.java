package Module_7_Threads.Task_One;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionOperation {

    private TransactionOperation() {

    }

    private static TransactionOperation transInstance = null;

    public static TransactionOperation getTransInstance() {
        if (transInstance == null) {
            synchronized (TransactionOperation.class) {
                if (transInstance == null) {
                    transInstance = new TransactionOperation();
                }
            }
        }


        return transInstance;
    }

    public void handleTransaction(Transaction transaction) {
        synchronized (transaction.getAccount_from()) {
            synchronized (transaction.getAccount_to()) {
                transaction.getAccount_from().withdraw(transaction.getAmmount());
                transaction.getAccount_to().deposit(transaction.getAmmount());
            }
        }
    }
}
