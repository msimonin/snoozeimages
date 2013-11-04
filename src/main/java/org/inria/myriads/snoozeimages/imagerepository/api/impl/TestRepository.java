package org.inria.myriads.snoozeimages.imagerepository.api.impl;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;

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
    public ArrayList<VirtualMachineImage> getImagesList() 
    {
       ArrayList<VirtualMachineImage> images = new ArrayList<VirtualMachineImage>();
       VirtualMachineImage image = new VirtualMachineImage();
       image.setName("image1");
       VirtualMachineImage image2 = new VirtualMachineImage();
       image2.setName("image2");
       images.add(image);
       images.add(image2);
       return images;
    }

    @Override
    public VirtualMachineImage getImage(String imageIdentifier) {
        // TODO Auto-generated method stub
        return null;
    }

}
