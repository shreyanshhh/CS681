package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {
    public AtomicBoolean done = new AtomicBoolean(false);
    private ThreadSafeBankAccount2 account = null;

    public DepositRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }

    public void setDone() {
        this.done.set(true);
    }
    
    @Override
    public void run() {
        while (true) {
            if (done.get()) {
                System.out.println(Thread.currentThread().getName() + " Money deposited!");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " Money is being deposited...");
            account.deposit(300);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
            	//exception.printStackTrace();
            }
        }
    }
}
