package ru.lomakosv.configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final AppiumTestConfig emulatorConfig
            = ConfigFactory.create(AppiumTestConfig.class, System.getProperties());
}
