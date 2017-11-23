package Module_7_Threads.Task_One;

public class Account {

    private String firstName;

    private String lastName;

    private String accountId;

    private int balance;


    public Account() {
    }

    public Account setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Account setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Account setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }


    public Account setBalance(int balance) {
        this.balance = balance;
        return this;
    }


    public String getAccountId() {
        return accountId;
    }

    public void deposit(int ammount) {
        int x = balance + ammount;
        //Some operations
        int y = x + 50;
        int z = y - 50;
        int d = z * 10;
        int realBalance = d / 10;
        //Some operations
        this.balance = realBalance;
    }

    public void withdraw(int ammount) {
        if (balance - ammount < 0) {
            throw new RuntimeException("Bad ammount" + Thread.currentThread() + "  " + this.accountId);
        }
        int x = balance - ammount;
        //Some operations
        int y = x + 50;
        int z = y - 50;
        int d = z * 5;
        int realBalance = d / 5;
        //Some operations
        this.balance = realBalance;
    }

    @Override
    public int hashCode() {
        int result = 31+6;
        result = result*31 + accountId.hashCode()*2;
        return result;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Account checkAcc = (Account)o;


        return this.accountId.equals(checkAcc.accountId);
    }

    @Override
    public String toString() {
        return this.accountId + "\n" + this.firstName + "\n" + this.lastName +  "\n" + this.balance + "\n";
    }



}
