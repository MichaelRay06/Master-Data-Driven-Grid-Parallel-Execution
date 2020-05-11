package parallel.grid.pagObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(how=How.CSS, using="div.header_user_info") public WebElement CLICK_SIGNIN_BUTTON;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
		
	}

	public LoginPage clickToSingIn()  {
		try {
		
			Actions act= new Actions(driver);
			Thread.sleep(5000);
			act.moveToElement(CLICK_SIGNIN_BUTTON).click().perform();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new LoginPage(driver);
	}
	
}
