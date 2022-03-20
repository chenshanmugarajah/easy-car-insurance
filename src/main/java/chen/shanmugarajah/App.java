package chen.shanmugarajah;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Chen\\\\Downloads\\\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://mygocompare.gocompare.com/login/");
    	
    	System.out.println("Got page");
    	
    	driver.quit();
    	
    }
}
