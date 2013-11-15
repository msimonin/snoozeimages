package org.inria.myriads.snoozeimages.imagerepository.api.impl;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImage;
import org.inria.myriads.snoozecommon.virtualmachineimage.VirtualMachineImageList;

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
    public VirtualMachineImageList getImagesList() 
    {
       VirtualMachineImageList imageList = new VirtualMachineImageList();
       ArrayList<VirtualMachineImage> images = imageList.getImages();
       VirtualMachineImage image = new VirtualMachineImage();
       image.setName("image1");
       VirtualMachineImage image2 = new VirtualMachineImage();
       image2.setName("image2");
       images.add(image);
       images.add(image2);
       return imageList;
    }

    @Override
    public VirtualMachineImage getImage(String imageIdentifier) {
        // TODO Auto-generated method stub
        return null;
    }

}
