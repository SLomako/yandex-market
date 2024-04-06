package ru.lomakosv.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import io.qameta.allure.Step;
import ru.lomakosv.helpers.enums.PermissionAction;

public class AppDialogManager {

    private final SelenideElement titleTextView = $(id("ru.beru.android:id/titleTextView"));
    private final SelenideElement closeButton = $(id("ru.beru.android:id/closeButton"));
    private final SelenideElement permissionMessage = $(id("com.android.permissioncontroller:id/permission_message"));
    private final SelenideElement mapPinLabelTitle = $(id("ru.beru.android:id/mapPinLabelTitle"));
    private final SelenideElement onboardingMarketLayout = $(id("ru.beru.android:id/onboardingMarketLayout"));
    private final SelenideElement skipButton = $(id("ru.beru.android:id/negativeButton"));
    private final SelenideElement gotItButton = $(id("ru.beru.android:id/positiveButton"));

    @Step("Закрыть диалог уведомлений")
    public AppDialogManager closeNotificationDialogIfNeeded() {
        String expectedText = "Напомним о заказе, расскажем о скидке";

        if (titleTextView.is(text(expectedText), Duration.ofSeconds(8))) {
            closeButton.click();
        }
        return this;
    }

    @Step("Выбрать действие разрешения доступа к местоположению: {actionText}")
    public AppDialogManager chooseLocationPermissionAction(PermissionAction actionText) {
        String expectedText = "Allow Я.Маркет to access this device’s location?";

        if (permissionMessage.is(text(expectedText), Duration.ofSeconds(8))) {
            String actionTextString = actionText.getActionText();
            $(androidUIAutomator("new UiSelector().text(\"" + actionTextString + "\")")).click();
        }
        return this;
    }

    @Step("Закрыть выбор местоположения")
    public AppDialogManager closeLocationSelectionIfNeeded() {
        String expectedTitle = "Укажите адрес";

        if (mapPinLabelTitle.is(text(expectedTitle), Duration.ofSeconds(8))) {
            closeButton.click();
        }
        return this;
    }

    @Step("Закрыть рекламу")
    public AppDialogManager closeAdvertisementIfNeeded() {
        if (onboardingMarketLayout.is(Condition.visible, Duration.ofSeconds(8))) {
            closeButton.click();
        }
        return this;
    }

    @Step("Выбрать действие в всплывающем окне cookies: {0}")
    public void chooseCookiePopup(PermissionAction actionText) {
        if (skipButton.is(Condition.visible, Duration.ofSeconds(8))) {
            if (actionText == PermissionAction.SKIP) {
                skipButton.click();
            } else if (actionText == PermissionAction.GOT_IT) {
                gotItButton.click();
            }
        }
    }
}
