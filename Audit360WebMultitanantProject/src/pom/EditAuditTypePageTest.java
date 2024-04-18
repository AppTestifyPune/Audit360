package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class EditAuditTypePageTest extends BaseTest {

	//Clicking on the Delete Button
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	private WebElement DeleteBTN;
	
	//clicking on the OK Button
	@FindBy(xpath="//a[contains(text(),'OK')]")
	private WebElement OKBTN;
	
	//Passing the values to Search 
	@FindBy(xpath="//div[@id='tableWithSearchInner_filter']//input")
	private WebElement SearchBTN;
	
	//clicking on the activate Checkbox
	@FindBy(xpath="//table[@id='tableWithSearchInner']//tbody/tr[1]/td/input[@type='checkbox']")
	private WebElement ActivateBTN;
	

	public EditAuditTypePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickDeleteButton()
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DeleteBTN);
		System.out.println("Delete button is Clicked");
		chiledTest.log(Status.INFO, "Delete button is Clicked");
	}
	
	public void ClickOKButton() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(OKBTN)).click();
		System.out.println("OK button is Clicked");
		chiledTest.log(Status.INFO, "OK button is Clicked");
	}
	
	public void SetsearchBTN(String SB) throws InterruptedException
	{
		SearchBTN.clear();
		
		SearchBTN.sendKeys(SB);
		System.out.println("Searched CP is : " + SB);
		chiledTest.log(Status.INFO, "CP Is Searched");
		
	}
	
	public void ClickActivateButton() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ActivateBTN);
		System.out.println("Activate Button is Clicked");
		chiledTest.log(Status.INFO, "Activate Button is Clicked");
	}
	
	
	public void VerifyAreYouSureYouWantToDeleteAuditTypePopUpIsDisplayed()
	{
		WebElement AreYouSure = driver.findElement(By.xpath("//p[contains(text(),'Are you sure?, You want to delete audit type')]"));
		Assert.assertTrue(AreYouSure.isDisplayed(), " Are you sure?, You want to delete audit type Pop Up is Not Displayed");
		System.out.println("Pass :  Are you sure?, You want to delete audit type pop up is Displayed");
		chiledTest.log(Status.INFO, "Are you sure?, You want to delete audit type pop up is Displayed");
	}
	
	
	public void VerifyAuditTypeWasSuccessfullyDestroyedSuccessMSGIsDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement destroyed = driver.findElement(By.xpath("//span[contains(text(),'Audit type was successfully destroyed')]"));
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(destroyed)).isDisplayed(), "Audit type was successfully destroyed Message is Not Displayed");
		System.out.println("Pass : Audit type was successfully destroyed Success Message is Displayed");
		chiledTest.log(Status.INFO, "Audit type was successfully destroyed Success Message is Displayed");
	}

}
