package parallel.grid.pagObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
WebDriver driver;

@FindBy(how=How.CSS, using="i.icon-heart") private WebElement CLICK_WISHLIST_LINK;

	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	



     public NewWishListPage myWishListLink() {
    	 CLICK_WISHLIST_LINK.click();
    	 return new NewWishListPage(driver);
	
	
}
}
