package org.inria.myriads.snoozeimages.imagerepository.api;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.image.Image;

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
     ArrayList<Image> getImagesList();
     
     
     /**
      * 
      * Gets a image.
      * 
      * @param imageIdentifier      the image identifier.
      * @return the image or null.
      */
    Image getImage(String imageIdentifier);
     
}
