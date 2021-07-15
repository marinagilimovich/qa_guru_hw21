package config;

import org.aeonbits.owner.ConfigFactory;

public class MobileProjectData {
    public static final MobileBrowserstackConfig BROWSER_STACK_CONFIG_MOBILE =
            ConfigFactory.create(MobileBrowserstackConfig.class, System.getProperties());
    public static final MobileAppiumConfig MOBILE_APPIUM_CONFIG =
            ConfigFactory.create(MobileAppiumConfig.class, System.getProperties());
    public static final MobileDeviceHostConfig MOBILE_DEVICE_HOST_CONFIG =
            ConfigFactory.create(MobileDeviceHostConfig.class, System.getProperties());

    public static MobileDeviceHost deviceHost() {
        return MobileDeviceHost.valueOf(MOBILE_DEVICE_HOST_CONFIG.deviceHost().toUpperCase());
    }
}
