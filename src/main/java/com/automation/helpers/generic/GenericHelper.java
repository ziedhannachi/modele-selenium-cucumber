package com.automation.helpers.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.utility.BasePage;

/**
 * Class GenericHelper.
 *
 * @author Zied.Hannachi 09-Aug-2022
 */
public class GenericHelper extends BasePage
{

    /** driver. */
    private WebDriver driver;

    /**
     * Instanciation de generic helper.
     *
     * @param driver
     */
    public GenericHelper(WebDriver driver)
    {
        this.driver = driver;
        log.debug("GenericHelper : " + this.driver.hashCode());
    }

    /**
     * Accesseur de l attribut element.
     *
     * @param locator
     * @return element
     */
    public WebElement getElement(By locator)
    {
        log.info(locator);
        if (isElementPresentQuick(locator))
            return driver.findElement(locator);

        try
        {
            throw new NoSuchElementException("Element Not Found : " + locator);
        }
        catch (RuntimeException re)
        {
            log.error(re);
            throw re;
        }
    }

    /**
     * Check for element is present based on locator If the element is present return the web element otherwise null.
     *
     * @param locator
     * @return WebElement or null
     */

    public WebElement getElementWithNull(By locator)
    {
        log.info(locator);
        try
        {
            return driver.findElement(locator);
        }
        catch (NoSuchElementException e)
        {
            // Ignore
        }
        return null;
    }

    /**
     * methode Checks if is element present quick.
     *
     * @param locator
     * @return true, si c'est vrai
     */
    public boolean isElementPresentQuick(By locator)
    {
        boolean flag = driver.findElements(locator).size() >= 1;
        log.info(flag);
        return flag;
    }

    /**
     * methode Take screen shot.
     *
     * @param name
     * @return string
     * @throws IOException Signal qu'une execption de type I/O s'est produite.
     */
//    public String takeScreenShot(String name) throws IOException
//    {
//
//        if (driver instanceof HtmlUnitDriver)
//        {
//            log.fatal("HtmlUnitDriver Cannot take the ScreenShot");
//            return "";
//        }
//
//        File destDir = new File(ResourceHelper.getResourcePath("screenshots/")
//            + DateTimeHelper.getCurrentDate());
//        if (!destDir.exists())
//            destDir.mkdir();
//
//        File destPath = new File(destDir.getAbsolutePath()
//            + System.getProperty("file.separator") + name + ".jpg");
//        try
//        {
//            FileUtils
//                .copyFile(((TakesScreenshot) driver)
//                    .getScreenshotAs(OutputType.FILE), destPath);
//        }
//        catch (IOException e)
//        {
//            log.error(e);
//            throw e;
//        }
//        log.info(destPath.getAbsolutePath());
//        return destPath.getAbsolutePath();
//    }

    /**
     * methode Take screen shot.
     *
     * @return string
     */
    public String takeScreenShot()
    {
        log.info("");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}
