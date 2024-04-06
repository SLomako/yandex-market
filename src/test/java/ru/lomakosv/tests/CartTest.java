package ru.lomakosv.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.qameta.allure.Allure.step;
import static ru.lomakosv.helpers.enums.PermissionAction.DONT_ALLOW;
import static ru.lomakosv.helpers.enums.PermissionAction.SKIP;

import org.junit.jupiter.api.Test;

import ru.lomakosv.helpers.Utils;
import ru.lomakosv.pages.AppDialogManager;
import ru.lomakosv.pages.AuthorizationPage;
import ru.lomakosv.pages.CartPage;
import ru.lomakosv.pages.CatalogPage;
import ru.lomakosv.pages.NavigationBar;

public class CartTest extends TestBase {

    private String productName;
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AppDialogManager appInitializationHandler = new AppDialogManager();
    private final NavigationBar navigationBar = new NavigationBar();
    private final CatalogPage catalogPage = new CatalogPage();
    private final CartPage cartPage = new CartPage();

    @Test
    void testCaseOne() {
        step("Закрыть окно авторизации для выбора Яндекс аккаунта", () -> {
            authorizationPage.clickBackArrow();

            appInitializationHandler
                    .closeNotificationDialogIfNeeded()
                    .chooseLocationPermissionAction(DONT_ALLOW)
                    .closeLocationSelectionIfNeeded()
                    .closeAdvertisementIfNeeded()
                    .chooseCookiePopup(SKIP);
        });
        step("Перейти в каталог, во вторую вкладку для выбора разделов", () -> {
            navigationBar.clickOnCatalog();
        });

        step("Перейти в раздел 'Книги'", () -> {
            Utils.scrollToAndClick("Книги");
        });

        step("Добавить первый предложенный товар в корзину по кнопке 'В корзину'", () -> {
            productName = catalogPage.addFirstProductToCart();
        });

        step("Перейти в корзину и проверить, что выбранный товар отображается в корзине", () -> {
            navigationBar.clickOnCart();
            boolean isBookPresentInCart = cartPage.isProductPresentInCart(productName);

            assertTrue(isBookPresentInCart, productName + "' не найден в корзине!");
        });
    }
}