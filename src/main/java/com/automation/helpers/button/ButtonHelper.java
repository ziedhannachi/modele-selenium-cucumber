package com.automation.helpers.button;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.logging.log4j.Logger;

/**
 * Class ButtonHelper
 */
public class ButtonHelper
{

    /** driver. */
    private WebDriver driver;

    /** o log. */
    private Logger oLog = LogManager.getLogger(ButtonHelper.class);

    /**
     * Instanciation de button helper.
     *
     * @param driver
     */
    public ButtonHelper(WebDriver driver)
    {
        this.driver = driver;
        oLog.debug("Button Helper : " + this.driver.hashCode());
    }

    /**
     * methode Click
     *
     * @param locator
     */
    public void click(By locator)
    {
        click(driver.findElement(locator));
        oLog.info(locator);
    }

    /**
     * methode Click.
     *
     * @param element
     */
    public void click(WebElement element)
    {
        element.click();
        oLog.info(element);
    }
}
