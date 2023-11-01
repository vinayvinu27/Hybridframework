package TestCases;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.SwayamsikkimLogin;
import Utilities1.XLUtils;

public class TC_LoginDDT_002 extends Baseclass1 {

	@Test(dataProvider="Logindata")
	public void logindt(String Email,String Password) throws InterruptedException, IOException
	{
		SwayamsikkimLogin lp=new SwayamsikkimLogin(driver);
		driver.get(baseURL);
		lp.setmail(Email);
		Thread.sleep(2000);
		log.info("user name provided");
		lp.setpassbutton();
		log.info("password provided button clickied");
		lp.setpassword(Password);
		Thread.sleep(2000);
		log.info("password provided");
		lp.setlogin();
		Thread.sleep(4000);
		lp.setcategories();
		Thread.sleep(3000);
		lp.SetLogout();
		Thread.sleep(1000);
	}
	@DataProvider(name="Logindata")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/TestData/Logindata.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",2);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}

		}
		return logindata;
	}
}

