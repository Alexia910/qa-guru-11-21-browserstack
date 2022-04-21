package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Data;
import config.DataConfig;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Data.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        caps.setCapability("browserstack.user", Data.getUserName());
        caps.setCapability("browserstack.key", Data.getPassword());

        // Set URL of the application under test
        caps.setCapability("app", Data.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), caps);
    }

}