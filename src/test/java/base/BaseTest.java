package base;

import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver.AppDriver;
import driver.AppFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
public class BaseTest {

	protected Properties prop;
	
	 @BeforeMethod
	    public void launchApp() throws FileNotFoundException, IOException {
	        System.out.println("before method");
	        prop = new Properties();
	        prop.load(new FileInputStream("./src/test/resources/propfiles/userdata.properties"));
	        AppFactory.launchApp();
	        
	    }

	    @AfterMethod
	    public void closeApp(ITestResult result) throws IOException {
	        if(result.getStatus() == ITestResult.FAILURE){
	            Util.getScreenshot(result.getMethod().getMethodName());
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
