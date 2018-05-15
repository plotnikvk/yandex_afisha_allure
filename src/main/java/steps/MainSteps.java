package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.MainPage;

/**
 * Created by plotnikvk
 */

public class MainSteps {

    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }
}
