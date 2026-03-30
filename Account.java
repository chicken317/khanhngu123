class Transaction {

    private final String transaction_ID;
    private final String timestamp;
    private final double amount;

    public Transaction(String transaction_ID, double amount, String timestamp) {
        this.transaction_ID = transaction_ID;
        this.amount = amount;
        this.timestamp = timestamp;

    }

    public String get_Transaction_ID() { return transaction_ID; }
    public double get_amount() { return amount; }
    public String get_timestamp() { return timestamp; }

    @Override
    public String toString() {
        return "| time: " + timestamp + " | amount: " + amount + " | ";
    }

}

public class Account {

    public String account_ID;
    public double balance;
    public Transaction[] history;
    public int count;

    public Account(String account_ID, double balance) {
        this.account_ID = account_ID;
        this.balance = balance;
        this.history = new Transaction[1000];
        this.count = 0;
    }

    public void add_Transaction(Transaction t) {
        if (count < history.length) {
            history[count] = t;
            count ++;
            balance += t.get_amount();
        } else {
            for (int i = 0; i < history.length - 1; i ++) {
                history[i] = history[i+1];
                history[history.length - 1] = t;
            }
            balance += t.get_amount();
        }
    } 

    public Transaction[] get_history() {
        Transaction[] copy = new Transaction[1000];
        for (int i = 0; i < count; i += 1) {
            copy[i] = history[i];
        }
        return copy;   
    }
    
    public void print() {
        for (int i = 0; i < count; i += 1) {
            System.out.println(history[i].toString()); 
        }
    }
    
    
    
    public static void main(String[] args) {
        Account HyH = new Account("28241009", 10000);
        Transaction CK1 = new Transaction("ACC-28241009-260308", -2000, "2026-03-08");
        Transaction CK2 = new Transaction("ACC-28241009-260314", -5000, "2026-03-14");
        HyH.add_Transaction(CK1);
        HyH.add_Transaction(CK2);

        System.out.println("---Dong gia Hacker---");
        Transaction[] Hacker_Array = HyH.get_history();
        Hacker_Array[0] = new Transaction("Hacker", 999999, "2026-08-03");
        Hacker_Array[1] = null;

        System.out.println("Result");
        HyH.print();
    }

}