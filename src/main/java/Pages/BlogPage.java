package Pages;

import BasePAge.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BlogPage extends BasePage {


    public BlogPage(AppiumDriver<MobileElement> Driver) {
        super(Driver);
    }


    public void searchForProteinInBlogPageThenCheckIsThirdPostDisplayedAndOpenIt(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/bottom_nav_action_blogs")));
        MobileElement blogsNavButton = driver.findElement(By.id("com.openreply.pam:id/bottom_nav_action_blogs"));
        blogsNavButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/search_view")));
        MobileElement blogsSearch = driver.findElement(By.id("com.openreply.pam:id/search_view"));

        blogsSearch.click();
        blogsSearch.sendKeys("protein");

        driver.hideKeyboard();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.openreply.pam:id/items_recycler_view")));
       // MobileElement blogsSearchResults = driver.findElement(By.id("com.openreply.pam:id/items_recycler_view"));

        scrollDownOneScreenPageByTouchAction(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]")));
        MobileElement blogsSearchMeatResultText = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]"));

        blogsSearchMeatResultText.isDisplayed();

        blogsSearchMeatResultText.click();

        driver.navigate().back();



    }

}
