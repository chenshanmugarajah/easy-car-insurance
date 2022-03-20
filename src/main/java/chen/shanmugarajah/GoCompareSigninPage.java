package chen.shanmugarajah;

import org.openqa.selenium.WebDriver;

public class GoCompareSigninPage {

	private String email;
	private String password;
	private String dobDate;
	private String dobMonth;
	private String dobYear;
	private String surname;
	private WebDriver driver;
	
	public GoCompareSigninPage(String email, String password, String dobDate, String dobMonth, String dobYear,
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
	

}
