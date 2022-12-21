package com.automation.helpers.textBox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.helpers.generic.GenericHelper;

/**
 * Class TextBoxHelper.
 */
public class TextBoxHelper extends GenericHelper {

    /** driver. */
    private WebDriver driver;
    
    /** o log. */
    private Logger oLog = LogManager.getLogger(TextBoxHelper.class);
    
    /**
     * Instanciation de text box helper.
     *
     * @param driver 
     */
    public TextBoxHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
        oLog.debug("TextBoxHelper : " + this.driver.hashCode());
    }
    
    /**
     * methode Send keys.
     *
     * @param locator 
     * @param value   
     */
    public void sendKeys(By locator,String value) {
        oLog.info("Locator : " + locator + " Value : " + value);
        getElement(locator).sendKeys(value);
    }
    
    /**
     * methode Clear.
     *
     * @param locator 
     */
    public void clear(By locator) {
        oLog.info("Locator : " + locator);
        getElement(locator).clear();
    }
    
    /**
     * Accesseur de l attribut text.
     *
     * @param locator 
     * @return text
     */
    public String getText(By locator) {
        oLog.info("Locator : " + locator);
        return getElement(locator).getText();
    }
    
    /**
     * methode Clear and send keys.
     *
     * @param locator 
     * @param value   
     */
    public void clearAndSendKeys(By locator,String value) {
        WebElement element =  getElement(locator);
        element.clear();
        element.sendKeys(value);
        oLog.info("Locator : " + locator + " Value : " + value);
    }

}
