package com.automation.helpers.navigation;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Class NavigationHelper.
 */
public class NavigationHelper
{

    /** driver. */
    private WebDriver driver;

    /** o log. */
    private Logger oLog = LogManager.getLogger(NavigationHelper.class);

    /**
     * Instanciation de navigation helper.
     *
     * @param driver
     */
    public NavigationHelper(WebDriver driver)
    {
        this.driver = driver;
        oLog.debug("NavigationHelper : " + this.driver.hashCode());
    }

    /**
     * methode Navigate to.
     *
     * @param url
     */
    public void navigateTo(String url)
    {
        oLog.info(url);
        driver.get(url);
    }

    /**
     * methode Naviagte to.
     *
     * @param url
     */
    public void naviagteTo(URL url)
    {
        oLog.info(url.getPath());
        driver.get(url.getPath());
    }

    /**
     * Accesseur de l attribut title.
     *
     * @return title
     */
    public String getTitle()
    {
        String title = driver.getTitle();
        oLog.info(title);
        return driver.getTitle();
    }

    /**
     * Accesseur de l attribut current url.
     *
     * @return current url
     */
    public String getCurrentUrl()
    {
        String url = driver.getCurrentUrl();
        oLog.info(url);
        return driver.getCurrentUrl();
    }

}
