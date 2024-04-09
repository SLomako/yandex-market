package ru.lomakosv.androidtest;

import static com.codeborne.selenide.Selenide.closeWebDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import io.qameta.allure.selenide.AllureSelenide;
import ru.lomakosv.androidtest.utils.AppInitializer;
import ru.lomakosv.drivers.LocalDriver;
import ru.lomakosv.helpers.Attach;
import ru.lomakosv.junit.annotation.AllureListener;

@AllureListener
@Tag("android")
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
        Attach.pageSource();
        closeWebDriver();
    }
}
