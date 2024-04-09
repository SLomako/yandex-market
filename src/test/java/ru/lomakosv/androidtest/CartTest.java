package ru.lomakosv.androidtest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.qameta.allure.Allure.step;
import static ru.lomakosv.helpers.enums.PermissionAction.DONT_ALLOW;
import static ru.lomakosv.helpers.enums.PermissionAction.SKIP;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.AllureId;
import ru.lomakosv.androidtest.utils.Scroll;
import ru.lomakosv.androidtest.utils.AppDialogManager;
import ru.lomakosv.androidtest.pages.AuthorizationPage;
import ru.lomakosv.androidtest.pages.CartPage;
import ru.lomakosv.androidtest.pages.CatalogPage;
import ru.lomakosv.androidtest.pages.NavigationBar;

public class CartTest extends TestBase {

    private String productName;
    private final AuthorizationPage authorizationPage = new AuthorizationPage();
    private final AppDialogManager appInitializationHandler = new AppDialogManager();
    private final NavigationBar navigationBar = new NavigationBar();
    private final CatalogPage catalogPage = new CatalogPage();
    private final CartPage cartPage = new CartPage();

    @Test
    @AllureId("0001")
    @DisplayName("Тест-кейс №1:")
    void testAddProductInCart() {
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
            Scroll.scrollToAndClick("Книги");
        });
        step("Добавить первый предложенный товар в корзину по кнопке 'В корзину'", () -> {
            productName = catalogPage.addFirstProductToCart();
        });
        step("Перейти в корзину и проверить, что выбранный товар отображается в корзине", () -> {
            navigationBar.clickOnCart();
            boolean isPresentInCart = cartPage.isProductPresentInCart(productName);

            assertTrue(isPresentInCart, productName + "' не найден в корзине!");
        });
    }

    @Test
    @AllureId("0002")
    @DisplayName("Тест-кейс №2:")
    void testAddAndDeleteProductInCart() {
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
            Scroll.scrollToAndClick("Книги");
        });
        step("Добавить первый предложенный товар в корзину по кнопке 'В корзину'", () -> {
            productName = catalogPage.addFirstProductToCart();
        });
        step("Перейти в корзину, удалить выбранный товар и проверить, что корзина пуста", () -> {
            navigationBar.clickOnCart();
            cartPage.deleteSelectedItems();
            cartPage.confirmDeletionOfAllItemsInCart();

            assertTrue(cartPage.isCartEmpty(), "Корзина не пуста!");

        });
    }
}