import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        Main m = new Main();
        m.setup();
    }

    public void setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3A");
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
            //desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            desiredCapabilities.setCapability("appActivity", ".Calculator");
            desiredCapabilities.setCapability("avd", "Pixel3A");
            //desiredCapabilities.setCapability("app", "/system/app/ExactCalculator/ExactCalculator.apk");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            AppiumDriver driver = new AndroidDriver(url, desiredCapabilities);
            String sessionId = driver.getSessionId().toString();

            MobileElement seven = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_7"));
            seven.click();
            MobileElement plus = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/op_add"));
            plus.click();
            MobileElement nine = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/digit_9"));
            nine.click();
            MobileElement formula = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/formula"));
            formula.getText();
            System.out.println("Formula = " + formula.getText());
            MobileElement result = (MobileElement) driver.findElement(By.id("com.android.calculator2:id/result"));
            result.getText();
            System.out.println("Result = " + result.getText());

        } catch (Exception e) {
            System.out.println("Cause is" + e.getCause());
            System.out.println("Message is " + e.getMessage());
            e.printStackTrace();
        }


    }
}
