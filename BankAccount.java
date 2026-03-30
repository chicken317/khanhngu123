
//BankAccount
public class BankAccount {

    private final String accountNumber;
    private double balance;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String ownerName, double initial_balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        if (initial_balance < 0) {
            System.out.println("ERROR, the balance is invalid");
            this.balance = 0.0;
        } else {
            this.balance = initial_balance;
        }
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("ERROR, the amount must be greater than zero");
        } else {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if ( amount <= 0 || amount > balance) {
            System.out.println("The amount must be greater than zero and less than the initial balance");
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }


    public static void main(String[] args) {

        System.out.println("---TESTING---");
        System.out.println("Khoi tao so du am");
        BankAccount myAccount = new BankAccount("123456789", "Nguyen Van A", -5000);

        System.out.println("Nap tien am ");
        myAccount.deposit(-1000);  

        System.out.println("Nap tien hop le ");
        myAccount.deposit(3600);

        System.out.println("Rut tien qua so du ");
        System.out.println(myAccount.withdraw(5000));

        System.out.println("Rut tien hop le ");
        System.out.println(myAccount.withdraw(1000));

        System.out.println("Xem so du ");
        System.out.println(myAccount.getBalance());
    }

    
}
