package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.inject.Key;

import generic.BaseTest;
import generic.Lib;

public class ReAuditPageTest extends BaseTest {

	//Clicking on the Reaudit Button
	@FindBy(xpath="//input[@value='Reaudit']")
	private WebElement ReauditBTN;

	//Passing the Value to Reaudit Remarks text field
	@FindBy(xpath="//input[@id='review_audit_compliance_reaudit_comments']")
	private WebElement ReauditRemarks;


	public ReAuditPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickReAuditButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(ReauditBTN));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ReauditBTN);
		System.out.println("Reaudit Button is Clicked");
	}


	public void SetReauditRemarks(String RR, WebDriver driver)
	{
		ReauditRemarks.sendKeys(RR);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		System.out.println("Entered ReAudit Remarks is : " + RR);
	}
	
	public void VerifyReAuditRemarksIsRequiredFiled(WebDriver driver) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ReauditRemarks = driver.findElement(By.xpath("//textarea[@name='review_audit_compliance[reaudit_comments]']"));
		if(wait.until(ExpectedConditions.visibilityOf(ReauditRemarks)).isDisplayed()){
			System.out.println("Pass :  Reaudit Remarks is Required Field");
			ReauditRemarks.sendKeys("reaudittest");
			Thread.sleep(2000);} //new change
		
}

	public void VerifyComplianceWasSuccessfullyUpdatedMSGIsDisplayed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Actaul_Text = SuccessMSG.getText();
			String Expected_Text = "Compliance was successfully updated.";
			Assert.assertEquals(Actaul_Text, Expected_Text);
			System.out.println("Pass : Compliance was successfully updated Message is Displayed");
		}

	}
	
	public void VerifyColor(WebDriver driver)
	{
		String BlueColor = Lib.getCellValue(XLPATH, "Review Audit", 56, 0);
		String color = driver.findElement(By.xpath("//table[@id='tableWithSearchSummary']/tbody/tr[1]")).getCssValue("background-color");
		String hex = Color.fromString(color).asHex();
		//Validating the color
		Assert.assertEquals(hex, BlueColor, "Color of the Checkpoint is wrong");
		chiledTest.log(Status.INFO, "color is Displayed for Reopened Checkpoint");
		System.out.println("Color is Displayed for Reopened Checkpoint");
		
	}


}
