package edu.umb.cs681.hw13;

public class Main {
    public static void main(String[] args) throws Exception {

    	ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
		WithdrawRunnable wr = new WithdrawRunnable(account);
		DepositRunnable dr= new DepositRunnable(account);
		
		Thread d1  = new Thread(dr);	
		Thread w1  = new Thread(wr);
		Thread d2  = new Thread(dr);	
		Thread w2  = new Thread(wr);
		Thread d3  = new Thread(dr);	
		Thread w3  = new Thread(wr);
		Thread d4  = new Thread(dr);	
		Thread w4  = new Thread(wr);
		Thread d5  = new Thread(dr);	
		Thread w5  = new Thread(wr);
		Thread d6  = new Thread(dr);	
		Thread w6  = new Thread(wr);
		Thread d7  = new Thread(dr);	
		Thread w7  = new Thread(wr);
		Thread d8  = new Thread(dr);	
		Thread w8  = new Thread(wr);
		Thread d9  = new Thread(dr);	
		Thread w9  = new Thread(wr);
		Thread d10 = new Thread(dr);	
		Thread w10 = new Thread(wr);
		Thread d11 = new Thread(dr);	
		Thread w11 = new Thread(wr);
		Thread d12 = new Thread(dr);	
		Thread w12 = new Thread(wr);		
		
		d1.start();			
		w1.start();		
		d2.start();			
		w2.start();
		d3.start();			
		w3.start();		
		d4.start();			
		w4.start();		
		d5.start();			
		w5.start();		
		d6.start();			
		w6.start();		
		d7.start();			
		w7.start();
		d8.start();			
		w8.start();
		d9.start();			
		w9.start();
		d10.start();		
		w10.start();
		d11.start();		
		w11.start();
		d12.start();		
		w12.start();	
		
		dr.setDone();
		wr.setDone();
		
		d1.interrupt();		
		w1.interrupt();
		d2.interrupt();		
		w2.interrupt();
		d3.interrupt();		
		w3.interrupt();
		d4.interrupt();		
		w4.interrupt();
		d5.interrupt();		
		w5.interrupt();
		d6.interrupt();		
		w6.interrupt();
		d7.interrupt();		
		w7.interrupt();
		d8.interrupt();		
		w8.interrupt();
		d9.interrupt();		
		w9.interrupt();
		d10.interrupt();	
		w10.interrupt();
		d11.interrupt();	
		w11.interrupt();
		d12.interrupt();	
		w12.interrupt();
		
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
			d6.join();
			d7.join();
			d8.join();
			d9.join();
			d10.join();
			d11.join();
			d12.join();
			
			w1.join();
			w2.join();
			w3.join();
			w4.join();
			w5.join();
			w6.join();
			w7.join();
			w8.join();
			w9.join();
			w10.join();
			w11.join();
			w12.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 		
	}
}
