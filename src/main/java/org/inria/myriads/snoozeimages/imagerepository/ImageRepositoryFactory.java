package org.inria.myriads.snoozeimages.imagerepository;

import org.inria.myriads.snoozeimages.configurator.repositorysettings.ImageRepositorySettings;
import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozeimages.imagerepository.api.impl.LibvirtRepository;

/**
 * 
 * Image Repository Factory.
 * 
 * @author msimonin
 *
 */
public final class ImageRepositoryFactory 
{

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
    public ImageRepository newImageRepository(ImageRepositorySettings settings)
    {
        return new LibvirtRepository();
        
    }
}
