package baseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.TestUtils;

import static io.restassured.RestAssured.*;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;

	public TestBase() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/Config.properties"));
	}

	public static void initialization() {
		baseURI = prop.getProperty("base_url");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + TestUtils.ChromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("Application_URL"));
	}
	
	
}
