package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CinemaPage;

import static org.junit.Assert.assertTrue;

/**
 * * Created by plotnikvk
 */

public class CinemaSteps {

CinemaPage cinemaPage = new CinemaPage();
WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(),5);


    @Step("заголовок страницы -  {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = cinemaPage.title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выбрана дата - \"{0}\"")
    public void selectDate(String date){
        cinemaPage.closeWindow((WebElement) cinemaPage.closeButtonLink);
        wait.until(ExpectedConditions.visibilityOf((WebElement) cinemaPage.buttonWhen));
        cinemaPage.buttonWhen.click();
        cinemaPage.selectDateItem(date);
        cinemaPage.closeWindow((WebElement) cinemaPage.closeLink);
    }

    @Step("выбран фильм с рейтингом - >= {0}")
    public void selectFilm(double rating){cinemaPage.selectFilm(rating);
    }

    @Step("проверены название фильма и количество кинотеатров")
    public void check(){cinemaPage.checkNameAndPlace();}
}
