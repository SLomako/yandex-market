package ru.lomakosv.config;

import org.aeonbits.owner.Config;

/**
 * Чтение ключей из emulator.properties
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/emulator.properties",
})
public interface EmulatorConfig extends Config {
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