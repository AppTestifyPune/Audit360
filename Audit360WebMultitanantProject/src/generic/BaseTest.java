package generic;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

public abstract class BaseTest implements IAutocanstant {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest parentTest;
	public static ExtentTest chiledTest;
	public static KlovReporter Klov;

	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(IE_KEY, IE_VALUE);
		System.setProperty(ME_KEY, ME_VALUE);
		System.setProperty(OP_KEY, OP_VALUE);
	}
  
	@BeforeSuite
	public void setUp()
	{
	//	htmlReporter = new ExtentHtmlReporter("./Reports/Audit360 Automation Report16Nov.html");
		htmlReporter = new ExtentHtmlReporter("./Reports/Audit360 Automation Report_28March08.1(02).html");
		htmlReporter.setAppendExisting(false);
		extent = new ExtentReports();
		htmlReporter.config().setReportName("Audit360 Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent.setSystemInfo("User Name", "Hithesh A");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Java Version", "1.8.0_161");
		extent.setSystemInfo("Host Name", "SAMLP13090001");
		extent.setSystemInfo("environment", "Automation");
		extent.attachReporter(htmlReporter);

		/*Klov = new KlovReporter();
		Klov.initMongoDbConnection("localhost:27017");
		Klov.setKlovUrl("http://localhost:80");
		Klov.setProjectName("Audit360");
		Klov.setReportName("Hithesh");
		extent.attachReporter(htmlReporter,Klov);*/
	}

	@BeforeClass
	public void OpenApplication()
	{
		//driver = new OperaDriver();
		driver = new ChromeDriver();
	//	driver = new FirefoxDriver();
		String url= Lib.getProperty(CONFIG_PATH,"URL");
		driver.get(url);
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}


	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE){
			chiledTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			chiledTest.log(Status.FAIL, result.getThrowable());
			String ScreenshotName = null;
			String screenshotpath = GetScreenshots.addFullPageScreenshot(driver, ScreenshotName);
			chiledTest.addScreenCaptureFromPath(screenshotpath);}
		else if(result.getStatus()==ITestResult.SUCCESS){
			chiledTest.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));}	

	}


	@AfterClass
	public void CloseApplication()
	{
		driver.close();
		driver.quit();
		extent.flush();
	}

	//@AfterSuite
	public void SendEmail() throws EmailException
	{

		//authentication info
		final String username = "hithesh1619@gmail.com";
		final String password = "9739602562";
		String fromEmail = "hithesh1619@gmail.com";
		String toEmail = "hithesh1619@gmail.com";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		//from here mail will start message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Automation Reports");
			
			Multipart emailContent = new MimeMultipart();

			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Please find the below Attched Automation Reports");

			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();
			MimeBodyPart pdfAttachment1 = new MimeBodyPart();
			pdfAttachment.attachFile("./Reports/Audit360 Automation Report.html");
			pdfAttachment1.attachFile("./test-output/emailable-report.html");

			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			
			//Attaching the Extend reports
			emailContent.addBodyPart(pdfAttachment);
			
			//Attaching the TestNG reports
			emailContent.addBodyPart(pdfAttachment1);

			//Attach multipart to message
			msg.setContent(emailContent);

			Transport.send(msg);
			System.out.println("Sent message");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


