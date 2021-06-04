package RecipesPageTests;

import BaseTest.BaseTest;
import Pages.RecipesPage;
import org.testng.annotations.Test;

public class RecipesPageTestOne extends BaseTest {

    RecipesPage recipesPage;

    @Test
    public void sortRecipesByQuickestAndCheckIsDisplayedCarrotCakeTest(){
        getDriver().activateApp("com.openreply.pam");

        recipesPage = new RecipesPage(getDriver());
        recipesPage.sortRecipesByQuickestAndCheckIsDisplayedCarrotCake();
    }


}
