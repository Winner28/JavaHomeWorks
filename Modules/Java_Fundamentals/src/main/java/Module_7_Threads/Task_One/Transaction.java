package Module_7_Threads.Task_One;


public class Transaction {


    private String transactionId;
    private String accountId_from;
    private String accountId_to;
    private Account account_from;
    private Account account_to;

    private int ammount;

    public Transaction setAccountId_from(String accountId_from) {
        this.accountId_from = accountId_from;
        return this;
    }

    public Transaction setAccountId_to(String accountId_to) {
        this.accountId_to = accountId_to;
        return this;
    }

    public Transaction setAmmount(int ammount) {
        this.ammount = ammount;
        return this;
    }


    public Transaction setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Transaction setAccount_from(Account account_from) {
        this.account_from = account_from;
        return this;
    }

    public Transaction setAccount_to(Account account_to) {
        this.account_to = account_to;
        return this;
    }

    public Account getAccount_from() {
        return account_from;
    }

    public Account getAccount_to() {
        return account_to;
    }

    public String getAccountId_from() {
        return accountId_from;
    }

    public String getAccountId_to() {
        return accountId_to;
    }


    public int getAmmount() {
        return ammount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\nTransaction id: ").append(this.transactionId)
                .append("\nFrom: ").append(this.account_from)
                .append("\nTo: ").append(this.account_to)
                .append("\nAmmount: ").append(ammount);

        return stringBuilder.toString();

    }
}
