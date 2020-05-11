/*
 * package parallel.grid.roughWork;
 * 
 * import org.openqa.selenium.By; import org.testng.annotations.DataProvider;
 * import org.testng.annotations.Test;
 * 
 * public class TestCase4 extends BaseTest {
 * 
 * 
 * 
 * 
 * 
 * @Test(dataProvider = "getData") 
 * public void logIn(String email, String
 * password, String browserName) {
 * 
 * 
 * 
 * openBrowser(browserName);
 * 
 * getDriver().findElement(By.cssSelector("a.login")).click();
 * getDriver().findElement(By.id("email")).sendKeys(email);
 * getDriver().findElement(By.id("passwd")).sendKeys(password);
 * getDriver().findElement(By.id("SubmitLogin")).click();
 * 
 * quitBrowser();
 * 
 * }
 * 
 * @DataProvider(parallel = true) public Object[][] getData() { Object[][] data
 * = new Object[2][3]; data[0][0] = "bfatogun@yahoo.com"; data[0][1] =
 * "sonsofgod"; data[0][2] = "chrome";
 * 
 * data[1][0] = "bfatogun@yahoo.com"; data[1][1] = "sonsofgod"; data[1][2] =
 * "chrome";
 * 
 * return data;
 * 
 * }
 * 
 * }
 */