package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceHost;
import config.ProjectData;
import helpers.AppiumHelper;
import helpers.BrowserStackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static config.ProjectData.*;

public class AndroidMobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        if (ProjectData.deviceHost().equals(DeviceHost.BROWSER_STACK))
            return getBrowserStackMobileDriver(desiredCapabilities);
        else
            return getAppiumMobileDriver(desiredCapabilities);
    }

    public AndroidDriver<WebElement> getAppiumMobileDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", appiumConfig.platformName());
        desiredCapabilities.setCapability("deviceName", appiumConfig.deviceName());
        desiredCapabilities.setCapability("version", appiumConfig.version());
        desiredCapabilities.setCapability("locale", appiumConfig.locale());
        desiredCapabilities.setCapability("language", appiumConfig.language());
        desiredCapabilities.setCapability("appPackage", appiumConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", appiumConfig.appActivity());
        desiredCapabilities.setCapability("app", appiumConfig.appUrl());

        if (deviceHost().equals(DeviceHost.SELENOID)) {
            desiredCapabilities.setCapability("enableVNC", true);
            desiredCapabilities.setCapability("enableVideo", true);
        }

        return new AndroidDriver<>(AppiumHelper.getAppiumServerUrl(), desiredCapabilities);
    }

    public AndroidDriver<WebElement> getBrowserStackMobileDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", "marinagilimovich_9pzhed");
        desiredCapabilities.setCapability("browserstack.key", "XAWMeainDypUDFT3D3Xt");

        desiredCapabilities.setCapability("project", "qa_guru_21");
        desiredCapabilities.setCapability("build", "Android");
        desiredCapabilities.setCapability("name", "Wiki tests");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");

        desiredCapabilities.setCapability("device", browserStackConfig.device());
        desiredCapabilities.setCapability("os_version", browserStackConfig.osVersion());
        desiredCapabilities.setCapability("app", browserStackConfig.app());

        return new AndroidDriver<>(BrowserStackHelper.getBrowserstackUrl(), desiredCapabilities);
    }
}
