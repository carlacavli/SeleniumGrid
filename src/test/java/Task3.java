import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

//Create a test that will run in Chrome 80, Firefox 72, on Linux

public class Task3 {
    public static final String KEY = "72253b95c246c727c12ebf47bf3f21d3";
    public static final String SECRET = "0f71c4c1d9515225bcaa360c54afd674";
    public static final String HUB_URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities caps;

    @BeforeClass
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("name", "Task 3 test");
        url = new URL(HUB_URL);
    }

    @Test(dataProvider = "capabilitiesProvider")
    public void test(String platform, String browserName, String browserVersion) {
        caps.setCapability("platform", platform);
        caps.setCapability("version", browserVersion);
        caps.setCapability("browserName", browserName);
        driver = new RemoteWebDriver(url, caps);
        driver.get("https://google.com");
        driver.quit();

    }


    @DataProvider
    public Object[][] capabilitiesProvider() {
        return new Object[][]{
                {"linux", "chrome", "80"},
                {"linux", "firefox", "72"},
        };
    }
}