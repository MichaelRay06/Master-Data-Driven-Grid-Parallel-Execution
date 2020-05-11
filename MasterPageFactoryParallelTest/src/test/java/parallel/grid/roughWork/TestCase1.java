package parallel.grid.roughWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import parallel.grid.pagObject.HomePage;
import parallel.grid.pagObject.LandingPage;
import parallel.grid.pagObject.LoginPage;
import parallel.grid.pagObject.NewWishListPage;
import parallel.grid.utilities.DriverManager;

public class TestCase1 extends BaseTest {

	HomePage homePage = new HomePage(DriverManager.getDriver());
	LoginPage loginPage = new LoginPage(DriverManager.getDriver());

	LandingPage landingPage = new LandingPage(DriverManager.getDriver());
	NewWishListPage newWishListPage = new NewWishListPage(DriverManager.getDriver());

	
	
	
	
	
	@Test(dataProvider = "getData")
	public void logIn2(String email, String password, String browserName, String wishListItem) {

		openBrowser(browserName, "http://carguruji.com/shop/");
		
		homePage = new HomePage(DriverManager.getDriver());
		loginPage = homePage.clickToSingIn();
		landingPage = loginPage.logIn(email, password).clickLogInButton();
		newWishListPage = landingPage.myWishListLink();
		newWishListPage.typeWishListName(wishListItem).clickToSaveWhichList().clickToDeleteWhishListItem()
				.acceptAlert();

		quitBrowser();

	}

	@DataProvider(parallel = true)
	public Object[][] getData() {
		Object[][] data = new Object[1][4];
		data[0][0] = "bfatogun@yahoo.com";
		data[0][1] = "sonsofgod";
		data[0][2] = "chrome";
		data[0][3] = "Tommy";

	
		
		

		return data;

	}

}
