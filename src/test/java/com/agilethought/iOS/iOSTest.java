package com.agilethought.iOS;

import com.agilethought.BaseTest;
import com.agilethought.Pages.MainPage;
import com.microsoft.appcenter.appium.Factory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.springframework.util.Assert;

import java.net.MalformedURLException;

public class iOSTest extends BaseTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    MainPage mainPage;
    public iOSTest(){
        System.setProperty("platformName","iOS");
    }

    @Test
    public void Verify_London_Weather() throws MalformedURLException, InterruptedException {

        mainPage = new MainPage();
        mainPage.selectLondon();
        takeScreenshot("selecting london");
        mainPage.selectWeatherBtn();
        Thread.sleep(5000);
        takeScreenshot("viewing weather");

        Assert.isTrue(mainPage.isTempDisplayed(),"Temperature not displayed");
        Assert.isTrue(mainPage.isWeatherConditionDisplayed(), "Weather condition not displayed");
        Assert.isTrue(mainPage.isHumidityDisplayed(), "Humidity condition not displayed");
        Assert.isTrue(mainPage.isPressureDisplayed(),"Pressure not displayed");
        Assert.isTrue(mainPage.isVisibilityDisplayed(),"Visibility not displayed");
        Assert.isTrue(mainPage.istimeToSunriseDisplayed(),"Time to sunrise not displayed");
        Assert.isTrue(mainPage.istimeToSunsetDisplayed(),"Time to sunset not displayed");
    }
}
