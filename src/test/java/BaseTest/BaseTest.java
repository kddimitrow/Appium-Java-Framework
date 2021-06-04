package BaseTest;

import Listener.TestListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BaseTest   {



    static AppiumDriver<MobileElement> driver;


    static String serverUrl = "http://0.0.0.0:4723/wd/hub/";


    DesiredCapabilities capabilities = new DesiredCapabilities();


    @BeforeMethod
    public  void beforeMethodSetup() throws MalformedURLException {


        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30 Test");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("skipUnlock", "true");

        //capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT);

        // capabilities.setCapability("appPackage", "com.openreply.pam");
        // capabilities.setCapability("appActivity", "com.openreply.pam.ui.launcher.LauncherActivity");
        // capabilities.setCapability(MobileCapabilityType.APP, "com.openreply.pam");

        URL url = new URL(serverUrl);

        driver = new AppiumDriver<MobileElement>(url, capabilities);


        System.out.println("Pam app is opened");
    }


    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    //@AfterTest
    public  static void takeScreenShotWhenTestFail(ITestResult result){

      //  TestListener testListener = new TestListener();

        if (ITestResult.FAILURE == result.getStatus() ) {

        /*  File srcFile = driver.getScreenshotAs(OutputType.FILE);
            String filename = UUID.randomUUID().toString();
            // File targetFile = new File(System.getProperty("user.dir") + "/screenshots/" + filename + ".jpg");
            File targetFile = new File("C:/Java_Appium_From_Example/ScreenshotsOfFailedTest/" + filename + ".jpg");
            */


            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd--hh.mm.ss");
            String formatDate = dateFormat.format(date);
            //String dateForFileName = formatDate.trim() ;
             File srcFile = driver.getScreenshotAs(OutputType.FILE);
            File targetFile = new File("C:/Java_Appium_From_Example/ScreenshotsOfFailedTest/" +  formatDate + ".jpg");


            try {
                FileUtils.copyFile(srcFile, targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @AfterMethod
    public  void teardown(ITestResult result) {

        takeScreenShotWhenTestFail(result);

        driver.terminateApp("com.openreply.pam");
        driver.closeApp();
        driver.quit();


    }



}
