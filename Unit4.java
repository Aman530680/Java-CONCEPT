import java.util.concurrent.*;

// ------------------- CUSTOM EXCEPTION -----------------------
class LowBalanceException extends Exception {
    LowBalanceException(String msg) {
        super(msg);
    }
}

// ------------------- BANK ACCOUNT CLASS ---------------------
class BankAccount {

    private int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    // Synchronized method → Thread safety
    public synchronized void withdraw(int amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException("Insufficient Balance! Available: " + balance);
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName() +
                " Withdrawn: " + amount + " | Balance: " + balance);
    }

    public synchronized int getBalance() {
        return balance;
    }
}

// ------------------- MULTITHREADING (Runnable) --------------
class WithdrawTask implements Runnable {

    private BankAccount acc;
    private int amount;

    WithdrawTask(BankAccount acc, int amount) {
        this.acc = acc;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            acc.withdraw(amount);
        } catch (LowBalanceException e) {
            System.out.println(Thread.currentThread().getName() + " -> ERROR: " + e.getMessage());
        } finally {
            System.out.println(Thread.currentThread().getName() + " Transaction Completed.");
        }
    }
}

// ------------------- MAIN CLASS ------------------------------
public class Unit4 {

    public static void main(String[] args) {

        System.out.println("----- UNIT 4 : Exception Handling + Multithreading ------");

        // 1. BASIC EXCEPTION HANDLING
        try {
            int a = 10 / 2;
            System.out.println("Result: " + a);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero!");
        } finally {
            System.out.println("Basic Try-Catch-Finally executed.");
        }

        // 2. CUSTOM EXCEPTION + MULTITHREADING
        BankAccount acc = new BankAccount(1000);

        // Executor framework
        ExecutorService ex = Executors.newFixedThreadPool(3);

        ex.execute(new WithdrawTask(acc, 500));
        ex.execute(new WithdrawTask(acc, 800));
        ex.execute(new WithdrawTask(acc, 200));

        ex.shutdown();

        // 3. EXCEPTION PROPAGATION
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Exception Caught in MAIN: " + e);
        }
    }

    // Exception Propagation
    static void methodA() throws Exception {
        methodB();
    }

    static void methodB() throws Exception {
        throw new Exception("Propagated Exception Example");
    }
}
