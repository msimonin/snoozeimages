package org.inria.myriads.snoozeimages.resource;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.backend.ImageServiceBackend;
import org.inria.myriads.snoozeimages.communication.rest.api.ImageRepositoryAPI;
import org.inria.myriads.snoozeimages.virtualmachineimage.VirtualMachineImage;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * The image repository resource.
 * 
 * @author msimonin
 *
 */
public class ImageServiceResource extends ServerResource implements ImageRepositoryAPI
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ImageServiceResource.class);
    
    /** backend. */
    private ImageServiceBackend backend_;
    
    /**
     * Constructor.
     */
    public ImageServiceResource() 
    {
        super();
        log_.debug("Starting image service resource");
        backend_ = (ImageServiceBackend) getApplication().getContext().getAttributes().get("backend");
    }
    
    
    @Override
    public ArrayList<VirtualMachineImage> getImagesList()
    {
        log_.debug("Received an image list request");
        return backend_.getRepository().getImagesList();
    }
    
    @Override
    public VirtualMachineImage getImage(String imageIdentifier)
    {
        log_.debug(String.format("Received an image info request for id %s", imageIdentifier));
        return backend_.getRepository().getImage(imageIdentifier);
    }
    
}
