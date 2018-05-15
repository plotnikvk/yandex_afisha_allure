package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;
import org.junit.Assert;

import java.util.List;

/**
 * Created by plotnikvk
 */

    public class MainPage extends BasePageObject {

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class=\"home-arrow__tabs\"]//a")
    public List<WebElement> menuItems;

    @FindBy(xpath = "//div[@class=\"home-tabs__more-item\"]/a")
    public List<WebElement> yetMenuItems;


    public void selectMenuItem(String menuItem) {
        for (WebElement item : menuItems) {
            if (item.getText().equalsIgnoreCase(menuItem)) {
                item.click();
                return;
            }
        }
        selectMenuYet(menuItem);

    }

    public void selectMenuYet(String menuItem){
        for (WebElement item3: menuItems) {
            if (item3.getText().equalsIgnoreCase("ещё")) {
                item3.click();
                break;
            }
        }
        selectAnotherMenu(menuItem);
    }
    public  void selectAnotherMenu(String menuItem){
        for (WebElement item2 : yetMenuItems){
            if (item2.getText().equalsIgnoreCase(menuItem)) {
                item2.click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + menuItem);
    }
}
