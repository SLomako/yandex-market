package ru.lomakosv.tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import io.qameta.allure.selenide.AllureSelenide;
import ru.lomakosv.drivers.LocalDriver;
import ru.lomakosv.helpers.AppInitializer;
import ru.lomakosv.helpers.Attach;

public class TestBase {

    private final AppInitializer appInitializer = new AppInitializer();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = LocalDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        appInitializer.openApp();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}

