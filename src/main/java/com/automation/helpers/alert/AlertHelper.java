package com.automation.helpers.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.automation.utility.BasePage;

/**
 * Class AlertHelper.
 */
public class AlertHelper extends BasePage
{

    /** driver. */
    private WebDriver driver;

    /**
     * Instanciation de alert helper.
     *
     * @param driver
     */
    public AlertHelper(WebDriver driver)
    {
        this.driver = driver;
        log.debug("AlertHelper : " + this.driver.hashCode());
    }

    /**
     * Accesseur de l attribut alert.
     *
     * @return alert
     */
    public Alert getAlert()
    {
        log.debug("");
        return driver.switchTo().alert();
    }

    /**
     * methode Accept alert.
     */
    public void acceptAlert()
    {
        log.info("");
        getAlert().accept();
    }

    /**
     * methode Dismiss alert.
     */
    public void dismissAlert()
    {
        log.info("");
        getAlert().dismiss();
    }

    /**
     * Accesseur de l attribut alert text.
     *
     * @return alert text
     */
    public String getAlertText()
    {
        String text = getAlert().getText();
        log.info(text);
        return text;
    }

    /**
     * Verifie si alert present.
     *
     * @return true, si c'est alert present
     */
    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            log.info("true");
            return true;
        }
        catch (NoAlertPresentException e)
        {
            // Ignore
            log.info("false");
            return false;
        }
    }

    /**
     * methode Accept alert if present.
     */
    public void acceptAlertIfPresent()
    {
        if (!isAlertPresent())
            return;
        acceptAlert();
        log.info("");
    }

    /**
     * methode Dismiss alert if present.
     */
    public void dismissAlertIfPresent()
    {

        if (!isAlertPresent())
            return;
        dismissAlert();
        log.info("");
    }

    /**
     * methode Accept prompt.
     *
     * @param text
     */
    public void acceptPrompt(String text)
    {

        if (!isAlertPresent())
            return;

        Alert alert = getAlert();
        alert.sendKeys(text);
        alert.accept();
        log.info(text);
    }
}
