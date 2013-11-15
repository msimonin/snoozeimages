package org.inria.myriads.snoozeimages.backend;

import org.inria.myriads.snoozeimages.configurator.api.ImageServiceConfiguration;
import org.inria.myriads.snoozeimages.configurator.repositorysettings.ImageRepositorySettings;
import org.inria.myriads.snoozeimages.imagerepository.ImageRepositoryFactory;
import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozeimages.imagerepository.api.impl.LibvirtRepository;

/**
 * 
 * Image service backend.
 * 
 * @author msimonin
 *
 */
public class ImageServiceBackend 
{

    /** Image repository. */
    private ImageRepository repository_;
    
    /** Image repository settings. */
    private ImageServiceConfiguration imageServiceConfiguration_;
    
    /**
     * 
     * Constructor.
     * 
     * @param imageServiceConfiguration     Configuration.
     */
    public ImageServiceBackend(ImageServiceConfiguration imageServiceConfiguration) 
    {
        imageServiceConfiguration_ = imageServiceConfiguration;
        ImageRepositorySettings imageRepositorySettings = imageServiceConfiguration.getImageRepositorySettings();
        repository_ = ImageRepositoryFactory.newImageRepository(imageRepositorySettings);
    }

    /**
     * 
     * Gets the image repository.
     * 
     * @return  the image repository.
     */
    public ImageRepository getRepository() 
    {
        return repository_;
    }

}
