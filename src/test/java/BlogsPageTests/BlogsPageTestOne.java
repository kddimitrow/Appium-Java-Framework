package BlogsPageTests;

import BaseTest.BaseTest;
import Pages.BlogPage;
import org.testng.annotations.Test;

public class BlogsPageTestOne extends BaseTest {

    BlogPage blogPage;

    @Test
    public void searchForProteinInBlogPageThenCheckIsThirdPostDisplayedAndOpenIt(){
        getDriver().activateApp("com.openreply.pam");

        blogPage = new BlogPage(getDriver());
        blogPage.searchForProteinInBlogPageThenCheckIsThirdPostDisplayedAndOpenIt();

    }


}
