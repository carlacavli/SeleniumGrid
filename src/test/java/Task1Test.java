import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Task1Test {
    public static final String KEY = "72253b95c246c727c12ebf47bf3f21d3";
    public static final String SECRET = "0f71c4c1d9515225bcaa360c54afd674";
    public static final String HUB_URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities caps;

    @BeforeClass
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("name", "Task 1 test");
        url = new URL(HUB_URL);
    }

    @Test
    public void testFirefox(){
        caps.setCapability("platform", "WIN8");
        caps.setCapability("version", "60");
        caps.setCapability("browserName", "firefox");
        driver = new RemoteWebDriver(url, caps);

        driver.get("https://google.com");
    }

    @Test
    public void testChrome(){
        caps.setCapability("platform", "WIN8");
        caps.setCapability("version", "79");
        caps.setCapability("browserName", "chrome");
        driver = new RemoteWebDriver(url, caps);

        driver.get("https://google.com");
    }
}
