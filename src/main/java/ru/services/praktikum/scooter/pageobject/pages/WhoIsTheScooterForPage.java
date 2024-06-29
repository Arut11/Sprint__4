package ru.services.praktikum.scooter.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Форма "Для кого этот скутер"

public class WhoIsTheScooterForPage extends BasePage {

    //Заголовок формы "Для кого самокат"
    private final By orderHeader = By.className("Order_Header__BZXOb");
    //Поле ввода "Имя" формы "Для кого самокат"
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия" формы "Для кого самокат"
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес: куда привезти заказ" формы "Для кого самокат"
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода "Станция метро" формы "Для кого самокат"
    private final By stateMetro = By.className("select-search__input");
    //Поле ввода "Телефон: на него позвонит курьер" формы "Для кого самокат"
    private final By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее" формы "Для кого самокат"
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Элементы выпадающего списка в поле "Станция метро" формы "Для кого самокат"
    private final String nameStateMetro = ".//button[@value='%s']";

    public WhoIsTheScooterForPage(WebDriver driver) {
        super(driver);
    }

    //Метод для ввода значения в поле "Имя"
    public WhoIsTheScooterForPage FillNameField(String newName) {
        driver.findElement(name).sendKeys(newName);
        return this;
    }

    //Метод для ввода значения в поле "Фамилия"
    public WhoIsTheScooterForPage FillSurnameField(String newSurname) {
        driver.findElement(surname).sendKeys(newSurname);
        return this;
    }

    //Метод для ввода значения в поле "Адрес"
    public WhoIsTheScooterForPage FillAddressField(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
        return this;
    }

    //Метод для ввода значения в поле "Станция метро"
    public WhoIsTheScooterForPage ChooseAMetroStation(int stateNumber) {
        driver.findElement(stateMetro).click();
        By newStateMetro = By.xpath(String.format(nameStateMetro, stateNumber));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(newStateMetro));
        driver.findElement(newStateMetro).click();
        return this;
    }

    //Метод для ввода значения в поле "Телефон"
    public WhoIsTheScooterForPage FillPhoneField(String newPhone) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(phone));
        driver.findElement(phone).sendKeys(newPhone);
        return this;
    }

    //Клик по кнопке "Далее"
    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }


}
