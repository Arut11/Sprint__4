package ru.services.praktikum.scooter.pageobject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.services.praktikum.scooter.pageobject.pages.AboutRentalPage;
import ru.services.praktikum.scooter.pageobject.pages.MainPage;
import ru.services.praktikum.scooter.pageobject.pages.PopUpWindowAboutRentingPage;
import ru.services.praktikum.scooter.pageobject.pages.WhoIsTheScooterForPage;

import static org.junit.Assert.assertTrue;
import static ru.services.praktikum.scooter.pageobject.Constants.DaysConstants.*;
import static ru.services.praktikum.scooter.pageobject.Constants.ColorsConstants.*;
import static ru.services.praktikum.scooter.pageobject.Constants.MassageConctants.SUCCESS_FUL_ORDER_MESSAGE;
import static ru.services.praktikum.scooter.pageobject.Constants.OrderButtonConstants.*;

@RunWith(Parameterized.class)
public class orderingScooterTests extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final int metroNumber;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final Enum colour;
    private final String comment;
    private final String expectedHeader = SUCCESS_FUL_ORDER_MESSAGE;
    private final Enum button;

    public orderingScooterTests(Enum button, String name, String surname, String address, int metroNumber, String phoneNumber,
                           String date, String period, Enum colour, String comment) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroNumber = metroNumber;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {BUTTON_1, "Тест", "Тестовый", "Тестовая 1", 123, "79991111111", "28.05.2023", ONE_DAY, GREY, "comments one"},
                {BUTTON_1, "Имя Два", "Фамилия", "Адрес 2", 7, "79992222222", "28.05.2023", SEVEN_DAYS, BLACK, "comments two"},
                {BUTTON_2, "Имя Один", "Фамилия", "Адрес 1", 123, "79991111111", "28.05.2023", ONE_DAY, GREY, "comments one"},
                {BUTTON_2, "Имя Два", "Фамилия", "Адрес 2", 7, "79992222222", "28.05.2023", SEVEN_DAYS, BLACK, "comments two"},
        };
    }


    @Test
    public void testCreateOrderWithUpButton() {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickCreateOrderButton(button);

        new WhoIsTheScooterForPage(driver)
                .FillNameField(name)
                .FillSurnameField(surname)
                .FillAddressField(address)
                .ChooseAMetroStation(metroNumber)
                .FillPhoneField(phoneNumber)
                .clickNextButton();

        new AboutRentalPage(driver)
                .FillDateField(date)
                .FillPeriodField(period)
                .changeColour(colour)
                .FillCommentField(comment)
                .clickButtonCreateOrder();

        PopUpWindowAboutRentingPage popUpWindow = new PopUpWindowAboutRentingPage(driver);
        popUpWindow.clickButtonYes();

        assertTrue(popUpWindow.getMessageAfterCreatingOrder().contains(expectedHeader));
    }
}
