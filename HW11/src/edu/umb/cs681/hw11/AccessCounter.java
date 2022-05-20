package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {

    private AccessCounter() {};
	
	private Map<java.nio.file.Path, Integer> hashmap = new HashMap<java.nio.file.Path, Integer>();
    private ReentrantLock nonStaticLock = new ReentrantLock();
    private static ReentrantLock staticLock = new ReentrantLock();
    private static AccessCounter instance = null;


    public void increment(Path path) {
    	nonStaticLock.lock();
        try {
            if (hashmap.get(path) != null)
            	hashmap.put(path, hashmap.get(path) + 1);
            else
            	hashmap.put(path, 1);
        }
        finally {
        	nonStaticLock.unlock();
        }
    }
    
    public int getCount(Path path) {
    	nonStaticLock.lock();
        try {
            if (hashmap.get(path) != null)
                return hashmap.get(path);
            else
                return 0;
        }
        finally {
        	nonStaticLock.unlock();
        }
    }
    
    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if (instance == null)
                instance = new AccessCounter();
            return instance;
        }
        finally {
            staticLock.unlock();
        }
    }

}
