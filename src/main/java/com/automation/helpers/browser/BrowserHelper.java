package com.automation.helpers.browser;

import java.util.LinkedList;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.helpers.generic.GenericHelper;

/**
 * Class BrowserHelper
 */
public class BrowserHelper extends GenericHelper
{

    /** driver. */
    private WebDriver driver;

    /** o log. */
    private Logger oLog = LogManager.getLogger(BrowserHelper.class);

    /**
     * Instanciation de browser helper.
     *
     * @param driver
     */
    public BrowserHelper(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        oLog.debug("BrowserHelper : " + this.driver.hashCode());
    }

    /**
     * methode Go back
     */
    public void goBack()
    {
        driver.navigate().back();
        oLog.info("");
    }

    /**
     * methode Go forward
     */
    public void goForward()
    {
        driver.navigate().forward();
        oLog.info("");
    }

    /**
     * methode Refresh
     */
    public void refresh()
    {
        driver.navigate().refresh();
        oLog.info("");
    }

    /**
     * Accesseur de l attribut window handlens.
     *
     * @return window handlens
     */
    public Set<String> getWindowHandlens()
    {
        oLog.info("");
        return driver.getWindowHandles();
    }

    /**
     * methode Switch to window
     *
     * @param index
     */
    public void SwitchToWindow(int index)
    {

        LinkedList<String> windowsId = new LinkedList<String>(
            getWindowHandlens());

        if (index < 0 || index > windowsId.size())
            throw new IllegalArgumentException("Invalid Index : " + index);

        driver.switchTo().window(windowsId.get(index));
        oLog.info(index);
    }

    /**
     * methode Switch to parent window
     */
    public void switchToParentWindow()
    {
        LinkedList<String> windowsId = new LinkedList<String>(
            getWindowHandlens());
        driver.switchTo().window(windowsId.get(0));
        oLog.info("");
    }

    /**
     * methode Switch to parent with child close
     */
    public void switchToParentWithChildClose()
    {
        switchToParentWindow();

        LinkedList<String> windowsId = new LinkedList<String>(
            getWindowHandlens());

        for (int i = 1; i < windowsId.size(); i++)
        {
            oLog.info(windowsId.get(i));
            driver.switchTo().window(windowsId.get(i));
            driver.close();
        }

        switchToParentWindow();
    }

    /**
     * methode Switch to frame
     *
     * @param locator
     */
    public void switchToFrame(By locator)
    {
        driver.switchTo().frame(getElement(locator));
        oLog.info(locator);
    }

    /**
     * methode Switch to frame
     *
     * @param nameOrId
     */
    public void switchToFrame(String nameOrId)
    {
        driver.switchTo().frame(nameOrId);
        oLog.info(nameOrId);
    }

}