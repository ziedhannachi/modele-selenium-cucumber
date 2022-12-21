package com.automation.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class DateTimeHelper DOCUMENTEZ_MOI.
 */
public class DateTimeHelper
{

    /**
     * Accesseur de l attribut current date time.
     *
     * @return current date time
     */
    public static String getCurrentDateTime()
    {

        DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
        Calendar cal = Calendar.getInstance();
        String time = "" + dateFormat.format(cal.getTime());
        return time;
    }

    /**
     * Accesseur de l attribut current date.
     *
     * @return current date
     */
    public static String getCurrentDate()
    {
        return getCurrentDateTime().substring(0, 11);
    }

}