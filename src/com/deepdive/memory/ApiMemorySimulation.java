package com.deepdive.memory;

import java.util.HashMap;
import java.util.Map;

// Run 	
public class ApiMemorySimulation {
	// Run this command in Eclipse Run Configurations -> Arguments -> VM Arguments
	//	-Xmx32m -Xlog:gc*
	// DANGER: Unbounded static cache simulates a real production memory leak
    private static final Map<String, byte[]> UNBOUNDED_CACHE = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int requestId = 1; requestId <= 1000; requestId++) {
            handleApiRequest("REQ-" + requestId);
            Thread.sleep(20);
        }
    }

    static void handleApiRequest(String reqId) {
        // 1. Short-lived object: Allocated in Eden space(Birthplace of Younger Generation), dies immediately when method ends
        byte[] tempRequestPayload = new byte[512 * 1024]; // 512 KB
//        System.out.println(reqId);
        // 2. Bug: Storing payload in static map prevents GC from ever freeing it
        if (reqId.endsWith("0")) {
            UNBOUNDED_CACHE.put(reqId, tempRequestPayload);
        }
    }
}
