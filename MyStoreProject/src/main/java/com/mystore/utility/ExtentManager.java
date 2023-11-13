package com.mystore.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;	
	public static void setExtent()throws IOException
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","MyHost");
		extent.setSystemInfo("ProjectName","MyStoreProject");
		extent.setSystemInfo("Tester","Abhishek");
		extent.setSystemInfo("OS","Windows 11");
		extent.setSystemInfo("Browser","Chrome");
	}
	public static void endReport()
	{
		extent.flush();
	}
}