package config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectData {
    public static final BrowserstackConfig browserStackConfig =
            ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    public static final AppiumConfig appiumConfig =
            ConfigFactory.create(AppiumConfig.class, System.getProperties());
    public static final DeviceHostConfig deviceHostConfig =
            ConfigFactory.create(DeviceHostConfig.class, System.getProperties());

    public static DeviceHost deviceHost() {
        return DeviceHost.valueOf(deviceHostConfig.deviceHost().toUpperCase());
    }
}
