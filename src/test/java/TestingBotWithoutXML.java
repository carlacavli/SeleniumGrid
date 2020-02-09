import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestingBotWithoutXML {
    public static final String KEY = "968e4c07fb278e50883938d14fb859dc";
    public static final String SECRET = "bf450390f6ef0279e5937a39cdf68be9";
    public static final String HUB_URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    private WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setCapability("name", "Android Test 1 - Galaxy S9");
        caps.setCapability("platform", "Android");
        caps.setCapability("version", "9.0");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("deviceName", "Galaxy S9");
        caps.setCapability("platformName", "Android");

        URL url = new URL(HUB_URL);
        driver = new RemoteWebDriver(url, caps);

    }

    @Test
    public void test() {
        driver.get("https://google.com");
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

}
