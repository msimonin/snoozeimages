package org.inria.myriads.snoozeimages.resource;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.backend.ImageServiceBackend;
import org.inria.myriads.snoozeimages.communication.rest.api.ImageRepositoryAPI;
import org.inria.myriads.snoozeimages.communication.rest.api.ImagesRepositoryAPI;
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
public class ImageResource extends ServerResource implements ImageRepositoryAPI
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ImageResource.class);
    
    /** backend. */
    private ImageServiceBackend backend_;
    
    /**
     * Constructor.
     */
    public ImageResource() 
    {
        super();
        log_.debug("Starting image service resource");
        backend_ = (ImageServiceBackend) getApplication().getContext().getAttributes().get("backend");
    }
    
    @Override
    public VirtualMachineImage getImage()
    {
        VirtualMachineImage image = null ;
        try
        {
            String imageIdentifier = (String) this.getRequest().getAttributes().get("imageIdentifier");
            log_.debug(String.format("Received an image info request for id %s", imageIdentifier));
            image = backend_.getRepository().getImage(imageIdentifier);
        }
        catch (Exception e)
        {
            log_.error("Unable to get the image identifier from the request");
        }
        return image;
    }
    
}
