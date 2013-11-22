package org.inria.myriads.snoozeimages.resource;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImageList;
import org.inria.myriads.snoozeimages.backend.ImageServiceBackend;
import org.inria.myriads.snoozeimages.communication.rest.api.ImagesRepositoryAPI;
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
public class ImagesResource extends ServerResource implements ImagesRepositoryAPI
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ImagesResource.class);
    
    /** backend. */
    private ImageServiceBackend backend_;
    
    /**
     * Constructor.
     */
    public ImagesResource() 
    {
        super();
        log_.debug("Starting image service resource");
        backend_ = (ImageServiceBackend) getApplication().getContext().getAttributes().get("backend");
    }
    
    
    @Override
    public VirtualMachineImageList getImagesList()
    {
        log_.debug("Received an image list request");
        return backend_.getRepository().getImagesList();
    }
    
    
    
}
