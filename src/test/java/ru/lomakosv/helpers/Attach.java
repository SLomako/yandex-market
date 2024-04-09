package ru.lomakosv.helpers;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.nio.charset.StandardCharsets;

import io.qameta.allure.Attachment;

public class Attach {

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
}
