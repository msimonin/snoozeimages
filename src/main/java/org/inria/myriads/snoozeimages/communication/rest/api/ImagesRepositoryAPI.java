package org.inria.myriads.snoozeimages.communication.rest.api;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImageList;
import org.restlet.resource.Get;

/**
 * 
 * Images Reposirory API.
 * 
 * @author msimonin
 *
 */
public interface ImagesRepositoryAPI
{
    /**
     * 
     * Gets the list of image in the repository.
     * 
     * @return Image list.
     */
    @Get
    VirtualMachineImageList getImagesList();
    
}
