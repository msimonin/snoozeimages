package org.inria.myriads.snoozeimages.imagerepository.api;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImageList;

/**
 * 
 * Image Repository.
 * 
 * @author msimonin
 *
 */
public interface ImageRepository 
{
    /**
     * 
     * Gets the image list from the repository.
     * 
     * @return Images list.
     */
     VirtualMachineImageList getImagesList();
     
     
     /**
      * 
      * Gets a image.
      * 
      * @param imageIdentifier      the image identifier.
      * @return the image or null.
      */
    VirtualMachineImage getImage(String imageIdentifier);
     
}
