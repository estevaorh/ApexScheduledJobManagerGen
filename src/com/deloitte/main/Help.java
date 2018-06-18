package com.deloitte.main;

public class Help {
	public static void showHelp() {
		System.out.println("----- HELP -----");

		System.out.println("\t----- Usage -----");

		System.out.println("java -jar ApexScheduledJobManagerGen.jar ScheduleJobsSetup.csv ApexName");
		
		System.out.println("\t\t it will give you:");
		System.out.println("\t\t\tApexName.cls       -> Controller Class");
		System.out.println("\t\t\tApexName.vfp       -> Visual Force Page");
		System.out.println("\t\t\tApexName.meta.xml  -> MetaData");
	}
}
