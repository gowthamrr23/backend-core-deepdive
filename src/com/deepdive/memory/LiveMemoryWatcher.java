package com.deepdive.memory;

public class LiveMemoryWatcher {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running... Open VisualVM now!");

        for (int i = 0; i < 500; i++) {
            // 1. Allocate 1MB locally
            byte[] localTempChunk = new byte[1024 * 1024]; 
            
            // 2. We DO NOT add it to any list.
            // At the end of each iteration, localTempChunk goes out of scope 
            // and the 1MB byte[] becomes 100% dead garbage!

            Thread.sleep(200);
        }
        
        System.out.println("Loop finished.");
    }
}
