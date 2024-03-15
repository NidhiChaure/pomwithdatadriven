package com.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyLogin {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ishine.apmosys.com/#/login");
		FileInputStream io=new FileInputStream("/home/neetu.pal@apmosys.mahape/Desktop/Neetu.xlsx");
		XSSFWorkbook workbook=  new XSSFWorkbook(io);
		XSSFSheet sheet=workbook.getSheet("Sheet1");

		int rowcount=sheet.getLastRowNum();
		System.out.println("total number of rows present in the sheet:"+rowcount);
		int colcount=sheet.getRow(1).getLastCellNum();
		System.out.println("total number of column present in the sheet:"+colcount);
		
		for(int i=1;i<=rowcount;i++)
			
		{
			XSSFRow celldata= sheet.getRow(i);
		String Username=celldata.getCell(0).getStringCellValue();
		String Password=celldata.getCell(1).getStringCellValue();
		
		LoginPage lp=new LoginPage(driver);
		
				lp.checkusername(Username);
				
				lp.checkpassword(Password);
			
		System.out.println(Username+"|| "+Password);
		
//		XSSFCell cell= celldata.createCell(2);
//		cell.setCellValue("pass");
//		FileOutputStream output=new FileOutputStream("/home/apmosys/eclipse-workspace/OrangeHRMSite/Nidhi12.xlsx");
//		workbook.write(output);
		}
		
		
	}

}
