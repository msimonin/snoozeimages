package org.inria.myriads.snoozeimages.communication.rest.api;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;

/**
 * 
 * Image Repository API.
 * 
 * @author msimonin
 *
 */
public interface ImageRepositoryAPI
{

    /**
     * 
     * Gets the image detail.
     * 
     * 
     * @return Image.
     */
    @Get
    VirtualMachineImage getImage();
    
    /**
     * 
     * Deletes the image.
     * 
     * @return true iff everything is ok.
     */
    @Delete
    boolean deleteImage();
    
    
}
