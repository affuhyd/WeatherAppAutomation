package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLayer.TestBase;

public class ForecastPage extends TestBase {

	@FindBy(xpath = "//*[@class='temp']")
	WebElement temp;

	public ForecastPage() throws FileNotFoundException, IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public double getTempFromUI() {
		String Temp_in_Degrees = temp.getText();
		String[] temparr = Temp_in_Degrees.split("°");
		System.out.println(temparr[0]);
		return Double.parseDouble(temparr[0]);
	}
}
