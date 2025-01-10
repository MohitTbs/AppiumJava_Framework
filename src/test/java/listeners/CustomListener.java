package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.Markup;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.tcw.listeners.ExtentManager;
//import com.tcw.utilities.ScreenshotUtil;
//import com.tcw.utilities.TestUtil;

public class CustomListener implements ITestListener, ISuiteListener{

	public static Date d = new Date();
	public static String fileName = "Extent_" + d.toString().replace(" ", "_").replace(":", "_") + ".html";
//	public static ExtentReports extent = ExtentManager
//			.createInstance(System.getProperty("user.dir") +File.separator+ "target"+File.separator+"reports"+File.separator + fileName);
//
//	public static ExtentTest test;

	public void onTestStart(ITestResult result) {

		//test = extent.createTest(result.getTestClass().getName() + " @TestCase  " + result.getMethod().getMethodName());
//		BasePage bp = new BasePage();
//		bp.log.info("Test Case Started: " + result.getMethod().getMethodName());
		System.out.println("Test Case Started: " + result.getMethod().getMethodName());
		//log.info("Test Case Started: " + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:-" + methodName + " PASSED" + "</b>";
//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//		test.pass(m);
//		BasePage bp = new BasePage();
//		bp.log.info("Test Case Passed: " + result.getMethod().getMethodName());
		System.out.println("Test Case Passed: " + result.getMethod().getMethodName());
//		log.info("Test Case Passed: " + result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {
		// System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing Screenshot");
//		ScreenshotUtil.captureScreenshot();

//		Reporter.log("<a target=\"_blank\" href=" + ScreenshotUtil.fileName + ">Screenshot</a>");
//		Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\" href=" + ScreenshotUtil.fileName + "><img src=" + ScreenshotUtil.fileName
//				+ " height=200 width=200></img></a>");

		/////////////////////////////////// Extent Report ////////////////
		// String exceptionMessage =
		/////////////////////////////////// Arrays.toString(result.getThrowable().getStackTrace());
		/////////////////////////////////// -- It was giving half of the error.
		// test.fail(exceptionMessage);
//		test.fail(result.getThrowable()); // It gives the complete error.
//		String methodName = result.getMethod().getMethodName();
//		String logText = "<b>" + "TEST CASE:- " + methodName + " FAILED" + "</b>";


//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//		test.log(Status.FAIL, m);

//		BasePage bp = new BasePage();
//		//bp.log.info(result.getThrowable().toString());
//		bp.log.info("Test Case Failed: " + result.getMethod().getMethodName());
//		System.out.println("Test Case Failed: " + result.getMethod().getMethodName());
//		log.info("Test Case Failed: " + result.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
//		test.skip(m);

//		BasePage bp = new BasePage();
//		bp.log.info("Test Case Skipped: " + result.getMethod().getMethodName());
		System.out.println("Test Case Skipped: " + result.getMethod().getMethodName());
//		log.info("Test Case Skipped: " + result.getMethod().getMethodName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
//		TestRunner runner = (TestRunner) context;
//		String path = System.getProperty("user.dir");
//		runner.setOutputDirectory(path + "/target/output-testng");

	}

	public void onFinish(ITestContext context) {

//		if (extent != null) {
//
//			extent.flush();
//		}
	}

	public void onFinish(ISuite suite) {
//		File f = new File(projectPath +File.separator+ "src"+File.separator+"test"+File.separator+"resources"+File.separator+"zipFolder");
//		if ((f.exists())) {
//			try {
//				FileUtils.cleanDirectory(f);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		TestUtil.pack();
//
	}
	
}
