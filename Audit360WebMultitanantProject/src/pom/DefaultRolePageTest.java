package pom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DefaultRolePageTest {

	//Clicking on the Default Role
	@FindBy(xpath="//div[@id='s2id_default_roles']/a/span[@class='select2-chosen']")
	private WebElement DefaultRole;


	//Passing the Values to Default Role
	@FindBy(xpath="//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']//input[@type='text']")
	private WebElement SetDefaultRole;

	//clikcing on the Yes Button
	@FindBy(xpath="//span[@class='ui-button-text'][text()='Yes']")
	private WebElement YesBTN;

	//Clicking on the No Button
	@FindBy(xpath="//span[@class='ui-button-text'][text()='No']")
	private WebElement NoBTN;

	public DefaultRolePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void ClickDefaultRole()
	{
		DefaultRole.click();
	}

	public void SetDefaultRole(String SD)
	{
		SetDefaultRole.sendKeys(SD);
		System.out.println("Selected Default Role is : " + SD);
	}

	public void ClickYesBTN()
	{
		YesBTN.click();
		System.out.println("yes Button is Clicked");
	}

	public void ClickNoBTN()
	{
		NoBTN.click();
		System.out.println("No Button is Clicked");
	}


	public void VerifyDefaultRolesAreDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement RoleOption = driver.findElement(By.xpath("//ul[@class='select2-results']/li"));
		if(RoleOption.isDisplayed())
		{
			List<WebElement> alloptions = driver.findElements(By.xpath("//ul[@class='select2-results']/li"));
			int count = alloptions.size();
			System.out.println("The Total Number of Default Role Options are : " + count);
			for(int i=1; i<alloptions.size(); i++)
			{
				WebElement All = alloptions.get(i);
				String text = All.getText();
				System.out.println(text);

			}
		}
	}

	public void VerifyAreYouSurePopUpIsDisplayed(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Checking Are You sure pop Up is Displayed
		WebElement AreYouSure = driver.findElement(By.xpath("//span[@id='ui-id-1']"));

		//Changing default role would result in changes in the current screen that you are viewing, Do you wish to proceed?
		WebElement Changing = driver.findElement(By.xpath("//div[@id='dialog_box']"));
		if(AreYouSure.isDisplayed() && Changing.isDisplayed() && YesBTN.isDisplayed() && NoBTN.isDisplayed())
		{

			String Expected_Text = Changing.getText();
			String Actual_Text = "Changing default role would result in changes in the current screen that you are viewing, Do you wish to proceed?";
			Assert.assertEquals(Expected_Text, Actual_Text);
			System.out.println("Are You Sure ? Pop Up is Displayed");
		}
	}



}

