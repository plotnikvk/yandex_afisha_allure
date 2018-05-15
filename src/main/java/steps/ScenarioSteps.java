package steps;


import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Когда;
import pages.PosterPage;

/**
 * Created by plotnikvk
 */

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    PosterSteps posterSteps = new PosterSteps();
    CinemaSteps cinemaSteps = new CinemaSteps();


    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainSteps.selectMenuItem(menuName);
    }

    @When("^выбран раздел \"(.+)\"$")
    public void selectSubMenuItem(String menuName){posterSteps.selectMenuItem(menuName);
    }

    @Then("^заголовок страницы - \"(.+)\"$")
    public void checkPageTitle(String expectedTitle){cinemaSteps.checkPageTitle(expectedTitle);
    }

    @When("^выбрана дата - \"(.+)\"$")
    public void selectDate(String date){cinemaSteps.selectDate(date);
    }
    @When("найден фильм с рейтингом >= \"(.+)\"$")
    public void selectFilm(String rating){cinemaSteps.selectFilm(Double.parseDouble(rating));
    }

    @Then("проверены название фильма и количество кинотеатров")
    public void check(){cinemaSteps.check();}
}
