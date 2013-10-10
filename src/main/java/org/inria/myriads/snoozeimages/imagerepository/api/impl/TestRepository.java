package org.inria.myriads.snoozeimages.imagerepository.api.impl;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.image.Image;
import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;

/**
 * 
 * Test image repository. 
 * 
 * @author msimonin
 *
 */
public class TestRepository implements ImageRepository 
{

    @Override
    public ArrayList<Image> getImagesList() 
    {
       ArrayList<Image> images = new ArrayList<Image>();
       Image image = new Image();
       image.setName("image1");
       Image image2 = new Image();
       image2.setName("image2");
       images.add(image);
       images.add(image2);
       return images;
    }

    @Override
    public Image getImage(String imageIdentifier) {
        // TODO Auto-generated method stub
        return null;
    }

}
