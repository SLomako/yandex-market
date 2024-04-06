package ru.lomakosv.configs;

import org.aeonbits.owner.Config;

/**
 * Чтение ключей из driver.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/driver.properties",
})
public interface DriverConfig extends Config {
    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("app")
    String app();

    @Key("remoteURL")
    String remoteURL();
}