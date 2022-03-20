package chen.shanmugarajah;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
	public static void print(String text) {
		System.out.println(text);
	}
	
    public static void main( String[] args ) throws InterruptedException
    {
    	Scanner sc = new Scanner(System.in);
    	
    	print("What is your email?");
    	String email = (sc.nextLine() == "") ? "chenunprofessional@gmail.com" : sc.nextLine();
    	print("What is your password?");
    	String password = (sc.nextLine() == "" ? "Danish24" : sc.nextLine());
    	print("What is your DOB date?");
    	String dobDD = (sc.nextLine() == "" ? "24" : sc.nextLine());
    	print("What is your DOB month?");
    	String dobMM = (sc.nextLine() == "" ? "01" : sc.nextLine());
    	print("What is your DOB year?");
    	String dobYYYY = (sc.nextLine() == "" ? "1999" : sc.nextLine());
    	print("What is your surname?");
    	String surname = (sc.nextLine() == "" ? "Shanmugarajah" : sc.nextLine());
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Chen\\\\Downloads\\\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://mygocompare.gocompare.com/login/");
    	
    	GoCompareWebsite website = new GoCompareWebsite(email, password, dobDD, dobMM, dobYYYY, surname, driver);
    	
    	website.clearCookie();
    	
    	website.SignIn();
    	    	
//    	driver.quit();
    	
    }
}
