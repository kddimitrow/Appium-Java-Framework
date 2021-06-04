package Pages;

import BasePAge.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RecipesPage extends BasePage {


    public RecipesPage(AppiumDriver<MobileElement> Driver) {
        super(Driver);
    }


    public void sortRecipesByQuickestAndCheckIsDisplayedCarrotCake(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/bottom_nav_action_recipes")));
        MobileElement recipesNavButton = driver.findElement(By.id("com.openreply.pam:id/bottom_nav_action_recipes"));
        recipesNavButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/sort_button")));
        MobileElement sortButton = driver.findElement(By.id("com.openreply.pam:id/sort_button"));
        sortButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RadioGroup/android.widget.RadioButton[3]")));
        MobileElement quickestButton = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RadioGroup/android.widget.RadioButton[3]"));
        quickestButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]")));
        MobileElement carrotSmoothieDisplayedItem = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[2]"));
        System.out.println( carrotSmoothieDisplayedItem.getText() );

        String expectedSmoothieTitle = "Carrot Cake Smoothie - thick & clean";
        Assert.assertEquals(carrotSmoothieDisplayedItem.getText().trim(),expectedSmoothieTitle);

        carrotSmoothieDisplayedItem.isDisplayed();

    }
}
