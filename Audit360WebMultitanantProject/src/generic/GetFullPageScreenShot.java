package generic;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class GetFullPageScreenShot {
	
	public static String captureFullPage(WebDriver driver, String screenShotNameFullPage) throws IOException
    {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String dest = "/Reports/" + screenshot + ".png";    
        ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
        return dest;
        
  
    }
	
	
        
       /*public static String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException
        {
        	String dateName = new SimpleDateFormat("YYYYMMDHHMMMSS").format(new Date());
        	TakesScreenshot ts = (TakesScreenshot)driver;
        	File source = ts.getScreenshotAs(OutputType.FILE);
        	String destination = System.getProperty("user.dir") + "/ErrorScreenshots/" + ScreenshotName + dateName + ".png";
        	File FinalDestination = new File(destination);
        	FileUtils.copyFile(source, FinalDestination);
        	
        	 String Imagepath = "file://Machinename/ErrorScreenshots/"+ ScreenshotName + dateName+".png";
             return Imagepath;
        }*/
    }

