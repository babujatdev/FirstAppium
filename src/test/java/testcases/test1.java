package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.BaseClass;

public class test1 extends BaseClass {
    @Test
    public void test() {
       driver.get("http://google.com");
       driver.findElement(By.name("q")).sendKeys("Automation");
    }
}