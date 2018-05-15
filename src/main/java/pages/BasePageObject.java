package pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by plotnikvk
 */

public  class BasePageObject {

    public BasePageObject() {

        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
