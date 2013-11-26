package org.inria.myriads.snoozeimages.imagerepository.api.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImageList;
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
    /** image list.*/
    private VirtualMachineImageList imageList_;
    
    /**
     * Constructor. 
     */
    public TestRepository()
    {
        imageList_ = new VirtualMachineImageList();
        ArrayList<VirtualMachineImage> images = imageList_.getImages();
        VirtualMachineImage image = new VirtualMachineImage();
        image.setName("image1");
        VirtualMachineImage image2 = new VirtualMachineImage();
        image2.setName("image2");
        images.add(image);
        images.add(image2);

    }

    @Override
    public VirtualMachineImageList getImagesList() 
    {
       return imageList_;
    }

    @Override
    public VirtualMachineImage getImage(String imageIdentifier) 
    {
        for (VirtualMachineImage image :imageList_.getImages())
        {
            if (image.getName().equals(imageIdentifier))
            {
                return image;
            }
        }
        return null;
    }

    @Override
    public boolean deleteImage(String imageIdentifier)
    {
        
        Iterator<VirtualMachineImage> it = imageList_.getImages().iterator();
        while (it.hasNext())
        {
            VirtualMachineImage image = (VirtualMachineImage) it.next();
            if (image.getName().equals(imageIdentifier))
            {
                it.remove();
            }
        }
        return true;
    }

}
