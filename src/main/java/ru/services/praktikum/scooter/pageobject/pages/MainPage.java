package ru.services.praktikum.scooter.pageobject.pages;
import static ru.services.praktikum.scooter.pageobject.Constants.OrderButtonConstants.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



public class MainPage extends BasePage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "Заказать" вверху
    private final By OrderButtonUp = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Кнопка "Заказать" внизу
    private final By OrderButtonDown = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");


    public MainPage(WebDriver driver) {
        super(driver);
    }

    //Клик по кнопке "Заказать" вверху
    public MainPage clickUpOrderButton() {
        driver.findElement(OrderButtonUp).click();
        return this;
    }

    //Клик по кнопке "Заказать" внизу
    public MainPage clickDownOrderButton() {
        driver.findElement(OrderButtonDown).click();
        return this;
    }

    //метод прокрутки ко второй кнопке "Заказать"
    public MainPage scrollToDownOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(OrderButtonDown));
        return this;
    }

    //Метод клика по кнопке "Заказать"
    public void clickCreateOrderButton(Enum button) {
        if (button.equals(BUTTON_1)) {
            clickUpOrderButton();
        } else if (button.equals(BUTTON_2)) {
            scrollToDownOrderButton();
            clickDownOrderButton();
        }
    }

}
