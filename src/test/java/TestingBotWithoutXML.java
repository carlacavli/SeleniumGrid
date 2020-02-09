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
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setCapability("name", "Selenium Testing Bot Test 1");

        URL url = new URL(HUB_URL);
        driver = new RemoteWebDriver(url, cap);

    }

    @Test
    public void test() {
        driver.get("https://google.com");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

}
