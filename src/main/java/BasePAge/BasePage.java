package BasePAge;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


   protected AppiumDriver<MobileElement> driver;
   protected Actions actionsBuilder;
   //protected TouchActions touchActions;
   protected TouchAction touchAction;
   protected WebDriverWait wait;

   protected int timeOut = 15;

   public BasePage(AppiumDriver<MobileElement> Driver) {
      this.driver = Driver;
      actionsBuilder = new Actions(this.driver);
      wait = new WebDriverWait(this.driver, timeOut);
      touchAction = new TouchAction(this.driver);

   }



  /* public WebElement waitUnitil(String elementIdLocator){
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementIdLocator)));
   }*/


   public void scrollDownOneScreenPageByTouchAction(int screensToScroll){

      for (int i = 1; i <= screensToScroll; i++) {
         touchAction
                 .longPress(PointOption.point(505,1790))
                 .moveTo(PointOption.point(505,242))
                 .release()
                 .perform();
      }

   }


   public void scrollRightOneScreenPageByTouchAction(int screensToScroll){

      for (int i = 1; i <= screensToScroll; i++) {
         touchAction
                 .longPress(PointOption.point(950,500))
                 .moveTo(PointOption.point(80,500))
                 .release()
                 .perform();
      }

   }


   public void scrollDownOneScreenPageByActionsBuilder(int screensToScroll, MobileElement element){
      for (int i = 1; i <= screensToScroll; i++) {
         actionsBuilder
                 .clickAndHold(element)
                 .moveByOffset(0, -930)
                 .release()
                 .perform();
      }

   }


   public void scrollToRightDirectionByActionsBuilder(int screensToScroll, MobileElement element){

      for (int i = 1; i <= screensToScroll; i++) {

         actionsBuilder
                 .clickAndHold(element)
                 .moveByOffset(-505,0 )
                 .release()
                 .perform();
      }

   }




}
