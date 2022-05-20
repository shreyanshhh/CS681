package edu.umb.cs681.hw14;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	private AccessCounter() {};	
	
	private ConcurrentHashMap <Path, AtomicInteger> hash = new ConcurrentHashMap <Path, AtomicInteger>();
	private static ReentrantLock lock = new ReentrantLock();
	private static AccessCounter instance = null;
	
	public int getCount(Path path) {
		
		return hash.compute(path, (Path k, AtomicInteger v) -> {
			if(v == null) {
				System.out.println(Thread.currentThread().getName() + "\t " + path + " count " + 0);
				return new AtomicInteger(0);
			} else {
				System.out.println(Thread.currentThread().getName() + "\t " + path + " count " + v.get());
				return v;
			}
		}).get();
	}	
	
	public static AccessCounter getInstance() {
		lock.lock();
		try {
			if (instance == null)
				instance = new AccessCounter();
			return instance;
		}
		finally {
			lock.unlock();
		}
	}
	
	public void increment(Path path) {
		
		hash.compute(path, (Path k, AtomicInteger v) -> {
			if(v == null) {
				System.out.println(Thread.currentThread().getName() + "\t Increment : "+ path + "  "  + 1);
				return new AtomicInteger(1);
			} else {
				System.out.println(Thread.currentThread().getName() + "\t Increment : " + path + "  " + (v.get()+1));
				return new AtomicInteger(v.incrementAndGet());
			}
		});
	}
	
}
