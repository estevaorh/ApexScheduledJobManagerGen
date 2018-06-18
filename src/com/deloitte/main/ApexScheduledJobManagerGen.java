package com.deloitte.main;

import java.io.IOException;

public class ApexScheduledJobManagerGen {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("----- Starting Process -----");
		//for(String arg : args) {
//			if(arg.equalsIgnoreCase("h") || arg.equalsIgnoreCase("-h") || arg.equalsIgnoreCase("/h")
//			   ||arg.equalsIgnoreCase("help") || arg.equalsIgnoreCase("-help") || arg.equalsIgnoreCase("/help")) {
//				Help.showHelp();
//			}
			
			if(validateInput(args)) {
				ApexControllerGen.createApexController(args[0], args[1]);
				VisualforcePageGen.createVisualforcePage(args[0], args[1]);
			}
			
		//}
	}

	private static boolean validateInput(String[] args) {
		
		return true;
	}

}
