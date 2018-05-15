package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * * Created by plotnikvk
 */

public class CinemaPage extends BasePageObject {

    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(),10);

    public CinemaPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//h1[@class='feed-title rubric-title content-rubric__title']")
    public WebElement title;

    @FindBy(xpath = "//span[@class='presets-list__title']")
    public List<WebElement> selectWhenDate;

    @FindBy(xpath = "//span[@class='button2__text'][text()='Когда']/ancestor::button")
    public WebElement buttonWhen;

    @FindBy(xpath = "//span[@class='button2__text'][text()='Закрыть']/ancestor::button")
    public WebElement closeButtonLink;

    @FindBy(xpath = "//div[@class='tutorial-modal__close']")
    public WebElement closeLink;

    @FindBy(xpath = "//div[@class='event__image']/ancestor::div[@itemscope]")
    public List<WebElement> cartsOfCinema;

    @FindBy(xpath = "//div[@class='event-rating__value']")
    public WebElement ratingLink;

    @FindBy(xpath = "//h2[@class='event__name']")
    public  WebElement name;

    @FindBy(xpath = "//div[@class='event__place']")
    public WebElement place;

    public String nameOfFilms;

    public String placeOfFilms;

    @FindBy(xpath = "//h1[@class='event-heading__title']")
    public WebElement nameOfFilm;

    @FindBy(xpath = "//span[@class='event-heading__place']")
    public WebElement placeOfFilm;



    public void closeWindow(WebElement item){
        try{
            wait.until(ExpectedConditions.visibilityOf(item));
            item.click();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void selectDateItem(String itemName){
        for (WebElement item : selectWhenDate ){
            if (item.getText().equalsIgnoreCase(itemName)){
                item.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }

    public void selectFilm(float rating) {
        for (WebElement item : cartsOfCinema ){
            if (item.getText().contains(ratingLink.getText())){
                if(Float.parseFloat(item.findElement(By.xpath("//div[@class='event-rating__value']")).getText()) >= rating){

                   nameOfFilms = item.findElement((By) name).getText();
                    placeOfFilms = item.findElement((By) place).getText();
                   WebElement film = item.findElement(By.xpath("//div[@class='event__inner']/a"));
                   film.click();
                return;
                }
            }
        }
    }

    public void checkNameAndPlace(){
        Assert.assertEquals("Имя фильма не соответствует сохраненному",nameOfFilms,nameOfFilm.getText());
        Assert.assertEquals("Количество кинотеатров не соответствует сохраненному",placeOfFilms,placeOfFilm.getText());
    }
}
