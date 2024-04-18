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

import com.aventstack.extentreports.Status;

import generic.BaseTest;

public class SwitchRolePageTest extends BaseTest{
	
	//clicking on the  Switch Role
	@FindBy(xpath="//div[@id='s2id_swith_roles']/a/span[@class='select2-chosen']")
	private WebElement SwitchRole;

	//Passing the Values to Switch Role
	@FindBy(xpath="//div[@id='select2-drop']//input")
	private WebElement SetSwitchRole;
	
	//Clicking on the Matched 
	@FindBy(xpath="//ul[@class='select2-results']/li[1]//span[1]")
	private WebElement Matched;
	
	public SwitchRolePageTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickSwitchRole()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(SwitchRole)).click();

	}
	
	public void SetSwitchRole(String PR)
	{
		SetSwitchRole.sendKeys(PR);
		System.out.println("Selected Switch Role is : " + PR);
	}
	
	public void ClickMatched()
	{
		Matched.click();
	}
	

}
