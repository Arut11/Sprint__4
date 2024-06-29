
package ru.services.praktikum.scooter.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
        //Блок "Вопросы о важном"
public class QuestionsAboutImportantThingsPage extends BasePage {

    //Локатор кнопок с вопросами
    private final By questionButtons = By.xpath("//*[@class='accordion__button']");
    //Локатор выпадашек с ответами
    private final By answerPanels = By.xpath("//*[@class='accordion__panel']/p");

    public QuestionsAboutImportantThingsPage(WebDriver driver) {
        super(driver);

    }

    //Клик по вопросу
    public void clickQuestionButton(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(getQuestionButton(index))).click();

    }

    //Получаю текст ответа
    public String checkAnswerText(int index) {
        return getAnswerPanel(index).getText();

    }

    //Получаю текст вопроса
    public String getQuestionElement(int index) {
        return getQuestionButton(index).getText();

    }

    //Получаю количество вопросов
    public int getQuestionCount() {
        return getQuestionButtons().size();

    }

    //Ищу нужный вопрос
    private WebElement getQuestionButton(int index) {
        return getQuestionButtons().get(index);

    }

    //Ищу нужный ответ
    private WebElement getAnswerPanel(int index) {
        return getAnswerPanels().get(index);

    }

    //Получаю элемент Вопроса
    private List<WebElement> getQuestionButtons() {
        return driver.findElements(questionButtons);

    }

    //Получаю элемент ответа
    private List<WebElement> getAnswerPanels() {
        return driver.findElements(answerPanels);

    }

    //Метод
    public int findQuestionIndex(QuestionsAboutImportantThingsPage page, String question) {

        int questionCount = page.getQuestionCount();
        for (int i = 0; i < questionCount; i++) {
            if (question.equals(page.getQuestionElement(i))) {
                return i;
            }
        }
        return -1;
    }

}
