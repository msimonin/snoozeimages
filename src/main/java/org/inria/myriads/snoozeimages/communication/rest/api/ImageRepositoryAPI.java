package org.inria.myriads.snoozeimages.communication.rest.api;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.virtualmachineimage.VirtualMachineImage;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface ImageRepositoryAPI
{
    /**
     * 
     * Gets the list of image in the repository.
     * 
     * @return Image list.
     */
    @Get("?getImageList")
    public ArrayList<VirtualMachineImage> getImagesList();
    
    
    /**
     * 
     * Gets an image detail.
     * 
     * @param imageIdentifier   the image identifier.
     * @return Image.
     */
    @Post("?getImage")
    public VirtualMachineImage getImage(String imageIdentifier);
    
}
