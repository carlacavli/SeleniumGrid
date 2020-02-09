import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task2Test {
    public static final String KEY = "968e4c07fb278e50883938d14fb859dc";
    public static final String SECRET = "bf450390f6ef0279e5937a39cdf68be9";
    public static final String HUB_URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities caps;

    @BeforeClass
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("name", "Task 2 test");
        url = new URL(HUB_URL);
    }

    @Test(dataProvider = "capabilitiesProvider")
    public void test(String platform, String browserName, String browserVersion){
        caps.setCapability("platform", platform);
        caps.setCapability("version", browserVersion);
        caps.setCapability("browserName", browserName);
        driver = new RemoteWebDriver(url, caps);
        driver.get("https://google.com");
    }

    @DataProvider
    public Object[][] capabilitiesProvider(){
        return new Object[][]{
                {"WIN8", "chrome", "79"},
                {"WIN8", "firefox", "60"},
        };
    }
}
