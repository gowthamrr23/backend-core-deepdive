package com.deepdive.memory;

public class GCLogExperiment {
		// Run this command in Eclipse Run Configurations -> Arguments -> VM Arguments
		//	-Xms16m -Xmx16m -Xlog:gc*
	public static void main(String[] args) throws InterruptedException {
				System.out.println("Starting project allocation loop...");
				
				// Continuously generate temporary arrays to trigger GC	
				for(int i=0;i<50;i++) {
					// Allocate a 1MB byte array that immediately becomes garbage
					byte[] garbage = new byte[1024 * 1024];
					Thread.sleep(50); // slow down loop so you can watch logs
				}
				System.out.println("Finished.");			
	}

}
