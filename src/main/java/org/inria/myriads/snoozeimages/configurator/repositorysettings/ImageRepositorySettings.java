package org.inria.myriads.snoozeimages.configurator.repositorysettings;

import org.inria.myriads.snoozeimages.imagerepository.ImageRepositoryType;

/**
 * 
 * Image Repository settings.
 * 
 * @author msimonin
 *
 */
public class ImageRepositorySettings 
{
    /** Image Repository type.*/
    private ImageRepositoryType type_;

    /** Libvirt Settings. */
    private LibvirtSettings libvirtSettings_;

    
    /**
     * Empty Constructor.
     */
    public ImageRepositorySettings()
    {
        libvirtSettings_ = new LibvirtSettings();
    }

    /**
     * @return the type_
     */
    public ImageRepositoryType getType() 
    {
        return type_;
    }

    /**
     * @param type the type to set
     */
    public void setType(ImageRepositoryType type)
    {
        this.type_ = type;
    }

    /**
     * 
     * Gets the libvirt Settings.
     * 
     * @return  the libvirt settings.
     */
    public LibvirtSettings getLibvirtSettings() 
    {
        return libvirtSettings_;
    }
    
    
    
    
}
