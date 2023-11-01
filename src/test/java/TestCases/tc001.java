package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.SwayamsikkimLogin;

public class tc001 extends Baseclass1 {
	@Test
	public void logintest1() throws IOException  {

		driver.get(baseURL);
		log.info("url is enter");
		driver.manage().window().maximize();

		SwayamsikkimLogin lo=new SwayamsikkimLogin(driver);

		lo.setmail(email);
		log.info("email is entered");

		lo.setpassbutton();

		lo.setpassword(password);
		log.info("email is password");
		lo.setlogin();
		lo.setcategories();
		String actual_res=driver.getTitle();

		String exp_res="Buy the best organic products, spices, handlooms and more at reasonable prices. Order directly from producers through Swayam Sikkim.";
		System.out.println(actual_res);
		 if(actual_res.equals(exp_res)){
	        	Assert.assertTrue(true);
	        	log.info("testcase is passed");
	        	
	        }
	        else{
	        	captureScreenshot( driver,"logintest1" );
	        	Assert.assertFalse(true);
	        	log.info("testcase is failed");
	        }
	}
}
