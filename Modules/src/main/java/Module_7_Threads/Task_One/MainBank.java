package Module_7_Threads.Task_One;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainBank {

    public static void main(String[] args) {
        Account bankAcc[] = BankInfo.getBankAccounts();
        Transaction transaction[] = BankInfo.getTransactions();


        for (int i = 0; i < transaction.length; i++) {
            int complete = 0;
            for (int j = 0; j < bankAcc.length; j++) {
                if (complete >= 2) break;
                if (transaction[i].getAccountId_from().equals(bankAcc[j].getAccountId())) {
                    transaction[i].setAccount_from(bankAcc[j]);
                    complete++;
                } else if (transaction[i].getAccountId_to().equals(bankAcc[j].getAccountId())) {
                    transaction[i].setAccount_to(bankAcc[j]);
                    complete++;
                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(transaction.length);
        for (int i = 0; i < transaction.length; i++) {
            executorService.execute(new BankOperation(transaction[i]));
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------");
        System.out.println("Updated Accounts: \n");
        for (Account account : bankAcc) {
            System.out.println(account);
        }
    }
}
