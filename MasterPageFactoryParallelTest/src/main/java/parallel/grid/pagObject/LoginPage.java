package parallel.grid.pagObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;




public class LoginPage {

	WebDriver driver;
	
	   @FindBy(how=How.CSS, using="a.login") private WebElement CLICK_SIGNIN_BUTTON;
		@FindBy(how=How.ID, using="email") private WebElement SEND_EMAIL_BOX;
		@FindBy(how=How.ID, using="passwd") private WebElement SEND_PASSWRD_BOX;
		@FindBy(how=How.ID, using="SubmitLogin") private WebElement CLICK_LOGIN_BUTTON;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
 
	

	public LoginPage logIn(String userName, String password) {
		try {
			SEND_EMAIL_BOX.sendKeys(userName);
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			SEND_EMAIL_BOX.sendKeys(userName);
		}
		SEND_PASSWRD_BOX.sendKeys(password);
		return new LoginPage(driver);
	}
		
		public LandingPage clickLogInButton() {
			CLICK_LOGIN_BUTTON.click();
			return new LandingPage(driver);

			
		}
	
}
