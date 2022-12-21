package com.automation.helpers.checkbox;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class CheckBoxOrRadioButtonHelper
 */
public class CheckBoxOrRadioButtonHelper
{

    /** driver. */
    private WebDriver driver;

    /** o log. */
    private Logger oLog = LogManager.getLogger(CheckBoxOrRadioButtonHelper.class);

    /**
     * Instanciation de check box or radio button helper.
     *
     * @param driver
     */
    public CheckBoxOrRadioButtonHelper(WebDriver driver)
    {
        this.driver = driver;
        oLog.debug("CheckBoxOrRadioButtonHelper : " + this.driver.hashCode());
    }

    /**
     * methode Select check box
     *
     * @param locator
     */
    public void selectCheckBox(By locator)
    {
        oLog.info(locator);
        selectCheckBox(driver.findElement(locator));
    }

    /**
     * methode Un select check box
     *
     * @param locator
     */
    public void unSelectCheckBox(By locator)
    {
        oLog.info(locator);
        unSelectCheckBox(driver.findElement(locator));
    }

    /**
     * Verifie si iselected.
     *
     * @param locator
     * @return true, si c'est iselected
     */
    public boolean isIselected(By locator)
    {
        oLog.info(locator);
        return isIselected(driver.findElement(locator));
    }

    /**
     * Verifie si iselected.
     *
     * @param element
     * @return true, si c'est iselected
     */
    public boolean isIselected(WebElement element)
    {
        boolean flag = element.isSelected();
        oLog.info(flag);
        return flag;
    }

    /**
     * methode Select check box
     *
     * @param element
     */
    public void selectCheckBox(WebElement element)
    {
        if (!isIselected(element))
            element.click();
        oLog.info(element);
    }

    /**
     * methode Un select check box
     *
     * @param element
     */
    public void unSelectCheckBox(WebElement element)
    {
        if (isIselected(element))
            element.click();
        oLog.info(element);
    }
}
