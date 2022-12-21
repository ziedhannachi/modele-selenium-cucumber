package com.automation.helpers.javascript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class JavaScriptHelper.
 */
public class JavaScriptHelper
{

    /** driver. */
    private WebDriver driver;

    /** o log. */
    private Logger oLog = LogManager.getLogger(JavaScriptHelper.class);

    /**
     * Instanciation de java script helper.
     *
     * @param driver 
     */
    public JavaScriptHelper(WebDriver driver)
    {
        this.driver = driver;
        oLog.debug("JavaScriptHelper : " + this.driver.hashCode());
    }

    /**
     * methode Execute script.
     *
     * @param script 
     * @return object
     */
    public Object executeScript(String script)
    {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        oLog.info(script);
        return exe.executeScript(script);
    }

    /**
     * methode Execute script.
     *
     * @param script 
     * @param args   
     * @return object
     */
    public Object executeScript(String script, Object... args)
    {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        oLog.info(script);
        return exe.executeScript(script, args);
    }

    /**
     * methode Scroll to elemet.
     *
     * @param element 
     */
    public void scrollToElemet(WebElement element)
    {
        executeScript("window.scrollTo(arguments[0],arguments[1])",
            element.getLocation().x, element.getLocation().y);
        oLog.info(element);
    }

    /**
     * methode Scroll to elemet.
     *
     * @param locator 
     */
    public void scrollToElemet(By locator)
    {
        scrollToElemet(driver.findElement(locator));
        oLog.info(locator);
    }

    /**
     * methode Scroll to elemet and click.
     *
     * @param locator 
     */
    public void scrollToElemetAndClick(By locator)
    {
        WebElement element = driver.findElement(locator);
        scrollToElemet(element);
        element.click();
        oLog.info(locator);
    }

    /**
     * methode Scroll to elemet and click.
     *
     * @param element 
     */
    public void scrollToElemetAndClick(WebElement element)
    {
        scrollToElemet(element);
        element.click();
        oLog.info(element);
    }

    /**
     * methode Scroll into view.
     *
     * @param element 
     */
    public void scrollIntoView(WebElement element)
    {
        executeScript("arguments[0].scrollIntoView()", element);
        oLog.info(element);
    }

    /**
     * methode Scroll into view.
     *
     * @param locator 
     */
    public void scrollIntoView(By locator)
    {
        scrollIntoView(driver.findElement(locator));
        oLog.info(locator);
    }

    /**
     * methode Scroll into view and click.
     *
     * @param locator 
     */
    public void scrollIntoViewAndClick(By locator)
    {
        WebElement element = driver.findElement(locator);
        scrollIntoView(element);
        element.click();
        oLog.info(locator);
    }

    /**
     * methode Scroll into view and click.
     *
     * @param element 
     */
    public void scrollIntoViewAndClick(WebElement element)
    {
        scrollIntoView(element);
        element.click();
        oLog.info(element);
    }
}
