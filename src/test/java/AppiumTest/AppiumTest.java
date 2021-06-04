package AppiumTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AppiumTest {


     static AppiumDriver<MobileElement> driver;

    WebDriverWait wait;

    TouchActions touchActions;

    TouchAction touchAction;

    Actions actions;


    @BeforeMethod
    public void beforeMethodSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30 Test");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("skipUnlock", "true");

       // capabilities.setCapability("appPackage", "com.openreply.pam");
       // capabilities.setCapability("appActivity", "com.openreply.pam.ui.launcher.LauncherActivity");
       // capabilities.setCapability(MobileCapabilityType.APP, "com.openreply.pam");

        URL url = new URL("http://0.0.0.0:4723/wd/hub/");

        driver = new AppiumDriver<MobileElement>(url, capabilities);

        wait = new WebDriverWait(driver, 20);

        //touchActions = new TouchActions(driver);

        touchAction = new TouchAction(driver);

        actions = new Actions(driver);

        System.out.println("Pam app is opened");
    }

    @Test
    public void simpleOpenAppTest() throws InterruptedException {

       driver.activateApp("com.openreply.pam");


       //Thread.sleep(3000);
        //WebElement myProfileClick =  driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"My Plan\"]/android.widget.ImageView"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"My Plan\"]/android.widget.ImageView"))).click();



     /*   myProfileClick.click();
        System.out.println("Pam app is opened 2");

        Thread.sleep(5000);
        MobileElement homeButton =  (MobileElement) driver.findElementByAccessibilityId("Home");
        homeButton.click();*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/bottom_nav_action_home"))).click();


        ////android.widget.FrameLayout[@content-desc="Home"]
        //Thread.sleep(3000);
        //MobileElement sweatTitle =  (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[2]\n");
       //sweatTitle.click();


        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/fragment_home_recyclerview")));

      /*  touchAction
                .press(PointOption.point(505, 252))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(500, 2087))
                .release().perform();*/

        for (int i = 0; i < 3; i++) {
         touchAction.longPress(PointOption.point(505,1790)).moveTo(PointOption.point(505,105)).release().perform();
        }

     /*   for (int i = 1; i <= 2; i++) {
            touchAction.longPress(PointOption.point(950,500)).moveTo(PointOption.point(80,500)).release().perform();
        }
*/


   /*     MobileElement wholeHomePage =  (MobileElement) driver.findElementById("com.openreply.pam:id/fragment_home_recyclerview");

        actions
                .clickAndHold(wholeHomePage)
                .moveByOffset(0, -930)
                .release()
                .perform();
*/
    /*    Thread.sleep(5000);
        MobileElement brauniSlider =  (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[1]");

        Thread.sleep(2000);
        actions
                .clickAndHold(brauniSlider)
                .moveByOffset(-1100,0 )
                .release()
                .perform();
*/

        //MobileElement homePageOrganizeYourWeekText =  driver.findElement(By.id("com.openreply.pam:id/item_home_card_body_text"));
        //touchActions.scroll(500, 3000).perform();

        //1781
    }



   // @AfterMethod
    public void teardown() {
        driver.quit();

    }

}
