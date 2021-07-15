package config;

import org.aeonbits.owner.Config;

@Config.Sources({"system:properties"})
public interface MobileDeviceHostConfig extends Config {

    @Key("device.host")
    @DefaultValue("local")
    String deviceHost();
}
