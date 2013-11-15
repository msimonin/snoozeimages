package org.inria.myriads.snoozeimages.imagerepository;

import org.inria.myriads.snoozeimages.configurator.repositorysettings.ImageRepositorySettings;
import org.inria.myriads.snoozeimages.configurator.repositorysettings.LibvirtSettings;
import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozeimages.imagerepository.api.impl.LibvirtRepository;
import org.inria.myriads.snoozeimages.imagerepository.api.impl.TestRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Image Repository Factory.
 * 
 * @author msimonin
 *
 */
public final class ImageRepositoryFactory 
{    
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ImageRepositoryFactory.class);

    /**
     * Hide Constructor.
     */
    private ImageRepositoryFactory() 
    {
       throw new UnsupportedOperationException();
    }
    
    
    /**
     * 
     * Creates a new Image Repository.
     * 
     * @param settings  The settings
     * @return  the image repository
     */
    public static ImageRepository newImageRepository(ImageRepositorySettings settings)
    {
        ImageRepositoryType type = settings.getType();
        switch (type)
        {
        case libvirt:
            log_.debug("Creating new libvirt repository");
            LibvirtSettings libvirtSettings = settings.getLibvirtSettings();
            return new LibvirtRepository(libvirtSettings);
        case test:
            log_.debug("Creating new test repository");
            return new TestRepository();
        default:
            break;
        }
        return new TestRepository();
       
    }
}
