package com.deloitte.main;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

import com.opencsv.CSVReader;

public class ApexControllerGen {

	public static boolean createApexController(String csvSetupFilePath, String apexName) throws IOException {
		try {
		 Reader reader = Files.newBufferedReader(Paths.get(csvSetupFilePath));
         CSVReader csvReader = new CSVReader(reader);
         
			StringBuffer apexClassCode = new StringBuffer("");
			
			generateHeaderComments(apexClassCode, apexName);
			generateClassHeader(apexClassCode, apexName);
			generateClassBody(apexClassCode, apexName, csvReader);
			generateClassFooter(apexClassCode, apexName);
			
			System.out.println(apexClassCode);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private static void generateClassBody(StringBuffer apexClassCode, String apexName, CSVReader csvReader) throws IOException {
	
		String[] nextRecord;
		int i=0;
        while ((nextRecord = csvReader.readNext()) != null) {
        	if(i==0) {
        		i++;
        		continue; //skip header
        	}
        	i++;
        	apexClassCode.append("\n\n\t/**");
        	apexClassCode.append("\n\t * "+nextRecord[2]);
        	apexClassCode.append("\n\t *");
        	apexClassCode.append("\n\t */");
        	
        	
        	apexClassCode.append("\n\tpublic PageReference "+nextRecord[0]+"(){");
        	apexClassCode.append("\n\t\tPageReference page;");
        	apexClassCode.append("\n\t\ttry{");
        	apexClassCode.append("\n\t\t\t"+nextRecord[0] + " jobToSchedule = new "+nextRecord[0]+"();");
        	apexClassCode.append("\n\t\t\tString scheduleExpression = '"+nextRecord[1]+"';");
        	apexClassCode.append("\n\t\t\t"+nextRecord[0]+".schedule('"+nextRecord[0]+" Job', scheduleExpression, jobToSchedule);");
        	apexClassCode.append("\n\t\t} ");
			apexClassCode.append("\n\t\tcatch(Exception e){");
			apexClassCode.append("\n\t\t\tApexPages.addMessages(e);");
			apexClassCode.append("\n\t\t\treturn page;");
			apexClassCode.append("\n\t\t}");
	
			apexClassCode.append("\n\t\tApexPages.Message msg = new ApexPages.Message(ApexPages.Severity.CONFIRM, '"+nextRecord[0]+" has been scheduled');");
			apexClassCode.append("\n\t\tApexPages.addMessage(msg);"); 
			apexClassCode.append("\n\t\treturn page;");
			apexClassCode.append("\n\t}");
			
			apexClassCode.append("\n\tpublic PageReference kill_"+nextRecord[0]+"() {");
			apexClassCode.append("\n\t\treturn killSingleJob('"+nextRecord[0]+" Job');");
			apexClassCode.append("\n\t}");
  
        }
		
		
	}

	private static void generateClassFooter(StringBuffer apexClassCode, String apexName) {
		apexClassCode.append("\n");
		apexClassCode.append("}");
	}

	private static void generateClassHeader(StringBuffer apexClassCode, String apexName) {
		apexClassCode.append("\n");
		apexClassCode.append("public Class "+apexName+"Controller{");	
	}

	private static void generateHeaderComments(StringBuffer apexClassCode, String apexName) {
		apexClassCode.append("\n/**");
		apexClassCode.append("\n*  "+apexName+" Apex Class generated used ApexScheduledJobManagerGen");
		apexClassCode.append("\n*  Genereted on "+Calendar.getInstance().getTime());
		apexClassCode.append("\n*/");
		
	}
	
}
