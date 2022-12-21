package com.automation.helpers.dropDown;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.helpers.generic.GenericHelper;

/**
 * Class DropDownHelper
 */
public class DropDownHelper extends GenericHelper
{

    /** driver. */
    private WebDriver driver;

    /** o log. */
    private Logger oLog = LogManager.getLogger(DropDownHelper.class);

    /**
     * Instanciation de drop down helper.
     *
     * @param driver
     */
    public DropDownHelper(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        oLog.debug("DropDownHelper : " + this.driver.hashCode());
    }

    /**
     * methode Select using visible value
     *
     * @param locator      
     * @param visibleValue 
     */
    public void SelectUsingVisibleValue(By locator, String visibleValue)
    {
        SelectUsingVisibleValue(getElement(locator), visibleValue);
    }

    /**
     * methode Select using visible value
     *
     * @param element      
     * @param visibleValue 
     */
    public void SelectUsingVisibleValue(WebElement element, String visibleValue)
    {
        Select select = new Select(element);
        select.selectByVisibleText(visibleValue);
        oLog.info("Locator : " + element + " Value : " + visibleValue);
    }

    /**
     * methode Select using value 
     *
     * @param locator
     * @param value
     */
    public void SelectUsingValue(By locator, String value)
    {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
        oLog.info("Locator : " + locator + " Value : " + value);
    }

    /**
     * methode Select using index
     *
     * @param locator
     * @param index
     */
    public void SelectUsingIndex(By locator, int index)
    {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
        oLog.info("Locator : " + locator + " Index : " + index);
    }

    /**
     * Accesseur de l attribut selected value.
     *
     * @param locator 
     * @return selected value
     */
    public String getSelectedValue(By locator)
    {
        oLog.info(locator);
        return getSelectedValue(getElement(locator));
    }

    /**
     * Accesseur de l attribut selected value.
     *
     * @param element
     * @return selected value
     */
    public String getSelectedValue(WebElement element)
    {
        String value = new Select(element).getFirstSelectedOption().getText();
        oLog.info("WebELement : " + element + " Value : " + value);
        return value;
    }

    /**
     * Accesseur de l attribut all drop down values.
     *
     * @param locator
     * @return all drop down values
     */
    public List<String> getAllDropDownValues(By locator)
    {
        Select select = new Select(getElement(locator));
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();

        for (WebElement element : elementList)
        {
            oLog.info(element.getText());
            valueList.add(element.getText());
        }
        return valueList;
    }
}
