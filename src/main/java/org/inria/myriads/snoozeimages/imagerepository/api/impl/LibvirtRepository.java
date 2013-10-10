package org.inria.myriads.snoozeimages.imagerepository.api.impl;

import java.util.ArrayList;

import org.inria.myriads.snoozeimages.image.Image;
import org.inria.myriads.snoozeimages.imagerepository.api.ImageRepository;
import org.inria.myriads.snoozeimages.volumeparser.api.impl.LibvirtVolumeParser;
import org.libvirt.Connect;
import org.libvirt.LibvirtException;
import org.libvirt.StoragePool;
import org.libvirt.StorageVol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Libvirt pool based repository.
 * 
 * @author msimonin
 *
 */
public class LibvirtRepository implements ImageRepository 
{
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(LibvirtRepository.class);
    
    /** Libvirt connection. */
    private Connect connect_;

    /** The storage pool.*/
    private StoragePool storage_;

    private LibvirtVolumeParser volumeParser_; 
    
    /**
     * Constructor.
     */
    public LibvirtRepository() 
    {
        log_.debug("Connection to the libvirt driver in progress");
        try
        {
        connect_ = new Connect("qemu+tcp://localhost:16509/system");
        storage_ = connect_.storagePoolLookupByName("default");
        volumeParser_ = new LibvirtVolumeParser();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        log_.debug("Connection to th libvirt driver established");
    }

    @Override
    public ArrayList<Image> getImagesList() 
    {
        ArrayList<Image> images = new ArrayList<Image>();
        try
        {
            for (String volume : storage_.listVolumes())
            {
                try
                {
                    Image image = toImage(storage_.storageVolLookupByName(volume));
                    images.add(image);
                }
                catch (LibvirtException exception)
                {
                    log_.error("Unable to retrieve image information from the storage pool");
                    log_.debug(exception.getMessage());
                    continue;
                }
                
            }
        }
        catch (LibvirtException exception)
        {
            log_.error("Unable to retrive the volume list from the storage pool");
            log_.debug(exception.getMessage());
        }
       return images;
       
    }

    
    /**
     * 
     * Fill image object.
     * 
     * @param volume            The volume
     * @return  the image
     * @throws LibvirtException libvirt exceotion.
     */
    private Image toImage(StorageVol volume) throws LibvirtException
    {
        Image image = new Image();
        image.setName(volume.getName());
        image.setPath(volume.getPath());
        image.setFormat(volumeParser_.getFormatType(volume.getXMLDesc(0)));
        return image;
    }

    @Override
    public Image getImage(String imageIdentifier) 
    {
        Image image = null;
        try 
        {
            StorageVol volume = storage_.storageVolLookupByName(imageIdentifier);
            image = toImage(volume);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return image;
    }

}
