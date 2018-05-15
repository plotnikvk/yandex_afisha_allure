package steps;

import io.qameta.allure.Step;
import pages.PosterPage;

/**
 * Created by plotnikvk
 */

public class PosterSteps {

    @Step("выбран раздел {0}")
    public void selectMenuItem(String menuItem){
        new PosterPage().selectMenuItem(menuItem);
    }
}
