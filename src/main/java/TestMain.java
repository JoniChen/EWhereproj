
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by joninow on 08/04/2017.
 */
public class TestMain {






    static IOSDriver<WebElement> driver ;
    // static TouchAction action = new TouchAction(driver);

    @BeforeClass(alwaysRun = true)
    public static void startSim() throws MalformedURLException {

        File app = new File ("/Users/joninow/Desktop/e-Where.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "10.3");
        //capabilities.setCapability("UDID", "72857EAF-0734-482C-B593-C2197368411D");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new IOSDriver(new URL(("http://0.0.0.0:4723/wd/hub")),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() throws InterruptedException {

        //Home view

        //Check click
        WebElement homeElement = driver.findElementsByName("Home").get(0);

        // Check scroll
        scroll(driver , "down");
        scroll(driver , "down");
        scroll(driver , "down");
        scroll(driver, "up");
        scroll(driver, "up");

        //Check button label
        Assert.assertEquals(homeElement.getText(), "Home");

        //Events
        WebElement eventElement =driver.findElementsByName("Events").get(0);
        eventElement.click();
        //Check page scroll
        scroll(driver , "down");
        scroll(driver , "down");
        scroll(driver , "down");
        scroll(driver, "up");
        scroll(driver, "up");
        //check button label
        Assert.assertEquals(eventElement.getText(), "Events");
        //Check press on music event
        TouchAction tap = new TouchAction(driver);
        tap.press(360 , 246);
        wait(100);
        driver.findElementsByName("Events").get(0).click();
        //check press on video event
        tap.press(360, 566);
        wait(100);
        driver.findElementsByName("Events").get(0).click();

        //Discover
        WebElement discoverElement = driver.findElementsByName("Discover").get(0);
        discoverElement.click();
        //Check page scroll
        scroll(driver, "down");
        scroll(driver , "up");
        //check button label
        Assert.assertEquals(discoverElement.getText() , "Discover");

        //Inbox
        driver.findElementsByName("Inbox").get(0).click();

        //Settings
        driver.findElementsByName("Settings").get(0).click();
        scroll(driver, "down");








    }

    public void scroll(IOSDriver driver , String direction){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: swipe", scrollObject);
    }

    @AfterClass
    public static void closeSim() {
        driver.quit();
    }
}