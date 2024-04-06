package ru.lomakosv.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.lomakosv.constants.PermissionAction;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;

public class AppDialogManager {

    private final SelenideElement titleTextView = $(id("ru.beru.android:id/titleTextView"));
    private final SelenideElement closeButton = $(id("ru.beru.android:id/closeButton"));
    private final SelenideElement permissionMessage = $(id("com.android.permissioncontroller:id/permission_message"));
    private final SelenideElement mapPinLabelTitle = $(id("ru.beru.android:id/mapPinLabelTitle"));
    private final SelenideElement onboardingMarketLayout = $(id("ru.beru.android:id/onboardingMarketLayout"));
    private final SelenideElement skipButton = $(id("ru.beru.android:id/negativeButton"));
    private final SelenideElement gotItButton = $(id("ru.beru.android:id/positiveButton"));

    public AppDialogManager closeNotificationDialogIfNeeded() {
        String expectedText = "Напомним о заказе, расскажем о скидке";

        if (titleTextView.is(text(expectedText), Duration.ofSeconds(8))) {
            closeButton.click();
        }
        return this;
    }

    public AppDialogManager chooseLocationPermissionAction(PermissionAction actionText) {
        String expectedText = "Allow Я.Маркет to access this device’s location?";

        if (permissionMessage.is(text(expectedText), Duration.ofSeconds(8))) {
            String actionTextString = actionText.getActionText();
            $(androidUIAutomator("new UiSelector().text(\"" + actionTextString + "\")")).click();
        }
        return this;
    }

    public AppDialogManager closeLocationSelectionIfNeeded() {
        String expectedTitle = "Укажите адрес";

        if (mapPinLabelTitle.is(text(expectedTitle), Duration.ofSeconds(8))) {
            closeButton.click();
        }
        return this;
    }

    public AppDialogManager closeAdvertisementIfNeeded() {
        if (onboardingMarketLayout.is(Condition.visible, Duration.ofSeconds(8))) {
            closeButton.click();
        }
        return this;
    }

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
