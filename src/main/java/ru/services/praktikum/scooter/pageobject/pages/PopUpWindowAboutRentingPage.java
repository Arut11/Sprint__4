package ru.services.praktikum.scooter.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

           //Форма "Про аренду"
public class PopUpWindowAboutRentingPage extends BasePage {

    //Всплывашка с сообщением об успешно оформленном заказе в форме "Про аренду"
    private final By PopUpWindowAfterOrderCreation = By.xpath(".//div[text()='Заказ оформлен']");
    //Кнопка "Да" в всплывашке после клика кнопки "Заказать" в форме "Про аренду"
    private final By PopUpButtonYes = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public PopUpWindowAboutRentingPage(WebDriver driver) {
        super(driver);
    }

    //Метод для клика по кнопке "Да" во всплывашке после клика "Заказать"
    public void clickButtonYes() {
        wait.until(ExpectedConditions.elementToBeClickable(PopUpButtonYes)).click();
    }

    //Метод для просмотра сообщения всплывашки после заказа
    public String getMessageAfterCreatingOrder() {
        return driver.findElement(PopUpWindowAfterOrderCreation).getText();

    }

}
