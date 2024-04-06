package ru.lomakosv.configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final DriverConfig emulatorConfig
            = ConfigFactory.create(DriverConfig.class, System.getProperties());
}
