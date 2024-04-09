package ru.lomakosv.iostest;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import io.qameta.allure.selenide.AllureSelenide;
import ru.lomakosv.drivers.IOSAppiumDriver;
import ru.lomakosv.helpers.Attach;
import ru.lomakosv.iostest.utils.AppInitializer;
import ru.lomakosv.junit.annotation.AllureListener;

@AllureListener
@Tag("ios")
public class TestBase {

    AppInitializer appInitializer = new AppInitializer();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = IOSAppiumDriver.class.getName();
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
        Attach.pageSource();
        closeWebDriver();
    }
}

