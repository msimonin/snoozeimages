package org.inria.myriads.snoozeimages.communication.rest.api;

import java.util.ArrayList;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface ImagesRepositoryAPI
{
    /**
     * 
     * Gets the list of image in the repository.
     * 
     * @return Image list.
     */
    @Get
    public ArrayList<VirtualMachineImage> getImagesList();
    
    

    
}
