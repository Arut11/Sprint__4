package ru.services.praktikum.scooter.pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.services.praktikum.scooter.pageobject.pages.MainPage;


public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUpDriver() {

        driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(MainPage.URL);

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie((new Cookie("Cartoska-legasy", "true")));
        driver.navigate().refresh();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);

    }

    private WebDriver getDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                WebDriverManager.chromedriver().driverVersion("126.0.6478.126").setup();
                return new ChromeDriver();
            case "Firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("browser.startup.homepage", "about:blank");

                return new FirefoxDriver(options);
            default:
                throw new IllegalArgumentException("Driver type is not supported");
        }
    }

}
