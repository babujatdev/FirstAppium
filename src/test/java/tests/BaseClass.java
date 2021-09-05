package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class BaseClass {
    public AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3A");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); /*use appium chrome driver just in if appium doest work "appium --allow-insecure chromedriver_autodownload"*/
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AppiumDriver<MobileElement>(url, desiredCapabilities);

        } catch (Exception e) {
            System.out.println("Cause is" + e.getCause());
            System.out.println("Message is " + e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
        System.out.println("Close all sessions");
        driver.close();
        driver.quit();
    }
}