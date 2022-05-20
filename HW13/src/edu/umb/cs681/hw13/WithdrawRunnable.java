package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class WithdrawRunnable implements Runnable {
	
    public AtomicBoolean done = new AtomicBoolean(false);
    private ThreadSafeBankAccount2 account = null;

    public WithdrawRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }

    public void setDone() {
        done.set(true);
    }
    
    @Override
    public void run() {
        while (true) {
            if (done.get()) {
                System.out.println(Thread.currentThread().getName() + " Money withdrawn!");
                break;
            }
            System.out.println(Thread.currentThread().getName() + " Money is being withdrawn...");
            account.withdraw(300);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
            	//exception.printStackTrace();
            }
        }
    }
}
