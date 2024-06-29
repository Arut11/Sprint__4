package ru.services.praktikum.scooter.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.services.praktikum.scooter.pageobject.Constants.ColorsConstants.BLACK;
import static ru.services.praktikum.scooter.pageobject.Constants.ColorsConstants.GREY;

//Страница "Про аренду"
public class AboutRentalPage extends BasePage {

    //Поле "Когда привезти самокат"
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Поле срок аренды
    private final By periodField = By.xpath(".//span[@class='Dropdown-arrow']");
    //Локаторы цветов самоката
    private final By colourBlack = By.id("black");
    private final By colourGrey = By.id("grey");
    //Поле "Комментарий для курьера"
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private final By createOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutRentalPage(WebDriver driver) {
        super(driver);

    }
    //Метод заполнения поля "Когда привезти самокат"
    public AboutRentalPage FillDateField(String newDate) {
        driver.findElement(date).sendKeys(newDate);
        return this;
    }

    //Метод для заполнения поля "Срок аренды"
    public AboutRentalPage FillPeriodField(String newPeriod) {
        driver.findElement(periodField).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Dropdown-option' and text()='" + newPeriod + "']"))).click();
        return this;
    }

    //Метод выбора чек-бокса "Цвет самоката"
    public AboutRentalPage changeColour(Enum colour) {
        if (colour.equals(BLACK)) {
            driver.findElement(colourBlack).click();
        } else if (colour.equals(GREY)) {
            driver.findElement(colourGrey).click();
        }
        return this;
    }

    //Метод заполнения поля "Комментарий для курьера"
    public AboutRentalPage FillCommentField(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
        return this;
    }

    //Метод клика кнопки "Заказать"
    public void clickButtonCreateOrder() {
        driver.findElement(createOrderButton).click();
    }

}

