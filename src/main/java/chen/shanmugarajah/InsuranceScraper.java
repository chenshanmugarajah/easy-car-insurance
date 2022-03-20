package chen.shanmugarajah;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class InsuranceScraper {

	public InsuranceScraper () {	
	}
	
	public void keepGoing (WebDriver driver) {
		driver.findElement(By.id("continue-button")).click();
	}
	
	public void getData (String numberPlate, Boolean modified, Boolean owner, Boolean keeper) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chen\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mygocompare.gocompare.com/login/");
		
		// clearing cookie modal
		final WebElement cookiesBox = driver.findElement(By.className("qc-cmp2-summary-buttons"));
		final WebElement cookiesFinal = cookiesBox.findElements(By.tagName("button")).get(1);
		cookiesFinal.click();		
		
		// logging into the website
		driver.findElement(By.id("emailAddress")).sendKeys("chenunprofessional@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Danish24");
		driver.findElement(By.id("dobDD")).sendKeys("24");
		driver.findElement(By.id("dobMM")).sendKeys("01");
		driver.findElement(By.id("dobYYYY")).sendKeys("1999");
//		WebElement surnameBox = driver.findElement(By.id("surname"));
		driver.findElement(By.id("signInButton")).click();

		
		TimeUnit.SECONDS.sleep(3);
		
		driver.findElement(By.className("edit-quote-button")).click();
		
		TimeUnit.SECONDS.sleep(3);
		
		driver.findElement(By.className("card-secondary")).findElement(By.tagName("a")).click();
		
		// Find car and confirm
		driver.findElement(By.id("AboutCarPanel_RegNumber")).sendKeys(numberPlate);
		driver.findElement(By.id("reg-lookup-button")).click();
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.id("AboutCarPanel_DetailsCorrect_true")).click();
		
		// Declare modifications
		TimeUnit.SECONDS.sleep(3);
		String modifiedField;
		modifiedField = modified ? "AboutCarPanel_AnyModifications_true" : "AboutCarPanel_AnyModifications_false"; 
		driver.findElement(By.id(modifiedField)).click();
		
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.id("AboutCarPanel_EstimatedMarketValue")).click();
		driver.findElement(By.id("AboutCarPanel_EstimatedMarketValue")).sendKeys("3000");
		
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.id("OwningAndUsingCarPanel_DateOfPurchase_Month")).click();
		driver.findElement(By.id("OwningAndUsingCarPanel_DateOfPurchase_Month")).clear();
		TimeUnit.SECONDS.sleep(3);
		driver.findElement(By.id("OwningAndUsingCarPanel_DateOfPurchase_Month")).sendKeys("01");
		driver.findElement(By.id("OwningAndUsingCarPanel_DateOfPurchase_Year")).sendKeys("2022");
	
		TimeUnit.SECONDS.sleep(3);
		String legalOwner;
		legalOwner = owner ? "OwningAndUsingCarPanel_LegalOwner_true" : "OwningAndUsingCarPanel_LegalOwner_false"; 
		driver.findElement(By.id(legalOwner)).click();
		
		TimeUnit.SECONDS.sleep(3);
		String registeredKeeper;
		registeredKeeper = keeper ? "OwningAndUsingCarPanel_RegisteredKeeper_true" : "OwningAndUsingCarPanel_RegisteredKeeper_false"; 
		driver.findElement(By.id(registeredKeeper)).click();
		
//		TimeUnit.SECONDS.sleep(3);
//		driver.findElement(By.id("OwningAndUsingCarPanel_UseOfVehicle")).click();
//		
	
		
		keepGoing(driver);
		driver.findElement(By.id("CustomerPreferences_SelectedPreferences[0]_GrantedState_False")).click();
		keepGoing(driver);
		
		System.out.println("Moment of truth");
		TimeUnit.SECONDS.sleep(3);
		keepGoing(driver);
		
		keepGoing(driver);
		
		driver.findElement(By.className("continue-button")).click();
		
		TimeUnit.SECONDS.sleep(10);
		
		List<WebElement> results = driver.findElements(By.className("result-card"));
		
		for (WebElement result : results) {
			System.out.println(result.findElement(By.className("annually-text")).getText());
		}
		
	}
}
