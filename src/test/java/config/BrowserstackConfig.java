package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browser_stack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("bs.url")
    String url();

    @Key("bs.sessions.url")
    String sessionsUrl();

    @Key("bs.login")
    String bsLogin();

    @Key("bs.password")
    String bsPassword();

    @Key("bs.device")
    String device();

    @Key("bs.os.version")
    String osVersion();

    @Key("bs.app")
    String app();
}
