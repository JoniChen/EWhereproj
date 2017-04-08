
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

        File app = new File ("/Users/aliaksandr/IdeaProjects/bytestnovik/src/main/resources/e-Where.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformName", "iOS");
        //  capabilities.setCapability("bundleId", "SMWarren.e-Where");
//	capabilities.setCapability("fullReset", true);
        capabilities.setCapability("deviceName", "iPhone SE");
//	capabilities.setCapability("realDeviceLogger", "idevicesyslog");
        capabilities.setCapability("platformVersion", "10.3");
        //capabilities.setCapability("UDID", "72857EAF-0734-482C-B593-C2197368411D");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver = new IOSDriver(new URL(("http://0.0.0.0:4723/wd/hub")),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01() throws InterruptedException {

        //Home viewd
        //String textObjects = driver.findElement(By.className("Text")).getText();
        //assertTrue(textObjects.contains("eWhere"));
//		driver.findElement(MobileBy.AccessibilityId("Events")).click();
//		driver.findElement(MobileBy.AccessibilityId("Home")).click();
//		WebElement button1 = driver.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]"));

        WebElement eventElement =driver.findElementsByName("Events").get(0);
        eventElement.click();

        Assert.assertEquals(eventElement.getText(),"Events");

        WebElement button1 = driver.findElement(By.name("Events"));

        TouchAction newTouch = new TouchAction(driver);
        newTouch.press(button1);

        scroll(driver, "up");

//		driver.findElement(By.id("Discover")).click();
//		driver.findElement(By.id("Inbox")).click();
//		driver.findElement(By.id("Settings")).click();



    }

    //"up" & "down" gestured worked the "left" & "right"

    public void scroll(IOSDriver driver , String direction){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        HashMap scrollObject = new HashMap();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: scroll", scrollObject);
    }

    private long for_text(String string) {
        // TODO Auto-generated method stub
        return 0;
    }

    @AfterClass
    public static void closeSim() {
        driver.quit();
    }
}