package org.inria.myriads.snoozeimages.configurator.repositorysettings;

/**
 * 
 * Libvirt settings.
 * 
 * @author msimonin
 *
 */
public class LibvirtSettings 
{
    /** port. */
    private int port_;

    /**
     * Empty constructor. 
     */
    public LibvirtSettings() 
    {
    }

    /**
     * @return the port
     */
    public int getPort() 
    {
        return port_;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) 
    {
        port_ = port;
    }
    
    
}
