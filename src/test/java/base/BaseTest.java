package base;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver.AppDriver;
import driver.AppFactory;

public class BaseTest {

	
	 @BeforeMethod
	    public void launchApp() throws MalformedURLException {
	        System.out.println("before method");
	        AppFactory.launchApp();
	        
	    }

	    @AfterMethod
	    public void closeApp(ITestResult result) throws IOException {
	        if(result.getStatus() == ITestResult.FAILURE){
	            //Util.getScreenshot(result.getTestName());
	        }
	        AppDriver.getCurrentDriver().quit();
	        
	    }

	    @BeforeSuite
	    public void serverStart(){
	        System.out.println("before suite");
	        if(AppData.isCloud.contains("false")){
	            //AppiumServer.start();
	        }
	    }

	    @AfterSuite
	    public void serverStop(){
	        //AppiumServer.stop();
	    }
}
