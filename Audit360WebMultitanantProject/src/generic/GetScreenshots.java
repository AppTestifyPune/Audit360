package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class GetScreenshots {

	public static String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException
    {
    	String dateName = new SimpleDateFormat("YYYYMMDHHMMMSS").format(new Date());
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	String destination = "/Reports/" + screenshot + dateName + ".png";    	
    	File FinalDestination = new File(destination);
    	FileUtils.copyFile(source, FinalDestination);
		return destination;
		
		/*String Imagepath = "file:/SAMLP13090001/Reports/"+".png";
		return Imagepath;*/
		
    }
	
	//Base 64 Conversion
	public static String addScreenshot(WebDriver driver, String ScreenshotName) {
	    File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
	    String encodedBase64 = null;
	    FileInputStream fileInputStreamReader = null;
	    
	    try {
	        fileInputStreamReader = new FileInputStream(scrFile);
	        byte[] bytes = new byte[(int)scrFile.length()];
	        fileInputStreamReader.read(bytes);
	        encodedBase64 = new String(Base64.encodeBase64(bytes));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "data:image/png;base64,"+encodedBase64;
	}
	
	
	public static String addFullPageScreenshot(WebDriver driver, String ScreenshotName) {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
    	File source = ts.getScreenshotAs(OutputType.FILE);
	    String encodedBase64 = null;
	    FileInputStream fileInputStreamReader = null;
	    try {
	        fileInputStreamReader = new FileInputStream(source);
	        byte[] bytes = new byte[(int)source.length()];
	        fileInputStreamReader.read(bytes);
	        encodedBase64 = new String(Base64.encodeBase64(bytes));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "data:image/png;base64,"+ encodedBase64;
	}
	
    public static int WAIT(WebElement element) throws Exception {
		
        int i=0;int j=0;
		for ( i = 0; i <= 3; i++) {
			try {
				if (element.isDisplayed()) {
					System.out.println("Took wait for visible element:" + i + "sec");
					i=j;
					i = 4;
				}
			} catch (Exception e) {
				Thread.sleep(600);
				System.out.println("Timer:" + i + "sec");
				System.out.println(e.getMessage());
			}
		}
		return j;
		
	}
	
	
}
