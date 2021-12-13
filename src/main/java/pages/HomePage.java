package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//input[@name='query']")
	WebElement inputCity;

	public HomePage() throws FileNotFoundException, IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public ForecastPage enterCityName() throws FileNotFoundException, IOException {
		inputCity.sendKeys(prop.getProperty("city"));
		inputCity.sendKeys(Keys.ENTER);
		return new ForecastPage();

	}
}
