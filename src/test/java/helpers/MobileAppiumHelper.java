package helpers;

import config.MobileProjectData;

import java.net.MalformedURLException;
import java.net.URL;

import static config.MobileProjectData.MOBILE_APPIUM_CONFIG;

public class MobileAppiumHelper {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(isCredentials() ? String.format(MOBILE_APPIUM_CONFIG.appiumServerUrl(),
                    MOBILE_APPIUM_CONFIG.appiumServerUser(),
                    MOBILE_APPIUM_CONFIG.appiumServerPassword()) :
                    MOBILE_APPIUM_CONFIG.appiumServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Credentials are not used for local launch
     */
    public static boolean isCredentials() {
        return MOBILE_APPIUM_CONFIG.appiumServerPassword() != null && MOBILE_APPIUM_CONFIG.appiumServerUser() != null &&
                !MOBILE_APPIUM_CONFIG.appiumServerPassword().equals("") && !MOBILE_APPIUM_CONFIG.appiumServerUser().equals("");
    }

    public static String getSelenoidVideoUrl(String sessionId) {
        return MobileProjectData.MOBILE_APPIUM_CONFIG.videoStorage() + sessionId + ".mp4";
    }
}
