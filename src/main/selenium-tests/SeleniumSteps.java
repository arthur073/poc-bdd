import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by averger on 26/02/2015.
 */
public class SeleniumSteps {
    private static SharedDriver driver;
    //static WebDriver driver;
    //static String baseURL;
    //String nodeURL;

    @Before
    public void initiateWebBrowser() {
        driver = new SharedDriver();
    }


    public static boolean ClaimIntake(String claimType) throws InterruptedException {
        System.out.println("Test " + claimType + "[start]");
        System.out.println("Test " + claimType + "[end]");
        return true;
    }
}
