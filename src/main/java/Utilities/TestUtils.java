package Utilities;

public class TestUtils {
	public static String ChromeDriverPath = "/src/test/resources/driverExecutables/chromedriver.exe";
	public static int PAGE_LOAD_TIMEOUT = 30;
	public static int IMPLICIT_WAIT_TIMEOUT = 20;
	
	public static double getTempDifference(double temp1, double temp2) {
		if ((temp1 - temp2) < 0.0) {
			return (temp1 - temp2)*(-1);
		}
		else 
			return (temp1 - temp2);
	}
}
