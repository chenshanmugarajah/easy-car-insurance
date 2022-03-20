package chen.shanmugarajah;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoCompareWebsite {

	private String email;
	private String password;
	private String dobDate;
	private String dobMonth;
	private String dobYear;
	private String surname;
	private WebDriver driver;
	
	public GoCompareWebsite(String email, String password, String dobDate, String dobMonth, String dobYear,
			String surname, WebDriver driver) {
		super();
		this.email = email;
		this.password = password;
		this.dobDate = dobDate;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
		this.surname = surname;
		this.driver = driver;
		
	}
	
	public void SignIn() {
		driver.findElement(By.id("emailAddress")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("dobDD")).sendKeys(dobDate);
		driver.findElement(By.id("dobMM")).sendKeys(dobMonth);
		driver.findElement(By.id("dobYYYY")).sendKeys(dobYear);
		driver.findElement(By.id("signInButton")).click();
	}
	
	public void clearCookie() {
		// clearing cookie modal
		WebElement cookiesBox = driver.findElement(By.className("qc-cmp2-summary-buttons"));
		WebElement cookiesFinal = cookiesBox.findElements(By.tagName("button")).get(1);
		cookiesFinal.click();	
	}
}
