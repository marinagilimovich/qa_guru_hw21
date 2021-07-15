package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileDeviceHost;
import config.MobileProjectData;
import helpers.MobileAppiumHelper;
import helpers.MobileBrowserStackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static config.MobileProjectData.*;

public class MobileAndroidMobileDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        if (MobileProjectData.deviceHost().equals(MobileDeviceHost.BROWSER_STACK))
            return getBrowserStackMobileDriver(desiredCapabilities);
        else
            return getAppiumMobileDriver(desiredCapabilities);
    }

    public AndroidDriver<WebElement> getAppiumMobileDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", MOBILE_APPIUM_CONFIG.platformName());
        desiredCapabilities.setCapability("deviceName", MOBILE_APPIUM_CONFIG.deviceName());
        desiredCapabilities.setCapability("version", MOBILE_APPIUM_CONFIG.version());
        desiredCapabilities.setCapability("locale", MOBILE_APPIUM_CONFIG.locale());
        desiredCapabilities.setCapability("language", MOBILE_APPIUM_CONFIG.language());
        desiredCapabilities.setCapability("appPackage", MOBILE_APPIUM_CONFIG.appPackage());
        desiredCapabilities.setCapability("appActivity", MOBILE_APPIUM_CONFIG.appActivity());
        desiredCapabilities.setCapability("app", MOBILE_APPIUM_CONFIG.appUrl());

        if (deviceHost().equals(MobileDeviceHost.SELENOID)) {
            desiredCapabilities.setCapability("enableVNC", true);
            desiredCapabilities.setCapability("enableVideo", true);
        }

        return new AndroidDriver<>(MobileAppiumHelper.getAppiumServerUrl(), desiredCapabilities);
    }

    public AndroidDriver<WebElement> getBrowserStackMobileDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", "marinagilimovich_9pzhed");
        desiredCapabilities.setCapability("browserstack.key", "XAWMeainDypUDFT3D3Xt");

        desiredCapabilities.setCapability("project", "qa_guru_21");
        desiredCapabilities.setCapability("build", "Android");
        desiredCapabilities.setCapability("name", "Wiki tests");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");

        desiredCapabilities.setCapability("device", BROWSER_STACK_CONFIG_MOBILE.device());
        desiredCapabilities.setCapability("os_version", BROWSER_STACK_CONFIG_MOBILE.osVersion());
        desiredCapabilities.setCapability("app", BROWSER_STACK_CONFIG_MOBILE.app());

        return new AndroidDriver<>(MobileBrowserStackHelper.getBrowserstackUrl(), desiredCapabilities);
    }
}
