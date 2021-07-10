package config;

import org.aeonbits.owner.Config;

@Config.Sources({"system:properties"})
public interface DeviceHostConfig extends Config {

    @Key("device.host")
    @DefaultValue("local")
    String deviceHost();
}
