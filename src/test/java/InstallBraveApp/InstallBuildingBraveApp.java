package InstallBraveApp;

import BaseTest.BaseTest;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class InstallBuildingBraveApp extends BaseTest {


    @Test
    public void installAndStartBraveApp(){
        getDriver().installApp("C:\\\\BuildingBraveApp\\\\app-training-v63-03.01.2019-v2Academy.apk");
        getDriver().isAppInstalled("org.buildingbrave.buildingbrave");
        //getDriver().isAppInstalled("app-training-v63-03.01.2019-v2Academy.apk");
        getDriver().activateApp("org.buildingbrave.buildingbrave");
    }

    @Test
    public void uninstallBraveApp(){
        getDriver().removeApp("org.buildingbrave.buildingbrave");
    }

    @AfterMethod
    @Override
    public void teardown(ITestResult result) {
        getDriver().terminateApp("org.buildingbrave.buildingbrave");
        super.teardown(result);

    }
}
