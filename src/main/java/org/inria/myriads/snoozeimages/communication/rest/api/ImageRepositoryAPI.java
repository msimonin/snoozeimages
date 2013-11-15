package org.inria.myriads.snoozeimages.communication.rest.api;

import java.util.ArrayList;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

public interface ImageRepositoryAPI
{

    /**
     * 
     * Gets an image detail.
     * 
     * 
     * @return Image.
     */
    @Get
    public VirtualMachineImage getImage();
    
}
