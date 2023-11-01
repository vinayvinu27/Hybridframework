package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import Utilities1.readingdata;

public class Baseclass1 {
	readingdata rd=new readingdata();
	public String baseURL=rd.getapplicationurl();
	public String email=rd.getemail();
	public String password=rd.getpassword();
	public static Logger log;
	public static WebDriver driver;

	@BeforeClass
	public void openapplication(){
		log = Logger.getLogger("Hybridframework");
		PropertyConfigurator.configure("./test-output/Log4j.properties");

		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@AfterClass
	public void Closepage()
	{
         driver.close();
	}
	public void captureScreenshot(WebDriver driver,String name ) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("./ScreenShot/"+name+".png");
		FileUtils.copyFile(src, target);
		log.info("screenshot is taken");
	}
	
}
