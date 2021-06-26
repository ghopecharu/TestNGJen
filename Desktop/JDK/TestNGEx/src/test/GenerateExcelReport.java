package test;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;

public class GenerateExcelReport {

	public static void main(String[] args) throws ParserConfigurationException,IOException,SAXException
	{
		ExcelReportGenerator.generateExcelReport("ExcelReport1.xlsx", "/C:/Users/Admin/Desktop/JDK/TestNG/");

	}

}
