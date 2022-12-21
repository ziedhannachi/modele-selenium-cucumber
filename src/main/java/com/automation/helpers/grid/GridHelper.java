package com.automation.helpers.grid;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.helpers.generic.GenericHelper;

/**
 * Class GridHelper.
 */
public class GridHelper extends GenericHelper
{

    /** o log. */
    private Logger oLog = LogManager.getLogger(GridHelper.class);

    /**
     * Instanciation de grid helper.
     *
     * @param driver 
     */
    public GridHelper(WebDriver driver)
    {
        super(driver);
    }

    /**
     * Accesseur de l attribut header xpath.
     *
     * @param tableIdoRxPath 
     * @return header xpath
     */
    protected String getHeaderXpath(String tableIdoRxPath)
    {
        oLog.debug(tableIdoRxPath);
        return isElementPresentQuick(By.id(tableIdoRxPath)) ? "//table[@id='" + tableIdoRxPath + "']//thead" : tableIdoRxPath + "//thead";
    }

    /**
     * Accesseur de l attribut table body xpath.
     *
     * @param tableIdoRxPath 
     * @return table body xpath
     */
    protected String getTableBodyXpath(String tableIdoRxPath)
    {
        oLog.debug(tableIdoRxPath);
        return isElementPresentQuick(By.id(tableIdoRxPath)) ? "//table[@id='" + tableIdoRxPath + "']//tbody" : tableIdoRxPath + "//tbody";
    }

    /**
     * Accesseur de l attribut grid element.
     *
     * @param tableIdoRxPath 
     * @param row            
     * @param column         
     * @return grid element
     */
    protected WebElement getGridElement(String tableIdoRxPath, int row, int column)
    {

        WebElement element;

        if ((element =
            getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]//input"))) != null)
        {
            oLog.debug(element);
            return element;
        }
        else if ((element =
            getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]/a"))) != null)
        {
            oLog.debug(element);
            return element;
        }
        else if ((element =
            getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]/button"))) != null)
        {
            oLog.debug(element);
            return element;
        }
        else if ((element =
            getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]"))) != null)
        {
            oLog.debug(element);
            return element;
        }
        return null;
    }

    /**
     * methode Search in grid.
     *
     * @param description    
     * @param tableIdoRxPath 
     * @param row            
     * @param column         
     * @return int
     */
    protected int searchInGrid(String description, String tableIdoRxPath, int row, final int column)
    {

        WebElement element;

        while ((element =
            getElementWithNull(By.xpath(getTableBodyXpath(tableIdoRxPath) + "//tr[" + row + "]//td[" + column + "]"))) != null)
        {

            if (!element.getText().isEmpty())
            {
                oLog.info(element.getText());
                if (element.getText().trim().contains(description))
                    return row;
            }
            row++;
        }

        throw new IllegalArgumentException("No matching description found : " + description);
    }

    /**
     * Accesseur de l attribut grid heading.
     *
     * @param tableIdoRxPath 
     * @return grid heading
     */
    public List<String> getGridHeading(String tableIdoRxPath)
    {
        List<String> header = new LinkedList<String>();

        int j = 1;
        WebElement element;

        while ((element = (getElementWithNull(By.xpath(getHeaderXpath(tableIdoRxPath) + "//tr[1]//th[" + j + "]")))) != null)
        {
            if (!element.getText().isEmpty())
            {
                header.add(element.getText().trim());
                oLog.info(element.getText().trim());
            }
            j++;
        }
        return header;
    }

    /**
     * Accesseur de l attribut grid column text.
     *
     * @param tableIdoRxPath 
     * @param row            
     * @param column         
     * @return grid column text
     */
    public String getGridColumnText(String tableIdoRxPath, int row, int column)
    {
        oLog.info(tableIdoRxPath + "," + row + "," + column);
        WebElement element = getGridElement(tableIdoRxPath, row, column);
        return element == null ? "" : element.getText().trim();
    }

    /**
     * methode Type in grid.
     *
     * @param tableIdoRxPath 
     * @param row            
     * @param column         
     * @param value          
     */
    public void typeInGrid(String tableIdoRxPath, int row, int column, String value)
    {
        oLog.info(tableIdoRxPath + "," + row + "," + column + "," + value);
        WebElement element = getGridElement(tableIdoRxPath, row, column);
        element.clear();
        element.sendKeys(value);
    }

    /**
     * methode Type in grid.
     *
     * @param description    
     * @param tableIdoRxPath 
     * @param row            
     * @param column        
     * @param value         
     */
    public void typeInGrid(String description, String tableIdoRxPath, int row, int column, String value)
    {
        oLog.info(tableIdoRxPath + "," + row + "," + column + "," + value + "," + description);
        int index = searchInGrid(description, tableIdoRxPath, row, column);
        typeInGrid(tableIdoRxPath, index, 3, value);
    }

}
