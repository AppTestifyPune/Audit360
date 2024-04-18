
//Testing the functionality of the Cancelled courses
package pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class CancelledCourseListPage {

	//click on search button
	@FindBy(id="_qf_SearchCancelCourse_refresh") 
	private WebElement Search;

	//Verifying the CancelledStatus
	@FindBy(xpath="//div[@class='bDiv']/table/tbody/tr[1]/td[12]")
	private WebElement CancelledStatus;

	//Sending the courseId's
	@FindBy(id="course_code")
	private WebElement CourseID;

	//clicking on from date
	@FindBy(id="start_date")
	private WebElement FromeDate;

	//clicking on to date
	@FindBy(id="end_date")
	private WebElement ToDate;

	//Taking the Value of Teacher code form excel sheet
	@FindBy(xpath="//input[@id='teacher_code']")
	private WebElement Teachercode;

	//Taking the value of the Teacher name from excel sheet 
	@FindBy(xpath="//input[@id='teacher_name']")
	private WebElement TeacherName;

	public CancelledCourseListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickSearchBTN()
	{
		Search.click();
	}

	public void setcourseid(String ci)
	{
		CourseID.sendKeys(ci);
	}

	public void ClearcourseId()
	{
		CourseID.clear();
	}

	public void ClickFromeDate()
	{
		FromeDate.click();
	}

	public void ClickToDate()
	{
		ToDate.click();
	}

	public void SetTeachercode(String TC)
	{
		Teachercode.sendKeys(TC);
	}

	public void SetTeachName1()
	{
		TeacherName.sendKeys(Keys.TAB);
	}

	public void SetTeachName(String TN)
	{
		TeacherName.sendKeys(TN);
	}

	public void VerifyCourseListisDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		SoftAssert softAssertion= new SoftAssert();
		try{
			driver.findElement(By.xpath("//div[@class='mDiv']/div[text()='Course List']")).isDisplayed();

			Reporter.log("Cancelled courselist is Displayed",true);
		}
		catch(Exception e){
			Reporter.log("Cancelled courselist is not Displayed",true);
			softAssertion.assertAll();
		}
	}	


}		




















