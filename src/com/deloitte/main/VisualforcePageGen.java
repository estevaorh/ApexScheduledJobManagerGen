package com.deloitte.main;

public class VisualforcePageGen {

	public static void createVisualforcePage(String csvFile, String apexName) {
		StringBuffer apexPageCode = new StringBuffer("");
		createPageHeader(apexPageCode, csvFile, apexName);
		createPageFooter(apexPageCode, csvFile, apexName);
		System.out.println(apexPageCode);
	}

	private static void createPageFooter(StringBuffer apexPageCode, String csvFile, String apexName) {
		// TODO Auto-generated method stub
		apexPageCode.append("\n\t\t\t</table>");
		apexPageCode.append("\n\t\t</apex:form>");
		apexPageCode.append("\n\t</apex:pageBlock>");
		apexPageCode.append("\n</apex:page>");
	}

	private static void createPageHeader(StringBuffer apexPageCode, String csvFile, String apexName) {
		apexPageCode.append("\n<apex:page Controller=\""+apexName+"Controller\" sidebar=\"false\">");
		apexPageCode.append("\n\t<apex:pageMessages escape=\"false\"></apex:pageMessages>");
		apexPageCode.append("\n\t<apex:pageBlock title=\""+apexName+"\" >");
		apexPageCode.append("\n\t\t<apex:form >");
		apexPageCode.append("\n\t\t\t<table>");
		apexPageCode.append("\n\t\t\t\t<tr>");
		apexPageCode.append("\n\t\t\t\t\t<td></td>");
		apexPageCode.append("\n\t\t\t\t\t<td></td>");
		apexPageCode.append("\n\t\t\t\t\t<td></td>");
		apexPageCode.append("\n\t\t\t\t</tr>");
		apexPageCode.append("\n\t\t\t\t<tr>");
		apexPageCode.append("\n\t\t\t\t\t<td></td>");
		apexPageCode.append("\n\t\t\t\t\t<td></td>");
		apexPageCode.append("\n\t\t\t\t\t<td></td>");
		apexPageCode.append("\n\t\t\t\t</tr>");
		
	}

}
