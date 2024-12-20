package command_providers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import playground.TestNgMavenExampleTest;
import utilities_qatek.ScreenCapture;

import java.time.Duration;

public class ElementActions {

    private static final Logger LOGGER = LogManager.getLogger(ElementActions.class);

    private WebDriver driver;
    private By locator;

    public ElementActions(WebDriver driver, By locator){
        this.driver = driver;
        this.locator = locator;
    }

    public WebElement getElement(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement element = null;
        try{
            element = driver.findElement(locator);
        } catch(Exception e){
            ScreenCapture.getScreenshot(driver);
            LOGGER.error("Element exception for the locator: " + locator + " and the exception is: " + e.getMessage());
        }
        return element;
    }

    public ElementActions click(){
        getElement().click();
        return this;
    }

    public ElementActions setValue(String value){
        getElement().clear();
        getElement().sendKeys(value);
        return this;
    }

    public ElementActions selectValue(String value){
        Select select = new Select(getElement());
        select.selectByVisibleText(value);
        return this;
    }

    public ElementActions mouseHover(){
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement()).perform();
        return this;
    }

    public String getTextValue(){
        return getElement().getText();
    }


}
