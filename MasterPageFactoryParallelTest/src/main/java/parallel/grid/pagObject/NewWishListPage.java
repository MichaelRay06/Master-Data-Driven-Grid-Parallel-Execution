package parallel.grid.pagObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class NewWishListPage {
	
WebDriver driver;

@FindBy(how=How.ID, using="name") private WebElement SEND_WISHLIST_NAME;
@FindBy(how=How.ID, using="submitWishlist") private WebElement CLICK_SAVE_BUTTON;
@FindBy(how=How.CSS, using="i.icon-remove") private WebElement CLICK_DELETE_WISHLIST;
	
	public NewWishListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	




public NewWishListPage typeWishListName(String Saveitems) {
	SEND_WISHLIST_NAME.sendKeys(Saveitems);
	return new NewWishListPage(driver);
}
	
	public NewWishListPage clickToSaveWhichList() {
		CLICK_SAVE_BUTTON.click();
		return new NewWishListPage(driver);

		
	}
	public NewWishListPage clickToDeleteWhishListItem() {
		CLICK_DELETE_WISHLIST.click();
		return new NewWishListPage(driver);

		
	}
	public NewWishListPage acceptAlert() {
		
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return new NewWishListPage(driver);

	}
}

