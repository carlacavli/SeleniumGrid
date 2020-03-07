import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class MondayProject {
    public static final String KEY = "72253b95c246c727c12ebf47bf3f21d3";
    public static final String SECRET = "0f71c4c1d9515225bcaa360c54afd674";
    public static final String HUB_URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities caps;

    @BeforeClass
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("name", "monday project");
        url = new URL(HUB_URL);

    }
}