package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ListenerTest extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {


	}

	@Override
	public void onTestSuccess(ITestResult result) {

		/*chiledTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));*/
	}

	@Override
	public void onTestFailure(ITestResult result) {

		/*chiledTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		chiledTest.log(Status.FAIL, result.getThrowable());
		String ScreenshotName = null;
		String screenshotpath = GetScreenshots.addFullPageScreenshot(driver, ScreenshotName);
		try {
			chiledTest.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
		}*/

	}


	@Override
	public void onTestSkipped(ITestResult result) 
	{
		chiledTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		chiledTest.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) 
	{

	}
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{


	}

	@Override
	public void onStart(ITestContext context) 
	{

	}
}
