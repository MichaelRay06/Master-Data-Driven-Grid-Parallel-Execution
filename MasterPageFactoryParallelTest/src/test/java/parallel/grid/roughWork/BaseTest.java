package parallel.grid.roughWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import parallel.grid.utilities.DriverFactory;
import parallel.grid.utilities.DriverManager;

public class BaseTest {

	private WebDriver driver;
	FileInputStream fs = null;
	Properties CONFS;

	public void setUp() {
		logFile();

		DriverFactory.setPROPERTY_FILE_PATH(System.getProperty("user.dir") + "src//test//resources//properties//log4j.properties");
		DriverFactory.setGRIDE_PATH("http://localhost:4444");

		if (System.getProperty("os.name").contains("mac")) {

			DriverFactory.setGECKO_DRIVER_PATH(
					System.getProperty("user.dir") + "src//test//resources//macOS_Drivers//chromedriver");
			DriverFactory.setGECKO_DRIVER_PATH(
					System.getProperty("user.dir") + "src//test//resources//macOS_Drivers//geckodriver");

		} else {
			DriverFactory.setGECKO_DRIVER_PATH(
					System.getProperty("user.dir") + "//src//test//resources//windowsDrivers//chromedriver.exe");
			DriverFactory.setGECKO_DRIVER_PATH(
					System.getProperty("user.dir") + "//src//test//resources//windowsDrivers//geckodriver.exe");
			DriverFactory.setIE_DRIVER_PATH(
					System.getProperty("user.dir") + "//src//test//resources//windowsDrivers//IEDriverServer.exe");

		}

		try {
			if (fs == null)
				fs = new FileInputStream(DriverFactory.getPROPERTY_FILE_PATH());
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			CONFS = new Properties();
			CONFS.load(fs);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void logFile() {
		String log4jFile = (System.getProperty("user.dir") + "//src//test//resources//properties//log4j.properties");
		PropertyConfigurator.configure(log4jFile);
	}

	public void openBrowser(String browserName, String url) {
		DriverFactory.set_isREMOTE(false);
		if (DriverFactory.is_isREMOTE()) {

			DesiredCapabilities capabilities = null;

			if (browserName.equalsIgnoreCase("firefox")) {
				capabilities = DesiredCapabilities.firefox();
				capabilities.setBrowserName("firefox");
				capabilities.setPlatform(Platform.ANY);

			} else if (browserName.equalsIgnoreCase("chrome")) {
				capabilities = DesiredCapabilities.chrome();
				capabilities.setBrowserName("chrome");
				capabilities.setPlatform(Platform.ANY);

			} else if (browserName.equalsIgnoreCase("IE")) {
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setBrowserName("IE");
				capabilities.setPlatform(Platform.WIN10);

			}

			try {
				driver = new RemoteWebDriver(new URL("http://192.168.1.100:4444/wd/hub"), capabilities);
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}

		} else {

			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			}

			else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			DriverManager.setWebDriver(driver);
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			DriverManager.getDriver().get(url);

		}

	}

	public void quitBrowser() {
		DriverManager.getDriver().close();

	}

}
