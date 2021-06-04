package Pages;

import BasePAge.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(AppiumDriver<MobileElement> Driver) {
        super(Driver);
    }




    public void scrollToWorkoutPlansAndGetText(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/fragment_home_recyclervieww")));

        scrollDownOneScreenPageByTouchAction(8);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/item_home_card_body_text")));

        MobileElement workoutPlanText = driver.findElementById("com.openreply.pam:id/item_home_card_body_text");

        String textWorkoutPlan = workoutPlanText.getText();

        System.out.println(textWorkoutPlan);

        String actualWorkoutPlanText ="Find all our workout plans of Week 20 in the \"my plan\" section! \n" +
                "\n" +
                "What else is new? \n" +
                "- The \"Busy Plan\" for busy people with 3 sessions, 45 minutes each. Focussed on the most important videos, so you can also achieve great results with less time! \n" +
                "- In addition to the 5 regular Instagram Plans, you can now also train with the \"45min Weights\" and \"60min Hardcore\" schedules. \n" +
                "- A detailed description for each plan. Which one fits your goals best? \n" +
                "- Need a break? You can now add rest days to your workout plan.";


        Assert.assertEquals(textWorkoutPlan.trim(),actualWorkoutPlanText);

    }

}
