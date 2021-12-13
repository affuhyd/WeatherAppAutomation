package TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.TestUtils;
import baseLayer.TestBase;
import pages.ForecastPage;
import pages.HomePage;
import pages.getRequest_API;

public class ComparatorTest extends TestBase {
	HomePage homePage;
	ForecastPage forecastPage;
	getRequest_API requestAPI;

	public ComparatorTest() throws FileNotFoundException, IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException, IOException {
		initialization();
		homePage = new HomePage();
		forecastPage = homePage.enterCityName();		
		requestAPI = new getRequest_API();
	}

	@Test
	public void Compare_temp_are_equal() {
		Assert.assertEquals(forecastPage.getTempFromUI(), requestAPI.getTempFromAPI());
	}
	
	@Test
	public void Compare_temp_are_in_range() {
		Assert.assertTrue(TestUtils.getTempDifference(forecastPage.getTempFromUI(), requestAPI.getTempFromAPI())>
		Double.parseDouble(prop.getProperty("range")));
	}
}
