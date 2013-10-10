package org.inria.myriads.snoozeimages.resource;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.backend.ImageServiceBackend;
import org.inria.myriads.snoozeimages.image.Image;
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
public class ImageServiceResource extends ServerResource 
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
    
    
    /**
     * 
     * Gets the list of images.
     * 
     * @return  the list of image.
     */
    @Get("?getImageList")
    public ArrayList<Image> getImagesList()
    {
        log_.debug("Received an image list request");
        return backend_.getRepository().getImagesList();
    }
    
    @Get("?getImage")
    public Image getImage()
    {
        String name = getQuery().getFirstValue("name");   
        log_.debug(String.format("Received an image info request for id %s", name));
        return backend_.getRepository().getImage(name);
    }
    
}
