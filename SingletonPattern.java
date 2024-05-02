package com.nabil.main;

/**
 * Driver class
 */
public class SingletonPattern {

    public static void main(String[] args) {
        /*
         * For first time call to LazySingleton.getInstance() method, a new object will be created.
         * For subsequent call to LazySingleton.getInstance() method, no new object will be created.
         * Previously created object will be re-used here.
         */
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

    }
}

/**
 * Lazy initialization approach of singleton design pattern
 */
class LazySingleton {

    // Just declare the instance, do not initialize it now
    private static LazySingleton instance = null;

    // Private constructor, so it cannot be instantiated outside this class
    private LazySingleton() {
        System.out.println("LazySingleton object created");
    }

    /**
     * Check if the instance is null within a synchronized block. If so then create the object
     * Double locking is used to reduce the overhead of the synchronized method
     * The second if is basically reducing the overhead, there maybe multiple thread successfully passed the first if, 
     * but after synchronization we have to check again if any thread have already entered before the current thread,
     * this process is double locking
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
