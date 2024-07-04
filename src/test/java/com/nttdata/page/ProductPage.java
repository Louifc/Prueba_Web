package com.nttdata.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    // Constructor para inicializar WebDriver
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para iniciar sesión
    public void login(String usuario, String clave) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(usuario);
        passwordField.sendKeys(clave);
        loginButton.click();
    }

    // Método para navegar a una categoría específica
    public void navigateToCategory(String category, String subcategory) {
        WebElement categoryElement = driver.findElement(By.linkText(category));
        categoryElement.click();

        WebElement subcategoryElement = driver.findElement(By.linkText(subcategory));
        subcategoryElement.click();
    }

    // Método para agregar una cantidad específica del primer producto al carrito
    public void addFirstProductToCart(int quantity) {
        WebElement firstProduct = driver.findElement(By.cssSelector("div.product-item:first-child"));
        for (int i = 0; i < quantity; i++) {
            firstProduct.findElement(By.cssSelector(".add-to-cart")).click();
        }
    }

    // Método para validar que un producto fue agregado exitosamente
    public boolean isProductAddedConfirmationDisplayed() {
        WebElement confirmationPopup = driver.findElement(By.cssSelector("#confirmation-popup"));
        return confirmationPopup.isDisplayed();
    }

    // Método para obtener el monto total del popup de confirmación
    public double getTotalAmountFromPopup() {
        WebElement totalAmountElement = driver.findElement(By.cssSelector("#confirmation-popup .total-amount"));
        String totalAmountText = totalAmountElement.getText();
        return Double.parseDouble(totalAmountText.replace("$", "").replace(",", ""));
    }

    // Método para finalizar la compra
    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout-button"));
        checkoutButton.click();
    }

    // Método para validar el título de la página del carrito
    public boolean isCartPageTitleDisplayed() {
        WebElement cartPageTitle = driver.findElement(By.cssSelector("#cart-page-title"));
        return cartPageTitle.isDisplayed();
    }

    // Método para validar los precios en la página del carrito
    public boolean areCartPricesValid() {
        WebElement cartTotalElement = driver.findElement(By.cssSelector("#cart-total"));
        String cartTotalText = cartTotalElement.getText();
        double cartTotal = Double.parseDouble(cartTotalText.replace("$", "").replace(",", ""));
        return cartTotal > 0; // Ejemplo simple de validación
    }
}
