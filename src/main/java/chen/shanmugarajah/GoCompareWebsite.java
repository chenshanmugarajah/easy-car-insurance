package chen.shanmugarajah;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	
	private String numberPlate;
	private Boolean modified;
	private String price;
	private CarUsage usage;
	
	public GoCompareWebsite(String email, String password, String dobDate, String dobMonth, String dobYear,
			String surname, WebDriver driver, String numberPlate, Boolean modified, String price, CarUsage usage) {
		super();
		this.email = email;
		this.password = password;
		this.dobDate = dobDate;
		this.dobMonth = dobMonth;
		this.dobYear = dobYear;
		this.surname = surname;
		this.driver = driver;
		this.numberPlate = numberPlate;
		this.modified = modified;
		this.price = price;
		this.usage = usage;
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
	
	public void carUsage() {
		String usageValue;
		switch (usage) {
			case SOCIAL_ONLY:
				usageValue = "227";
				break;
			case SOCIAL_INCLUDING_COMMUTE:
				usageValue = "228";
				break;
			case BUSINESS_USE_BY_YOU:
				usageValue = "229";
				break;
			case BUSINESS_USE_BY_YOU_AND_PARTNER:
				usageValue = "230";
				break;
			case BUSINESS_USE_BY_PARTNER:
				usageValue = "231";
				break;
			case BUSINESS_USE_BY_ALL:
				usageValue = "232";
				break;
			case COMMERCIAL_TRAVELLING:
				usageValue = "233";
				break;
		}
	}
	
	public void SetCarDetails() throws InterruptedException {
		driver.findElement(By.className("xsp-button__container")).findElement(By.tagName("a")).click();
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.className("card-secondary")).findElement(By.tagName("a")).click();
		driver.findElement(By.id("AboutCarPanel_RegNumber")).sendKeys(numberPlate);
		driver.findElement(By.id("reg-lookup-button")).click();
		driver.findElement(By.id("AboutCarPanel_DetailsCorrect_true")).click();
		driver.findElement(By.id(modified ? "AboutCarPanel_AnyModifications_true" : "AboutCarPanel_AnyModifications_false"));
		driver.findElement(By.id("AboutCarPanel_EstimatedMarketValue")).clear();
		driver.findElement(By.id("AboutCarPanel_EstimatedMarketValue")).sendKeys(price);
		driver.findElement(By.id("OwningAndUsingCarPanel.LegalOwner")).click();
		driver.findElement(By.id("OwningAndUsingCarPanel.RegisteredKeeper")).click();
		driver.findElement(By.id("OwningAndUsingCarPanel_UseOfVehicle")).click();
		WebElement usageBox =  driver.findElement(By.id("OwningAndUsingCarPanel_UseOfVehicle"));
		List<WebElement> usagesBox = usageBox.findElements(By.tagName("option"));
		
	}
	
	public void getQuote() throws InterruptedException {
		try {
			SignIn();
			TimeUnit.SECONDS.sleep(3);
			SetCarDetails();			
		} catch (InterruptedException ie) {
			driver.quit();
			ie.printStackTrace();
		}
	}
	
}
