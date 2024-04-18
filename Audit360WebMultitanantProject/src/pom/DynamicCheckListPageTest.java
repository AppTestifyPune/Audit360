package pom;

import static org.junit.Assume.assumeNoException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class DynamicCheckListPageTest {


	//Clicking on the scroll bar
	@FindBy(xpath="//div[contains(@class,'scroll-element scroll-y scroll-scrolly_visible')]//div[contains(@class,'scroll-bar')]")
	private WebElement ScrollBar;

	//Clikcing on the Check Points under side menu
	@FindBy(xpath="//ul[contains(@class,'menu-items scroll-content scroll-scrolly_visible')]/li/a/span[text()='Check Points']")
	private WebElement CheckPoints;

	//Clikcing on the Dynamic CheckList
	@FindBy(xpath="//ul[@style='display: block;']/li/a/span[text()='Dynamic Checklist']")
	private WebElement DynamicCheckList;

	//Clicking on the Select Group
	@FindBy(xpath="//span[text()='Select Group']")
	private WebElement SelectGroup;


	//Passing the Values to Select Group
	@FindBy(xpath="//div[@id='select2-drop']//div[contains(@class,'select2-search')]/input[@type='text']")
	private WebElement SetSelectGroup;

	//Clicking on the Matched Text
	@FindBy(xpath="//span[@class='select2-match']")
	private WebElement Matched;

	//Pasing the Values to Entries
	@FindBy(xpath="//select[@name='ckgroupTable_length']")
	private WebElement Entries;

	//Clicking on the Dynamic CheckList Header
	@FindBy(xpath="//a[@class='active']")
	private WebElement DynamicCheckListHeader;
	
	//Passing the Values to Search Text Box
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement Search;
	



	public DynamicCheckListPageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickScrollBar(WebDriver driver)
	{
		Actions action = new Actions(driver);	
		action.moveToElement(ScrollBar).click().build().perform();
	}

	public void ClickCheckPoints(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", CheckPoints);
	}


	public void ClickDynamicCheckList(WebDriver driver)
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", DynamicCheckList);
	}

	public void ClickSelectGroup()
	{
		SelectGroup.click();
	}

	public void SetSelectGroup(String SG)
	{
		SetSelectGroup.sendKeys(SG);
		System.out.println("Select Group Name is : " + SG);
	}

	public void ClickMatched()
	{
		Matched.click();
	}

	public void SetEntries(String SE)
	{
		Entries.sendKeys(SE);
		System.out.println("Entered Entries is : " + SE);
	}
	
	public void ClickDynamicCheckListHeader()
	{
		DynamicCheckListHeader.click();
	}
	
	public void SetSearchBox(String SB)
	{
		Search.clear();
		
		
		Search.sendKeys(SB);
		System.out.println("Searched Name is : " + SB);
	}

	public void VerifyDynamicCheckListPageIsDisplayed(WebDriver driver)
	{

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//Checking Dynamic Checklist Header

		WebElement Header = driver.findElement(By.xpath("//a[@class='active']"));
		if(Header.isDisplayed())
		{
			String Expected_Text = Header.getText();
			String Actual_Text = "DYNAMIC CHECKLIST";
			Assert.assertEquals(Expected_Text, Actual_Text);

		}

		//Checking Group Label

		WebElement GPLabel = driver.findElement(By.xpath("//label[contains(text(),'Groups')]"));
		if(GPLabel.isDisplayed() && SelectGroup.isDisplayed())
		{
			System.out.println("Group Text is Displayed");
			System.out.println("Select Group Drop Down is Displayed");
		}

		//Checking Select Group Drop Down Options are showing
		SelectGroup.click();

		List<WebElement> Options = driver.findElements(By.xpath("//div[@id='select2-drop']//div[@class='scroll-wrapper select2-results']/ul/li/div/span"));
		int Count = Options.size();
		System.out.println("Total Number of Select Group Drop Down Options are : " + Count);
		Assert.assertTrue(Count>1);
		System.out.println("Select Grop Drop down List are Displayed");

		driver.switchTo().activeElement().sendKeys(Keys.TAB);

	}


	public void VerifyDynamicCheckListTableIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//checking the Table Head count
		List<WebElement> THCount = driver.findElements(By.xpath("//table[@id='ckgroupTable']/thead/tr/th"));
		if(THCount.size()==6)
		{
			//Checking SNO
			WebElement SNO = driver.findElement(By.xpath("//table[@id='ckgroupTable']/thead/tr/th[1]"));
			String Expected_Text  = SNO.getText();
			String Actual_text = "SNO";
			Assert.assertEquals(Expected_Text, Actual_text);
			System.out.println("Pass : SNO is Displayed");

			//Checking Check Point intent
			WebElement CheckPointIntent = driver.findElement(By.xpath("//table[@id='ckgroupTable']/thead/tr/th[2]"));
			String Expected_CheckPointIntent  = CheckPointIntent.getText();
			String Actual_CheckPointIntent = "CHECKPOINT INTENT";
			Assert.assertEquals(Expected_CheckPointIntent, Actual_CheckPointIntent);
			System.out.println("Pass : Check Point intent is Displayed");

			//Checking Yes
			WebElement Yes = driver.findElement(By.xpath("//table[@id='ckgroupTable']/thead/tr/th[3]"));
			String Expected_Yes  = Yes.getText();
			String Actual_Yes = "YES";
			Assert.assertEquals(Expected_Yes, Actual_Yes);
			System.out.println("Pass : Yes is Displayed");

			//Checking No
			WebElement No = driver.findElement(By.xpath("//table[@id='ckgroupTable']/thead/tr/th[4]"));
			String Expected_No  = No.getText();
			String Actual_No = "NO";
			Assert.assertEquals(Expected_No, Actual_No);
			System.out.println("Pass : No is Displayed");

			//Checking Partial
			WebElement Patial = driver.findElement(By.xpath("//table[@id='ckgroupTable']/thead/tr/th[5]"));
			String Expected_Patial  = Patial.getText();
			String Actual_Patial = "PARTIAL";
			Assert.assertEquals(Expected_Patial, Actual_Patial);
			System.out.println("Pass : Partial is Displayed");

			//Checking NA
			WebElement NA = driver.findElement(By.xpath("//table[@id='ckgroupTable']/thead/tr/th[6]"));
			String Expected_NA = NA.getText();
			String Actual_Na = "N/A";
			Assert.assertEquals(Expected_NA, Actual_Na);
			System.out.println("Pass : NA is Displayed");


		}
	}

	public void VerifySelectGroupOptionsareDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> Option = driver.findElements(By.xpath("//ul[@class='select2-results']/li/div/span"));
		int count = Option.size();
		System.out.println(count);
		Assert.assertTrue(count==1);

		System.out.println("Pass : Last Check Point Select Group Options are Empty");
	}

	public void VerifySelectGroupOptionsareDisplayed1(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> Option = driver.findElements(By.xpath("//ul[@class='select2-results']/li/div/span"));
		int count = Option.size();
		System.out.println(count);
		Assert.assertTrue(count==2);

		System.out.println("Pass : One Option is Displayed Under Select Group drop down");
	}

	public void VerifyCheckpointUpdatedSuccessfullyMSGIsDisplayed(WebDriver driver) throws InterruptedException
	{
	
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement SuccessMSG = driver.findElement(By.xpath("//div[@class='alert alert-success']/span"));
		if(wait.until(ExpectedConditions.visibilityOf(SuccessMSG)).isDisplayed())
		{
			String Expected_Text = SuccessMSG.getText();
			String Actual_Text = "Checkpoint Updated Successfully";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : Checkpoint Updated Successfully Success Message is Displayed");
		}
	}
	
	public void VerifyNoMatchingRecordsFoundMSGIsDisplayed(WebDriver driver) throws InterruptedException
	{
	
		WebDriverWait wait = new WebDriverWait(driver, 20);

		WebElement NoMatch = driver.findElement(By.xpath("//td[@class='dataTables_empty']"));
		if(wait.until(ExpectedConditions.visibilityOf(NoMatch)).isDisplayed())
		{
			String Expected_Text = NoMatch.getText();
			String Actual_Text = "No matching records found";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Pass : No matching records found Message is Displayed");
		}
	}
}
