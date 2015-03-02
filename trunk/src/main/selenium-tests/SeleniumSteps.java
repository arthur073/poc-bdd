import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by averger on 26/02/2015.
 */
public class SeleniumSteps {
    private static SharedDriver sharedDriver;


    @Before
    public void initiateWebBrowser() {
        sharedDriver = new SharedDriver();
    }

    public static boolean ClaimIntake(String claimType) throws InterruptedException {
        String actualTitle = sharedDriver.getTitle();
        System.out.println("We are logged into : " + actualTitle);
        return true;
    }



}
