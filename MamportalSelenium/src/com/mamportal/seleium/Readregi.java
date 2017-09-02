package com.mamportal.seleium;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Readregi 
{

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver= new FirefoxDriver();
		driver.get("http://sbybz2233.cloud.dst.ibm.com/mamportal/user/login");
		Thread.sleep(10000);

		ReadExcel RE = new ReadExcel();

		ArrayList<String> dataExcel = RE.readExcelHelp();
		//int j=0;
		for (int i=0;i<dataExcel.size();i++)
		{
			for (int j=0;i<dataExcel.size();)
			{
				driver.findElement(By.id("username")).sendKeys(dataExcel.get(i));
				Thread.sleep(10000);

				//int j =i+1;
				driver.findElement(By.id("password")).sendKeys(dataExcel.get(j+1));
				Thread.sleep(10000);

				driver.findElement(By.className("ibm-btn-arrow-pri")).click();
				Thread.sleep(10000);

				System.out.println("Login to the application successfully");
				Thread.sleep(10000);

				driver.findElement(By.id("role_drop")).click();
				Thread.sleep(10000);

				driver.findElement(By.cssSelector("input[value='142-READER']")).click();
				Thread.sleep(10000);

				driver.findElement(By.id("admin_ok")).click();
				Thread.sleep(10000);

				driver.findElement(By.id("registerNewapp")).click();
				Thread.sleep(10000);

				System.out.println("Registration new app page is successful");
				Thread.sleep(10000);

				driver.findElement(By.id("app_Name")).sendKeys(dataExcel.get(j+2));
				Thread.sleep(10000);

				driver.findElement(By.xpath(".//*[@id='app_id']")).sendKeys(dataExcel.get(j+3));
				Thread.sleep(10000); 
			}
		}
	}
}