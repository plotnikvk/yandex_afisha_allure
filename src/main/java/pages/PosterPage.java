package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

/**
 * * Created by plotnikvk
 */

public class PosterPage extends BasePageObject{

    public PosterPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }



    @FindBy(xpath = "//div[@class='header-menu__inner grid__margin-left grid__margin-right']//a")
    public List<WebElement> posterMenuLinks;


    public void selectMenuItem(String menuItem) {
        for (WebElement item : posterMenuLinks) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                item.click();
                return;
            }
        }
    }

}


