package pom;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class AdditionalInformationPageTest extends BaseTest {

	//Clicking on the Home Header
	@FindBy(xpath="//a[contains(text(),'Home')]")
	private WebElement HomeHeader;

	public AdditionalInformationPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickHomeHeader()
	{
		HomeHeader.click();
	}


	public void VerifyAdditionalInformationsAreIsDisplayedPostEnabledToggleBTN()
	{

		//checking the Total count of TH
		int Actual_Count = driver.findElements(By.xpath("//table[@id='table_addtional_info']/thead/tr/th")).size();
		int Expected_count = 5;
		Assert.assertEquals(Actual_Count, Expected_count, "Total count of Headr is Wrong");

		//checking the Total count of Parameters
		int Actual_Parameters = driver.findElements(By.xpath("//table[@id='table_addtional_info']/tbody/tr")).size();
		int Expected_Parameters = 12;
		Assert.assertEquals(Actual_Parameters, Expected_Parameters, "Total count of Parameters is Wrong");

		//checking the 12 Checkboxes is Displayed
		int Actiual_CheckBoxes = driver.findElements(By.xpath("//input[@class='info_flag']")).size();
		int Expected_CheckBoxes = 12;
		Assert.assertEquals(Actiual_CheckBoxes, Expected_CheckBoxes, "Check box Count is showing Wrong");

		//checking the 12 Is mandatory checkbox is Displayed
		int Actiual_IsMandatoryCheckBox = driver.findElements(By.xpath("//input[@class='is_mandetory']")).size();
		int Expected_IsMandatoryCheckBox = 12;
		Assert.assertEquals(Actiual_IsMandatoryCheckBox, Expected_IsMandatoryCheckBox, "Is Mandatory check box count is showing Wrong");

		//checking the input Type 
		int Actual_InputType = driver.findElements(By.xpath("//select[@class='form-control additional_info datatype']")).size();
		int Expected_InputType = 12;
		Assert.assertEquals(Actual_InputType, Expected_InputType, "Input Type Count is Showing Wrong");

		//checking the input Values 
		int Actual_InputValues = driver.findElements(By.xpath("//input[@id='data_type_value']")).size();
		int Expected_InputValues = 12;
		Assert.assertEquals(Actual_InputValues, Expected_InputValues, "Input Values Count is Showing Wrong");


		//Checking the Parameter Type Header
		WebElement ParameterType = driver.findElement(By.xpath("//th[contains(text(),'Parameter Type')]"));
		Assert.assertTrue(ParameterType.isDisplayed(), "Parameter Type Header is NOT Displayed");
		System.out.println("Parameter Type is Displayed");
		chiledTest.log(Status.INFO, "Parameter Type is Displayed");

		//Checking the Is Mandatory Header
		WebElement IsMandatory = driver.findElement(By.xpath("//th[contains(text(),'Is mandatory?')]"));
		Assert.assertTrue(IsMandatory.isDisplayed(), "Is Mandatory? Header is NOT Displayed");
		System.out.println("Is Mandatory is Displayed");
		chiledTest.log(Status.INFO, "Is Mandatory is Displayed");

		//Checking the  Input Type  Header
		WebElement InputType = driver.findElement(By.xpath("//th[contains(text(),'Input Type')]"));
		Assert.assertTrue(InputType.isDisplayed(), "InputType Header is NOT Displayed");
		System.out.println("Input Type is Displayed");
		chiledTest.log(Status.INFO, "Input Type is Displayed");

		//Checking the Input Value(s) Header
		WebElement InputValues = driver.findElement(By.xpath("//th[contains(text(),'Input Value(s)')]"));
		Assert.assertTrue(InputValues.isDisplayed(), "Input Value(s) Header is NOT Displayed");
		System.out.println("Input Values is Displayed");
		chiledTest.log(Status.INFO, "Input Values is Displayed");

		//checking the RAC Parameter is Displayed
		WebElement RCA = driver.findElement(By.xpath("//textarea[contains(text(),'RCA')]"));
		Assert.assertTrue(RCA.isDisplayed(), "RCA Parameter is NOT Displayed");
		System.out.println("RCA is Displayed");
		chiledTest.log(Status.INFO, "RCA is Displayed");

		//checking the Risk Implication/Consequences Parameter is Displayed
		WebElement Risk = driver.findElement(By.xpath("//textarea[contains(text(),'Risk Implication/Consequences')]"));
		Assert.assertTrue(Risk.isDisplayed(), "Risk Implication/Consequences Parameter is NOT Displayed");
		System.out.println("Risk Implication/Consequences is Displayed");
		chiledTest.log(Status.INFO, "Risk Implication/Consequences is Displayed");

		//checking the Financial Impact Parameter is Displayed
		WebElement FinancialImpact = driver.findElement(By.xpath("//textarea[contains(text(),'Financial Impact')]"));
		Assert.assertTrue(FinancialImpact.isDisplayed(), "Financial Impact Parameter is NOT Displayed");
		System.out.println("Financial Impact is Displayed");
		chiledTest.log(Status.INFO, "Financial Impact is Displayed");

		//checking the Risk Family Parameter is Displayed
		WebElement RiskFamily = driver.findElement(By.xpath("//textarea[contains(text(),'Risk Family')]"));
		Assert.assertTrue(RiskFamily.isDisplayed(), "Risk Family Parameter is NOT Displayed");
		System.out.println("Risk Family is Displayed");
		chiledTest.log(Status.INFO, "Risk Family is Displayed");

		//checking the Recommendation Parameter is Displayed
		WebElement Recommendation = driver.findElement(By.xpath("//textarea[contains(text(),'Recommendation')]"));
		Assert.assertTrue(Recommendation.isDisplayed(), "Recommendation Parameter is NOT Displayed");
		System.out.println("Recommendation is Displayed");
		chiledTest.log(Status.INFO, "Recommendation is Displayed");

		//checking the Corrective Action Plan Parameter is Displayed
		WebElement CorrectiveActionPlan = driver.findElement(By.xpath("//textarea[contains(text(),'Corrective Action Plan')]"));
		Assert.assertTrue(CorrectiveActionPlan.isDisplayed(), "Corrective Action Plan Parameter is NOT Displayed");
		System.out.println("Corrective Action Plan is Displayed");
		chiledTest.log(Status.INFO, "Corrective Action Plan is Displayed");

		//checking the Preventive Action Plan Parameter is Displayed
		WebElement PreventiveActionPlan = driver.findElement(By.xpath("//textarea[contains(text(),'Preventive Action Plan')]"));
		Assert.assertTrue(PreventiveActionPlan.isDisplayed(), "Preventive Action Plan Parameter is NOT Displayed");
		System.out.println("Preventive Action Plan is Displayed");
		chiledTest.log(Status.INFO, "Preventive Action Plan is Displayed");

		//checking the Others1 Parameter is Displayed
		WebElement Others1 = driver.findElement(By.xpath("//textarea[contains(text(),'Others 1')]"));
		Assert.assertTrue(Others1.isDisplayed(), "Others 1 Parameter is NOT Displayed");
		System.out.println("Others 1 is Displayed");
		chiledTest.log(Status.INFO, "Others 1 is Displayed");

		//checking the Others 2 Parameter is Displayed
		WebElement Others2 = driver.findElement(By.xpath("//textarea[contains(text(),'Others 2')]"));
		Assert.assertTrue(Others2.isDisplayed(), "Others 2 Parameter is NOT Displayed");
		System.out.println("Others 2 is Displayed");
		chiledTest.log(Status.INFO, "Others 2 is Displayed");

		//checking the Others 3 Parameter is Displayed
		WebElement Others3 = driver.findElement(By.xpath("//textarea[contains(text(),'Others 3')]"));
		Assert.assertTrue(Others3.isDisplayed(), "Others 3 Parameter is NOT Displayed");
		System.out.println("Others 3 is Displayed");
		chiledTest.log(Status.INFO, "Others 3 is Displayed");

		//checking the Others 4 Parameter is Displayed
		WebElement Others4 = driver.findElement(By.xpath("//textarea[contains(text(),'Others 4')]"));
		Assert.assertTrue(Others4.isDisplayed(), "Others 4 Parameter is NOT Displayed");
		System.out.println("Others 4 is Displayed");
		chiledTest.log(Status.INFO, "Others 4 is Displayed");

		//checking the Others 5 Parameter is Displayed
		WebElement Others5 = driver.findElement(By.xpath("//textarea[contains(text(),'Others 5')]"));
		Assert.assertTrue(Others5.isDisplayed(), "Others 5 Parameter is NOT Displayed");
		System.out.println("Others 5 is Displayed");
		chiledTest.log(Status.INFO, "Others 5 is Displayed");




	}
}
