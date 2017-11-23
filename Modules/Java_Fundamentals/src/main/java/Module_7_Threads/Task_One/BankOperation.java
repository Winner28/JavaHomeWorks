package Module_7_Threads.Task_One;


public class BankOperation implements Runnable {


    private Transaction transaction;
    private TransactionOperation transactionOperation;


    public BankOperation(Transaction transaction) {

        transactionOperation = TransactionOperation.getTransInstance();
        this.transaction = transaction;

    }


    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transactionOperation.handleTransaction(transaction);
    }




}
