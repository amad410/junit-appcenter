package com.agilethought.Android;

import com.agilethought.BaseTest;
import com.agilethought.Pages.MainPage;
import org.junit.Test;

import java.net.MalformedURLException;
import com.microsoft.appcenter.appium.Factory;
import org.junit.rules.TestWatcher;
import org.junit.Rule;
import org.springframework.util.Assert;


public class AndroidTest extends BaseTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();
    MainPage mainPage;
    public AndroidTest(){
        System.setProperty("platformName","Android");
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

    @Test
    public void Verify_Riyadh_Weather() throws MalformedURLException, InterruptedException {

        mainPage = new MainPage();
        mainPage.selectRiyadh();
        takeScreenshot("selecting Riyadh");
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

    @Test
    public void Verify_AbuDhabi_Weather() throws MalformedURLException, InterruptedException {

        mainPage = new MainPage();
        mainPage.selectAbuDhabi();
        takeScreenshot("selecting Abu Dhabi");
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
