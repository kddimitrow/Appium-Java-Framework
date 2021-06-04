package HomePageTests;

import BaseTest.BaseTest;
import Pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class HomePageTestOne extends BaseTest {

    HomePage homePage;


    @Test(enabled = true)
    public void scrollToHomepageWorkoutPlansAndGetText(){
       getDriver().activateApp("com.openreply.pam");

       homePage = new HomePage(getDriver());
       homePage.scrollToWorkoutPlansAndGetText();

        System.out.println("competed");

    }

}
