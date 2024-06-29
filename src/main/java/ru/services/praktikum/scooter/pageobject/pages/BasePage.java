package ru.services.praktikum.scooter.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

        public final WebDriver driver;
        public final WebDriverWait wait;

        public BasePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

}
