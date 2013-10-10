package org.inria.myriads.snoozeimages.image;

/**
 * 
 * Single image representation.
 * 
 * @author msimonin
 *
 */
public class Image 
{
    /** The name.*/
    private String name_;
    
    /** The path. */
    private String path_;
    
    /** The format. */
    private String format_;

    /**
     * @param name_
     */
    public Image() 
    {
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name_;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        name_ = name;
    }

    /**
     * 
     * Gets the path.
     * 
     * @return the path_
     */
    public String getPath() 
    {
        return path_;
    }

    /**
     * sets the path.
     * 
     * @param path the path to set
     */
    public void setPath(String path)
    {
        path_ = path;
    }

    /**
     * @return the format
     */
    public String getFormat()
    {
        return format_;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format)
    {
        format_ = format;
    }
    
    
    
}
