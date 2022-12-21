package com.automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceHelper
{

    /**
     * Accesseur de l attribut resource path.
     *
     * @param resource
     * @return resource path
     */
    public static String getResourcePath(String resource)
    {
        String path = getBaseResourcePath() + resource;
        return path;
    }

    /**
     * Accesseur de l attribut base resource path.
     *
     * @return base resource path
     */
    public static String getBaseResourcePath()
    {
        String path = ResourceHelper.class.getClass().getResource("/").getPath();
        return path;
    }

    /**
     * Accesseur de l attribut resource path input stream.
     *
     * @param resource
     * @return resource path input stream
     * @throws FileNotFoundException the file not found exception
     */
    public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException
    {
        return new FileInputStream(ResourceHelper.getResourcePath(resource));
    }

}